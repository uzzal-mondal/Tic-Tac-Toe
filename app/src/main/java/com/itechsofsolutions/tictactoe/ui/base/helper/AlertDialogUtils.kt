package com.itechsofsolutions.tictactoe.ui.base.helper

import android.content.Context
import android.content.DialogInterface
import android.graphics.Typeface
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.itechsofsolutions.tictactoe.R
import com.itechsofsolutions.tictactoe.utils.helper.ViewUtils

//import timber.log.Timber

/**
 * This is a class that contains utils for alert dialogs
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
class AlertDialogUtils private constructor() {
    private var mAlertDialog: AlertDialog? = null

    /**
     * This method builds an alert dialog and returns it upon showing
     *
     * @param context UI context
     * @param isCancelable if the dialog is cancelable upon tapping out of the dialog
     * @param positiveButtonText text of the positive button
     * @param positiveButtonListener listener for the positive button click event
     * @param negativeButtonText text of the negative button
     * @param negativeButtonListener listener for the negative button click event
     * @param message message to be shown in the dialog
     * @param title title of the dialog
     * @param desiredTypeface custom font for the dialog
     * @return the created dialog
     * */
    fun showNativeDialog(context: Context, isCancelable: Boolean,
                         positiveButtonText: String?,
                         positiveButtonListener: DialogInterface.OnClickListener?,
                         negativeButtonText: String?,
                         negativeButtonListener: DialogInterface.OnClickListener?,
                         message: String,
                         title: String?,
                         desiredTypeface: Typeface?): AlertDialog? {

       // Timber.d((context as Activity).javaClass.simpleName)
        val builder = AlertDialog.Builder(context)
        builder.setCancelable(isCancelable)
        builder.setMessage(message)

        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title)
        }

        if (!TextUtils.isEmpty(positiveButtonText)) {
            builder.setPositiveButton(positiveButtonText, positiveButtonListener)
        }

        if (!TextUtils.isEmpty(negativeButtonText)) {
            builder.setNegativeButton(negativeButtonText, negativeButtonListener)
        }

        mAlertDialog = builder.create()
        mAlertDialog?.show()

        if (!TextUtils.isEmpty(title) && desiredTypeface != null) {
            val textViewTitle: TextView? = mAlertDialog?.findViewById(R.id.alertTitle)
            if (textViewTitle != null) {
                textViewTitle.typeface = desiredTypeface
            }
        }

        if (desiredTypeface != null) {
            val textViewMessage: TextView? = mAlertDialog?.findViewById(android.R.id.message)
            if (textViewMessage != null) {
                textViewMessage.typeface = desiredTypeface
            }
        }

        if (!TextUtils.isEmpty(positiveButtonText) && desiredTypeface != null) {
            val buttonPositive: Button? = mAlertDialog?.findViewById(android.R.id.button1)
            if (buttonPositive != null) {
                buttonPositive.typeface = desiredTypeface
            }
        }

        if (!TextUtils.isEmpty(negativeButtonText) && desiredTypeface != null) {
            val buttonNegative: Button? = mAlertDialog?.findViewById(android.R.id.button2)
            if (buttonNegative != null) {
                buttonNegative.typeface = desiredTypeface
            }
        }

        mAlertDialog?.getButton(DialogInterface.BUTTON_POSITIVE)?.setTextColor(
                ViewUtils.getColor(R.color.colorPrimary))

        mAlertDialog?.getButton(DialogInterface.BUTTON_NEGATIVE)?.setTextColor(
                ViewUtils.getColor(R.color.colorPrimary))

        return mAlertDialog
    }

    /**
     * This method hides if there is any previously created alert dialog
     * */
    fun hideDialog() {
        if (mAlertDialog != null) {
            mAlertDialog!!.dismiss()
            mAlertDialog = null
        }
    }

    companion object {
        private var sInstance: AlertDialogUtils? = null

        fun on(): AlertDialogUtils {
            if (sInstance == null) {
                sInstance = AlertDialogUtils()
            }

            return sInstance as AlertDialogUtils
        }
    }
}
