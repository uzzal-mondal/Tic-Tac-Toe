package com.itechsofsolutions.tictactoe.utils.helper

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.Signature
import android.net.Uri
import android.os.Build
import android.util.Base64
import android.util.Log
import com.itechsofsolutions.tictactoe.BaseApplication
import timber.log.Timber
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*



/**
 * This is a class that contains utils to work with data
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
class
DataUtils private constructor() {
    companion object {
        /**
         * This method provides an unique id using UUID
         *
         * @return [String] unique string
         * */
        fun getUniqueId(): String {
            return java.util.UUID.randomUUID().toString()
        }

        /**
         * This method provides a random number
         *
         * @param min minimum limit
         * @param max maximum limit
         * @return [Int] random number
         * */
        fun randomInt(min: Int , max: Int): Int {
            return Random().nextInt(max - min + 1) + min
        }

        /**
         * This method returns a local string
         *
         * @param resourceId desired resource id
         * @return desired string
         * */
        fun getString(resourceId: Int): String {
            return BaseApplication.getBaseApplicationContext().getString(resourceId)
        }

        /**
         * This method returns a local integer
         *
         * @param resourceId desired resource id
         * @return desired integer
         * */
        fun getInteger(resourceId: Int): Int {
            return ViewUtils.getResources().getInteger(resourceId)
        }

        /**
         * This method returns a local resource [Uri]
         *
         * @param resourceId desired resource id
         * @return desired [Uri]
         * */
        fun getUriFromResource(resourceId: Int): Uri {
            return Uri.parse(
                    ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                            + AndroidUtils.getApplicationId() + "/" + resourceId
            )
        }

        /**
         * This method returns a converted title case string
         *
         * @param given given string
         * @return desired [String]
         * */
        fun toTitleCase(given: String): String {
            var isSpace = true
            val builder = StringBuilder(given)
            val len = builder.length

            for (i in 0 until len) {
                val char = builder[i]
                if (isSpace) {
                    if (!Character.isWhitespace(char)) {
                        // Convert to title case and switch out of whitespace mode.
                        builder.setCharAt(i , Character.toTitleCase(char))
                        isSpace = false
                    }
                } else if (Character.isWhitespace(char)) {
                    isSpace = true
                } else {
                    builder.setCharAt(i , Character.toLowerCase(char))
                }
            }

            return builder.toString()
        }

        @SuppressLint("InlinedApi" , "LogNotTimber")
        fun getAndroidHashKey() {
            val context = BaseApplication.getBaseApplicationContext()
            try {
                val packageInfo: PackageInfo = context.packageManager.getPackageInfo(
                    context.packageName ,
                    if (AndroidUtils.getCurrentBuildApiVersion() >= Build.VERSION_CODES.P) {
                        PackageManager.GET_SIGNING_CERTIFICATES
                    } else {
                        PackageManager.GET_SIGNATURES
                    }
                )

                var signatures = arrayOf<Signature>()

                if (AndroidUtils.getCurrentBuildApiVersion() >= Build.VERSION_CODES.P) {
                    if (packageInfo.signingInfo != null) {
                        signatures = packageInfo.signingInfo.apkContentsSigners
                    }
                } else {
                    signatures = packageInfo.signatures
                }

                for (signature in signatures) {
                    val messageDigest = MessageDigest.getInstance("SHA")
                    messageDigest.update(signature.toByteArray())
                    val hashKey = String(Base64.encode(messageDigest.digest() , 0))
                    Log.i(Constants.Common.ANDROID_HASH_KEY, hashKey)
                }
            } catch (e: NoSuchAlgorithmException) {
                Timber.e(e)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }



    }
}