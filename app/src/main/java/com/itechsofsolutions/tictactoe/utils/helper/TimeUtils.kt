package com.itechsoftsolution.ebay.utils.helper

import com.itechsofsolutions.tictactoe.utils.helper.Constants
import timber.log.Timber
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * This is a class that contains utils for the time
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
class TimeUtils private constructor() {
    companion object {
        private const val SECOND_MILLIS = 1000
        private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
        private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
        private const val DAY_MILLIS = 24 * HOUR_MILLIS

        /**
         * This method provides current system time in milliseconds
         *
         * @return [Long] current time
         * */
        fun currentTime(): Long {
            return System.currentTimeMillis()
        }

        /**
         * This method provides the first day of the current year in milliseconds
         *
         * @return [Long] milliseconds
         */
        fun getFirstDayOfTheYear(): Long {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)

            calendar.clear()
            calendar.set(Calendar.YEAR, year)

            // 1st day of the year
            calendar.set(Calendar.MONTH, Calendar.JANUARY)
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            calendar.set(Calendar.HOUR_OF_DAY, 0)

            return calendar.timeInMillis
        }

        /**
         * This method provides the last day of the current year in milliseconds
         *
         * @return [Date] milliseconds
         */
        fun getLastDayOfTheYear(): Long {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)

            calendar.clear()
            calendar.set(Calendar.YEAR, year)

            // Last day of the year
            calendar.set(Calendar.MONTH, Calendar.DECEMBER)
            calendar.set(Calendar.DAY_OF_MONTH, 31)
            calendar.set(Calendar.HOUR_OF_DAY, 23)
            calendar.set(Calendar.MINUTE, 59)
            calendar.set(Calendar.SECOND, 59)

            return calendar.timeInMillis
        }

        /**
         * This method returns a formatted date which uses the common date format all over the app
         *
         * @param year provided year
         * @param month provided month
         * @param day provided day
         */
        fun getFormattedDateString(year: Int, month: Int, day: Int): String {
            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)

            return SimpleDateFormat(
                Constants.Common.APP_COMMON_DATE_FORMAT,
                    Locale.ENGLISH).format(calendar.time)
        }

        /**
         * This method returns a formatted date which uses the common date format all over the app
         *
         * @param timeInMillis time
         */
        fun getFormattedDateString(timeInMillis: Long): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMillis
            return SimpleDateFormat(
                Constants.Common.APP_COMMON_DATE_FORMAT,
                    Locale.ENGLISH).apply {
                this.timeZone = TimeZone.getTimeZone(Constants.Common.COMMON_TIME_ZONE)
            }.format(calendar.time)
        }

        /**
         * This method returns a formatted time which uses the common time format all over the app
         *
         * @param timeInMillis time
         */
        fun getFormattedTimeString(timeInMillis: Long): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMillis
            return SimpleDateFormat(
                Constants.Common.APP_COMMON_TIME_FORMAT,
                    Locale.ENGLISH).apply {
                this.timeZone = TimeZone.getTimeZone(Constants.Common.COMMON_TIME_ZONE)
            }.format(calendar.time)
        }

        /**
         * This method returns a formatted day which uses the common format all over the app
         *
         * @param timeInMillis time
         */
        fun getFormattedDayNameString(timeInMillis: Long): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMillis
            return SimpleDateFormat(
                Constants.Common.APP_COMMON_DAY_FORMAT,
                    Locale.ENGLISH).apply {
                this.timeZone = TimeZone.getTimeZone(Constants.Common.COMMON_TIME_ZONE)
            }.format(calendar.time)
        }

        /**
         * This method returns a formatted only date which uses the common format all over the app
         *
         * @param timeInMillis time
         */
        fun getFormattedOnlyDateString(timeInMillis: Long): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMillis
            return SimpleDateFormat(
                Constants.Common.APP_COMMON_ONLY_DATE_FORMAT,
                    Locale.ENGLISH).apply {
                this.timeZone = TimeZone.getTimeZone(Constants.Common.COMMON_TIME_ZONE)
            }.format(calendar.time)
        }

        /**
         * This method returns a formatted month which uses the common format all over the app
         *
         * @param timeInMillis time
         */
        fun getFormattedMonthString(timeInMillis: Long): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMillis
            return SimpleDateFormat(
                Constants.Common.APP_COMMON_MONTH_FORMAT,
                    Locale.ENGLISH).apply {
                this.timeZone = TimeZone.getTimeZone(Constants.Common.COMMON_TIME_ZONE)
            }.format(calendar.time)
        }

        /**
         * This method returns a calendar object which is parsed from a date string using
         * common date format of the application
         *
         * @param date formatted date as string
         */
        fun getCalendarFromDate(date: String): Calendar {
            val calendar = Calendar.getInstance()
            try {
                calendar.time = SimpleDateFormat(
                    Constants.Common.APP_COMMON_DATE_FORMAT,
                        Locale.ENGLISH).parse(date)
            } catch (e: ParseException) {
                Timber.e(e)
            }

            return calendar
        }

        /**
         * This method returns an integer representing which date is bigger than the other
         *
         * @param date1 first date
         * @param date2 second date
         * @return int state
         *
         * States:
         * less than 0 means date1 is less than date2
         * greater than 0 means date1 is greater than date2
         * exact 0 means date1 and date2 is equal
         */
        fun compareTwoDates(date1: String, date2: String): Int {
            return getCalendarFromDate(date1).time
                    .compareTo(getCalendarFromDate(date2).time)
        }

        /**
         * This method provides difference between current time in milliseconds and provided time
         *
         * @param time time in milliseconds
         * @return [Long] time difference in milliseconds
         */
        fun differ(time: Long): Long {
            return currentTime() - time
        }

        /**
         * This method provides a time ago text depending on the time difference
         *
         * @param newTime new time
         * @param oldTime old time
         * @return [String] time ago text
         * */
        fun getTimeAgo(newTime: Long, oldTime: Long): String {
            val diff = newTime - oldTime

            return when {
                diff < MINUTE_MILLIS -> "Just now"
                diff < 2 * MINUTE_MILLIS -> "A minute ago"
                diff < 50 * MINUTE_MILLIS -> (diff / MINUTE_MILLIS).toString() + " minutes ago"
                diff < 90 * MINUTE_MILLIS -> "An hour ago"
                diff < 24 * HOUR_MILLIS -> (diff / HOUR_MILLIS).toString() + " hours ago"
                diff < 48 * HOUR_MILLIS -> "Yesterday"
                else -> (diff / DAY_MILLIS).toString() + " days ago"
            }
        }

        /**
         * This method provides the year based on the time stamp
         *
         * @param timeStamp timestamp
         * @return [Int] year
         * */
        fun getYear(timeStamp: Long): Int {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeStamp
            return calendar.get(Calendar.YEAR)
        }

        /**
         * This method provides the month based on the time stamp
         *
         * @param timeStamp timestamp
         * @return [Int] month
         * */
        fun getMonth(timeStamp: Long): Int {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeStamp
            return calendar.get(Calendar.MONTH) + 1
        }

        /**
         * This method provides the month name based on the numeric month
         *
         * @param month month
         * @return [String] month in text
         * */
        fun getMonth(month: Int): String {
            return DateFormatSymbols.getInstance().months[month - 1]
        }

        /**
         * This method provides the day of month based on the time stamp
         *
         * @param timeStamp timestamp
         * @return [Int] day of month
         * */
        fun getDayOfMonth(timeStamp: Long): Int {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeStamp
            return calendar.get(Calendar.DAY_OF_MONTH)
        }

        /**
         * this api return a desire format date
         */
        fun getDesireDateFormat(currentDate: String, pattern: String): String {
/*
            val dateFormat = SimpleDateFormat("MMM dd, yyyy")


            var myDate: Date? = null
            try {
                myDate = dateFormat.parse(currentDate)

            } catch (e: ParseException) {
                e.printStackTrace()
            }

            val timeFormat = SimpleDateFormat(pattern)
            val finalDate = timeFormat.format(myDate)*/


            var outputDate = ""
            val inputFormat = "yyyy-MM-dd hh:mm:ss"

            val input = SimpleDateFormat(inputFormat, Locale.getDefault())
            val output = SimpleDateFormat(pattern, Locale.getDefault())
            try {
                val parsed = input.parse(currentDate)
                outputDate = output.format(parsed)
            } catch (e: Exception) {

            }

            return outputDate


        }
    }
}