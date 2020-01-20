package com.itechsofsolutions.tictactoe.utils.helper.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.itechsofsolutions.tictactoe.BaseApplication

import com.itechsofsolutions.tictactoe.utils.helper.DataUtils
import java.util.*

/**
 * This is a class that contains utils to work with notifications
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
object NotificationUtils {
    enum class NotificationType {
        DEFAULT
    }

    private val notificationChannelRepository =
            EnumMap<NotificationType, NotificationChannelDetails>(NotificationType::class.java)

    init {
        notificationChannelRepository[NotificationType.DEFAULT] =
                NotificationChannelDetails("DefaultId", "Default", "Default Notification")
    }

    /**
     * This method creates notification channel (Target API >= 26 (Oreo))
     *
     * @param notificationManager notification manager of the system
     * @param channelDetails details required to create the channel
     * @param channelImportance importance of the channel
     * @param soundFileUri path of custom sound file
     * */
    private fun createNotificationChannel(notificationManager: NotificationManager,
                                          channelDetails: NotificationChannelDetails,
                                          channelImportance: Int, soundFileUri: Uri?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelDetails.id, channelDetails.name, channelImportance)
                    .apply {
                        description = channelDetails.description
                    }

            // Configure the notification channel
            channel.setSound(soundFileUri ?: RingtoneManager.getDefaultUri(
                    RingtoneManager.TYPE_NOTIFICATION), AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION).build())

            // Register the channel with the system
            notificationManager.createNotificationChannel(channel)
        }
    }

    /**
     * This method builds a notification
     *
     * @param notificationId unique id of the notification
     * @param notificationType type of the notification
     * @param iconResourceId resource id for icon
     * @param title title of the notification
     * @param subtitle subtitle of the notification
     * @param bigText big text of the notification
     * @param intent pending intent to be added with the notification
     * @param soundFileResourceId resource id of the custom sound file
     * */
    fun buildNotification(notificationId: Int,
                          notificationType: NotificationType,
                          iconResourceId: Int,
                          title: String,
                          subtitle: String,
                          bigText: String? = null,
                          intent: PendingIntent? = null,
                          soundFileResourceId: Int? = null) {

        var soundFileUri: Uri? = null

        if (soundFileResourceId != null) {
            soundFileUri = DataUtils.getUriFromResource(soundFileResourceId)
        }

        val channelDetails = notificationChannelRepository[notificationType]!!

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager: NotificationManager =
                    BaseApplication.getBaseApplicationContext()
                            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            var shouldCreateChannel = true

            for (notificationChannel in notificationManager.notificationChannels) {
                if (notificationChannel.id == channelDetails.id) {
                    shouldCreateChannel = false
                }
            }

            if (shouldCreateChannel) {
                createNotificationChannel(notificationManager, channelDetails,
                        NotificationManager.IMPORTANCE_DEFAULT, soundFileUri)
            }
        }

        val builder =
                NotificationCompat.Builder(BaseApplication.getBaseApplicationContext(), channelDetails.id)
                        .setSmallIcon(iconResourceId)
                        .setContentTitle(title)
                        .setContentText(subtitle)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)

        if (bigText != null) {
            builder.setStyle(NotificationCompat.BigTextStyle().bigText(bigText))
        }

        if (intent != null) {
            builder.setContentIntent(intent)
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O && soundFileUri != null) {
            builder.setSound(soundFileUri)
        }

        val manager: NotificationManagerCompat = NotificationManagerCompat.from(
                BaseApplication.getBaseApplicationContext())
        manager.notify(notificationId, builder.build())
    }
}