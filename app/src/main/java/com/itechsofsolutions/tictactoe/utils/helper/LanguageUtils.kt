package com.itechsofsolutions.tictactoe.utils.helper

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.LocaleList
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils
import java.util.*


/**
 * This is a singleton class that contains utils to work with `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)`.
 *
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
object LanguageUtils {
    private const val SELECTED_LANGUAGE = "Language.Utils.Selected.Language"

    /**
     * This method sets application locale with default locale persisted in [SharedPreferences] on
     * each new launch of the application and returns Context having application default locale
     * for all activities
     *
     * @param context application context
     * @return modified application context
     * */
    fun onAttach(context: Context , defaultLanguage: String = Locale.getDefault().language): Context {
        val language = getStoredLanguage(defaultLanguage)
        return setLanguage(context, language)
    }

    /**
     * This method returns `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code stored at [SharedPreferences]
     *
     * @return stored `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)`
     * */
    fun getLanguage(): String {
        return getStoredLanguage(Locale.getDefault().language)
    }

    /**
     * This method stores new `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code [SharedPreferences] and
     * updates application default locale. Returns context having application default locale.
     *
     * @param context application context
     * @param language `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code
     * @return modified application context
     * */
    fun setLanguage(context: Context, language: String): Context {
        storeLanguage(language)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, language)
        } else {
            updateResourcesLegacy(context, language)
        }
    }

    /**
     * This method stores new `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code [SharedPreferences] and
     * updates application default locale. Returns context having application default locale.
     *
     * @param intent intent with target activity to be restarted
     * @param context application context
     * @param language `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code
     * @return modified application context
     * */
    fun setLanguageAndRestartApplication(intent: Intent , context: Context , language: String): Context {
        val modifiedContext = setLanguage(context, language)
        AndroidUtils.restartApplication(intent, context)
        return modifiedContext
    }

    /**
     * This method returns `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code persisted in [SharedPreferences]
     *
     * @param defaultLanguage default `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code if no `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code is found in the storage
     * @return `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code
     * */
    fun getStoredLanguage(defaultLanguage: String): String {
        return SharedPrefUtils.readString(SELECTED_LANGUAGE, defaultLanguage)
    }

    /**
     * This method stores new `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code at [SharedPreferences]
     *
     * @param language `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code
     * @return if the `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code was saved or not
     * */
    private fun storeLanguage(language: String): Boolean {
        return SharedPrefUtils.write(SELECTED_LANGUAGE, language)
    }

    /**
     * For android device versions above Nougat (7.0)
     * This method updates application default locale configurations and returns new context object
     * for the current context but whose resources are adjusted to match the given Configuration
     *
     * @param context application context
     * @param language `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code
     * @return modified application context
     * */
    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val localeList = LocaleList(locale)

        val config = context.resources.configuration.apply {
            setLocales(localeList)
        }

        return context.createConfigurationContext(config)
    }

    /**
     * For android device versions below Nougat (7.0)
     * This method updates application default locale configurations and returns new context object
     * for the current context but whose resources are adjusted to match the given Configuration
     *
     * @param context application context
     * @param language `SharedPrefUtils.readString(Constants.PreferenceKeys.LANGUAGE_CODE)` code
     * @return modified application context
     * */
    private fun updateResourcesLegacy(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources

        val config = resources.configuration
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)

        return context
    }
}
