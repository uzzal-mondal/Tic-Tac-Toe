package com.itechsofsolutions.tictactoe.utils.libs

import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.widget.Toast
import com.itechsofsolutions.tictactoe.BaseApplication
import es.dmoral.toasty.Toasty

/**
 * This is a singleton class that contains utils to work with toast messages. It uses a library
 * called [Toasty] to show colorful and interactive toast messages.
 *
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
object ToastUtils {
    init {
        Toasty.Config
                .getInstance()
                .tintIcon(true)
                .apply()
    }

    /**
     * This method shows an error toast for short period
     *
     * @param text the text to be shown
     * */
    fun error(text: String) {
        Toasty.error(
            BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, true)
                .show()
    }

    /**
     * This method shows an error toast for defined period
     *
     * @param text the text to be shown
     * @param isLongDuration should the toast stay longer?
     * */
    fun error(text: String, isLongDuration: Boolean) {
        Toasty.error(BaseApplication.getBaseApplicationContext(), text,
                if (isLongDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT, true)
                .show()
    }

    /**
     * This method shows an error toast for short period but without icon
     *
     * @param text the text to be shown
     * */
    fun errorWithoutIcon(text: String) {
        Toasty.error(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, false)
                .show()
    }

    /**
     * This method shows a success toast for short period
     *
     * @param text the text to be shown
     * */
    fun success(text: String) {
        Toasty.success(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, true)
                .show()
    }

    /**
     * This method shows a success toast for defined period
     *
     * @param text the text to be shown
     * @param isLongDuration should the toast stay longer?
     * */
    fun success(text: String, isLongDuration: Boolean) {
        Toasty.success(BaseApplication.getBaseApplicationContext(), text,
                if (isLongDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT, true)
                .show()
    }

    /**
     * This method shows a success toast for short period but without icon
     *
     * @param text the text to be shown
     * */
    fun successWithoutIcon(text: String) {
        Toasty.success(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, false)
                .show()
    }

    /**
     * This method shows an info toast for short period
     *
     * @param text the text to be shown
     * */
    fun info(text: String) {
        Toasty.info(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, true)
                .show()
    }

    /**
     * This method shows an info toast for short period but without icon
     *
     * @param text the text to be shown
     * */
    fun infoWithoutIcon(text: String) {
        Toasty.info(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, false)
                .show()
    }

    /**
     * This method shows a warning toast for short period
     *
     * @param text the text to be shown
     * */
    fun warning(text: String) {
        Toasty.warning(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, true)
                .show()
    }

    /**
     * This method shows warning toast for defined period
     *
     * @param text the text to be shown
     * @param isLongDuration should the toast stay longer?
     * */
    fun warning(text: String, isLongDuration: Boolean) {
        Toasty.warning(BaseApplication.getBaseApplicationContext(), text,
                if (isLongDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT, true)
                .show()
    }

    /**
     * This method shows a warning toast for short period but without icon
     *
     * @param text the text to be shown
     * */
    fun warningWithoutIcon(text: String) {
        Toasty.warning(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, false)
                .show()
    }

    /**
     * This method shows a normal toast with icon for short period
     *
     * @param text the text to be shown
     * */
    fun normalWithIcon(text: String, icon: Drawable) {
        Toasty.normal(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, icon, true)
                .show()
    }

    /**
     * This method shows a normal toast without icon for short period
     *
     * @param text the text to be shown
     * */
    fun normalShort(text: String) {
        Toasty.normal(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_SHORT, null, false)
                .show()
    }

    /**
     * This method shows a normal toast without icon for long period
     *
     * @param text the text to be shown
     * */
    fun normalLong(text: String) {
        Toasty.normal(BaseApplication.getBaseApplicationContext(), text,
                Toast.LENGTH_LONG, null, false)
                .show()
    }

    /**
     * This method shows a custom toast
     *
     * @param text the text to be shown
     * @param icon the icon to be shown
     * @param colorId color of the toast message background
     * @param shortDuration should the toast stay for short time?
     * @param withIcon do you want the toast to show with icon or not?
     * @param shouldTint do you want to put background tint or not?
     * */
    fun custom(text: String, icon: Drawable, colorId: Int, shortDuration: Boolean,
               withIcon: Boolean, shouldTint: Boolean) {
        Toasty.custom(BaseApplication.getBaseApplicationContext(), text,
                icon, colorId,
                if (shortDuration) {
                    Toast.LENGTH_SHORT
                } else {
                    Toast.LENGTH_LONG
                }, withIcon, shouldTint)
                .show()
    }

    /**
     * This method creates and shows a native toast for long period
     *
     * @param text the text to be shown
     * */
    fun nativeLong(text: String) {
        if (!TextUtils.isEmpty(text)) {
            Toast.makeText(BaseApplication.getBaseApplicationContext(),
                    text, Toast.LENGTH_LONG).show()
        }
    }

    /**
     * This method creates and shows a native toast for short period
     *
     * @param text the text to be shown
     * */
    fun nativeShort(text: String) {
        if (!TextUtils.isEmpty(text)) {
            Toast.makeText(BaseApplication.getBaseApplicationContext(),
                    text, Toast.LENGTH_SHORT).show()
        }
    }
}