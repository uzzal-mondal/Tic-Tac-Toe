package com.itechsofsolutions.tictactoe.utils.libs

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.itechsofsolutions.tictactoe.R
import com.itechsofsolutions.tictactoe.utils.helper.DataUtils
import com.itechsofsolutions.tictactoe.utils.helper.imagepicker.ImagePickerUtils
import com.itechsofsolutions.tictactoe.utils.libs.ImageCropperUtils.mCroppedImage
import com.itechsofsolutions.tictactoe.utils.libs.ImageCropperUtils.mListener
import com.itechsoftsolution.ebay.utils.helper.FileUtils
import com.yalantis.ucrop.UCrop
import java.io.File

/**
 * This is a singleton class that contains utils to work with image cropping. It uses a library
 * called [UCrop] to crop images and do many more operations with image.
 * @property mListener listener of the cropper util
 * @property mCroppedImage output image file of the crop operation
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
object ImageCropperUtils {

    private var mListener: Listener? = null
    private var mCroppedImage: File? = null

    /**
     * This method crops image in square shape using default max width and height
     *
     * @param activity current activity
     * @param sourceUri the image to be cropped
     * @param listener callback to get the states
     * */
    fun cropImage(activity: Activity, sourceUri: Uri, listener: Listener) {
        val destinationUri = getCroppedImageDestinationUri(activity)

        if (destinationUri != null) {
            mListener = listener
            cropImage(activity, null, sourceUri, destinationUri,
                    CropRatio.DEFAULT
            )
        }
    }

    /**
     * This method crops image in square shape using default max width and height
     *
     * @param fragment current fragment
     * @param sourceUri the image to be cropped
     * @param listener callback to get the states
     * */
    fun cropImage(fragment: Fragment, sourceUri: Uri, listener: Listener) {
        if (fragment.context != null) {
            val destinationUri = getCroppedImageDestinationUri(fragment.context!!)

            if (destinationUri != null) {
                mListener = listener
                cropImage(null, fragment, sourceUri, destinationUri,
                        CropRatio.DEFAULT
                )
            }
        }
    }

    /**
     * This method crops image in square shape using default max width and height
     *
     * @param activity current activity
     * @param sourceUri the image to be cropped
     * @param destinationUri the cropped image
     * */
    fun cropImage(activity: Activity, sourceUri: Uri, destinationUri: Uri) {
        cropImage(activity, null, sourceUri, destinationUri,
                CropRatio.DEFAULT
        )
    }

    /**
     * This method crops image in custom shape using default max width and height
     *
     * @param activity current activity
     * @param sourceUri the image to be cropped
     * @param destinationUri the cropped image
     * @param cropRatio crop ratio of the image
     * */
    fun cropImage(activity: Activity, sourceUri: Uri, destinationUri: Uri, cropRatio: CropRatio) {
        cropImage(activity, null, sourceUri, destinationUri, cropRatio)
    }

    /**
     * This method crops image in custom shape using default max width and height
     *
     * @param fragment current fragment
     * @param sourceUri the image to be cropped
     * @param destinationUri the cropped image
     * */
    fun cropImage(fragment: Fragment, sourceUri: Uri, destinationUri: Uri) {
        cropImage(null, fragment, sourceUri, destinationUri,
                CropRatio.DEFAULT
        )
    }

    /**
     * This method crops image with custom params
     *
     * @param fragment current fragment
     * @param sourceUri the image to be cropped
     * @param destinationUri the cropped image
     * @param cropRatio crop ratio of the image
     * */
    private fun cropImage(fragment: Fragment, sourceUri: Uri, destinationUri: Uri, cropRatio: CropRatio) {
        cropImage(null, fragment, sourceUri, destinationUri, cropRatio)
    }

    /**
     * This is the root method to crop image
     * @param activity current activity
     * @param fragment current fragment
     * @param sourceUri path of the image to be cropped
     * @param destinationUri path of the cropped image
     * @param cropRatio crop ratio of the image
     * */
    private fun cropImage(activity: Activity?,
                          fragment: Fragment?,
                          sourceUri: Uri, destinationUri: Uri,
                          cropRatio: CropRatio
    ) {

        val context: Context = when {
            activity != null -> activity
            fragment != null -> fragment.context
            else -> null
        } ?: return

        val options = UCrop.Options()
        options.setActiveWidgetColor(ContextCompat.getColor(context, R.color.colorPrimary))
        options.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
        options.setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimary))
        options.setCompressionQuality(100)
        options.setCompressionFormat(Bitmap.CompressFormat.PNG)

        val cropper = UCrop.of(sourceUri, destinationUri)
                .withOptions(options)

        when (cropRatio) {
            CropRatio.DEFAULT -> {
                cropper.withAspectRatio(1.toFloat(), 1.toFloat())
            }

            CropRatio.SQUARE -> {
                cropper.withAspectRatio(1.toFloat(), 1.toFloat())
            }

            CropRatio.WIDE -> {
                cropper.withAspectRatio(16.toFloat(), 9.toFloat())
            }

            CropRatio.EXTRA_WIDE -> {
                cropper.withAspectRatio(18.toFloat(), 9.toFloat())
            }

            CropRatio.REGULAR -> {
                cropper.withAspectRatio(4.toFloat(), 3.toFloat())
            }

            else -> {
                // Skip
            }
        }

        if (activity != null) {
            cropper.start(activity)
        } else if (fragment != null) {
            cropper.start(context, fragment)
        }
    }

    /**
     * This method provides the uri of the cropped image
     *
     * @param context current UI context
     * */
    fun getCroppedImageDestinationUri(context: Context): Uri? {
        val imageFile = FileUtils.getEmptyFileForSavingCroppedImage(context)

        return if (imageFile != null) {
            mCroppedImage = imageFile
            Uri.fromFile(imageFile)
        } else {
            null
        }
    }

    /**
     * As we don't have access to [Activity.onActivityResult] or [Fragment.onActivityResult]
     * externally. That's why we have put this method at onActivityResult() of our BaseActivity and
     * BaseFragment to get control of the operation. Basically, this method delivers the successful
     * and error result via the listener. Also clears the util if the operation is failed.
     *
     * @param requestCode request code to the crop operation
     * @param resultCode code that defines if the result is ok or not
     * @param data intent that may have our processed data
     * */
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            UCrop.REQUEST_CROP -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        val croppedImageUri = UCrop.getOutput(data)

                        if (croppedImageUri != null) {
                            mListener?.onSuccess(croppedImageUri)
                        } else {
                            mListener?.onError(NullPointerException(
                                    DataUtils.getString(R.string.error_image_uri_is_null)))
                            mCroppedImage?.delete()
                            clearUtil()
                        }

                        ImagePickerUtils.deleteTheImageFile()
                        ImagePickerUtils.clearUtil()
                    }
                } else if (resultCode == UCrop.RESULT_ERROR) {
                    ToastUtils.error(DataUtils.getString(R.string.error_could_not_crop_image))

                    if (data != null && UCrop.getError(data) != null) {
                        mListener?.onError(UCrop.getError(data)!!)
                    }

                    mCroppedImage?.delete()
                    clearUtil()
                    ImagePickerUtils.deleteTheImageFile()
                    ImagePickerUtils.clearUtil()
                } else {
                    mCroppedImage?.delete()
                    clearUtil()
                    ImagePickerUtils.deleteTheImageFile()
                    ImagePickerUtils.clearUtil()
                }
            }

            else -> {
                return
            }
        }
    }

    /**
     * This method clears the util for a fresh operation
     * */
    private fun clearUtil() {
        mListener = null
        mCroppedImage = null
    }

    /**
     * This enum class contains different types of crop ratios for cropping the picked image
     * */
    enum class CropRatio {
        DEFAULT, // 1:1
        SQUARE, // 1:1
        WIDE, // 16:9
        EXTRA_WIDE, // 18:9
        REGULAR, // 4:3
        CUSTOM
    }

    /**
     * This is the callback interface of the [ImageCropperUtils] which contains two methods to
     * deliver the state of an operation.
     * @author Mohd. Asfaq-E-Azam Rifat
     * */
    interface Listener {
        fun onSuccess(imageUri: Uri)
        fun onError(error: Throwable)
    }
}
