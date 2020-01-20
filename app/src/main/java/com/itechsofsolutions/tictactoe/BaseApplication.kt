package com.itechsofsolutions.tictactoe

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.itechsofsolutions.tictactoe.BaseApplication.Companion.sInstance
import com.itechsofsolutions.tictactoe.utils.helper.Constants
import com.itechsofsolutions.tictactoe.utils.helper.LanguageUtils
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils
import timber.log.Timber

/**
 * This is the Application class of the project. As we want to enable multi-dex inorder to
 * have greater quantity of methods, we are extending [MultiDexApplication] class here.
 * @property sInstance an instance of this Application class
 * @author Mohd. Asfaq-E-Azam Rifat
 */
class BaseApplication : MultiDexApplication() {

    init {
        sInstance = this
    }

    companion object {
        private lateinit var sInstance: BaseApplication

        /**
         * This method provides the Application context
         * @return [Context] application context
         */
        fun getBaseApplicationContext(): Context {
            return sInstance.applicationContext
        }
    }

   /* override fun onCreate() {
        super.onCreate()
        DataUtils.getAndroidHashKey()
        FirebaseApp.initializeApp(this)
        if (applicationContext != null) {
            if (BuildConfig.DEBUG) {
                initiateOnlyInDebugMode(applicationContext)
            }
            initiate(applicationContext)
            DatabaseUtil.init(applicationContext)
            FirebaseMessaging.getInstance().subscribeToTopic("flash_sale")
        }
    }*/

    /**
     * This method only executes in debug build. Therefore, we can place our debug build specific
     * initialization here. i.e, logging library, app data watcher library etc.
     * */
    private fun initiateOnlyInDebugMode(context: Context) {
        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String? {
                return super.createStackElementTag(element) +
                        " - Method:${element.methodName} - Line:${element.lineNumber}"
            }
        })
    }

    /**
     * This method executes in every build mode. Therefore, we can place our essential and common
     * initialization here. i.e, base repository, usable libraries etc
     * */
    private fun initiate(context: Context) {
       // BaseRepository.init(context)

    }

    override fun attachBaseContext(base: Context?) {
        SharedPrefUtils.init(base!!)
        val context = LanguageUtils.onAttach(base, Constants.Default.DEFAULT_LANGUAGE)
        super.attachBaseContext(context)
        MultiDex.install(context)
    }
}