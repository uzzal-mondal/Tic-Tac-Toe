package com.itechsofsolutions.tictactoe.utils.helper.network


import com.itechsofsolutions.tictactoe.R
import com.itechsofsolutions.tictactoe.utils.helper.DataUtils
import java.io.IOException

/**
 * This is an exception class for no connectivity of internet
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
class NoConnectivityException : IOException() {
    override val message: String
        get() = DataUtils.getString(R.string.error_internet_connection)
}
