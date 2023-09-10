package com.example.swiftpay.ui.screens.notifications.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.swiftpay.R
import com.example.swiftpay.ui.theme.DpDimensions

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationItem(
    modifier: Modifier = Modifier,
    notification: Notification,
    onNotificationClick: (Notification) -> Unit
) {

    Surface(
        shape = RoundedCornerShape(DpDimensions.Small),
        modifier = modifier
            .fillMaxWidth(),
        onClick = { onNotificationClick(notification) },
        color = MaterialTheme.colorScheme.background,
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(DpDimensions.Small),
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colorScheme.inverseSurface, CircleShape)
                    .align(Alignment.Top)
            ) {
                Icon(
                    painter = painterResource(id = notification.icon),
                    contentDescription = notification.time + " icon",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = notification.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    maxLines = 1,
                    modifier = Modifier.basicMarquee()
                )

                Spacer(modifier = Modifier.height(DpDimensions.Small))

                Text(
                    text = notification.body,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiary,

                    )

                Spacer(modifier = Modifier.height(DpDimensions.Small))

                Text(
                    text = notification.time,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiary,
                )

            }

            if (!notification.isRead) {
                Box(
                    modifier = Modifier
                        .size(DpDimensions.Small)
                        .background(color = MaterialTheme.colorScheme.onPrimary, CircleShape)
                        .clip(CircleShape)
                )
            }

            if (notification.isRightIconVisible) {
                IconButton(onClick = { onNotificationClick(notification) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_right),
                        contentDescription = null,
                        modifier = Modifier.size(DpDimensions.Dp20)
                    )
                }
            }

        }

    }
}


data class Notification(
    val title: String,
    val body: String,
    val date: String,
    val time: String,
    val isRead: Boolean,
    val isRightIconVisible: Boolean = true,
    @DrawableRes val icon: Int = R.drawable.info
)

val notifications = listOf(
    Notification(
        title = "New Updates Available",
        body = "Update the SwiftPay app and enjoy new features for a better financial experience",
        date = "Today",
        time = "11:34 AM",
        isRead = false
    ),
    Notification(
        title = "Enable 2-Factor Authentication",
        body = "Use two-factor authentication for extra security on your account",
        date = "Today",
        time = "10:54 AM",
        isRead = false
    ),
    Notification(
        title = "Multiple Payments Support Update",
        body = "Now you can add multiple cards. Go to Account -> Payment methods to add another payment mode.",
        date = "Yesterday",
        time = "04:29 PM",
        isRead = true
    ),
    Notification(
        title ="Christmas and New Year Promotions",
        body = "Shop at your favorite merchants with a minimum purchase of $100 to get extra cashback up to 10%",
        date = "7 Sep, 2023",
        time = "12:43 PM",
        isRead = true
    ),
    Notification(
        title = "Important Security Notice",
        body = "We detected unusual activity on your account. Please change your password immediately for your safety.",
        date = "6 Sep, 2023",
        time = "08:15 AM",
        isRead = false
    ),
    Notification(
        title = "Upcoming Maintenance",
        body = "SwiftPay will undergo scheduled maintenance on September 15, 2023, from 2:00 AM to 4:00 AM UTC.",
        date = "5 Sep, 2023",
        time = "03:30 PM",
        isRead = true
    ),
    Notification(
        title = "New Feature Announcement",
        body = "Introducing the 'Quick Transfer' feature for faster fund transfers between accounts.",
        date = "5 Sep, 2023",
        time = "09:22 AM",
        isRead = false
    ),
    Notification(
        title = "Account Balance Update",
        body = "Your account balance is now updated to $1,250.50",
        date = "3 Sep, 2023",
        time = "02:10 PM",
        isRead = false
    ),
    Notification(
        title = "Weekly Transaction Summary",
        body = "Your weekly transaction summary is available. Check your spending habits and save more!",
        date = "3 Sep, 2023",
        time = "07:05 AM",
        isRead = true
    ),
    Notification(
        title = "New Merchant Partnerships",
        body = "We've partnered with new merchants. Explore exclusive discounts and offers in the 'Deals' section.",
        date = "1 Sep, 2023",
        time = "11:15 AM",
        isRead = false
    ),
    Notification(
        title = "Account Security Alert",
        body = "We detected a login attempt from an unrecognized device. Verify your identity to secure your account.",
        date = "1 Sep, 2023",
        time = "10:30 AM",
        isRead = false
    ),
    Notification(
        title = "Transaction Confirmation",
        body = "Your recent transaction of $50 at 'Coffee Corner' has been successfully completed.",
        date = "31 Aug, 2023",
        time = "01:20 PM",
        isRead = true
    ),
    Notification(
        title = "New Rewards Program",
        body = "Join our loyalty program and earn points for every purchase. Redeem points for exciting rewards!",
        date = "31 Aug, 2023",
        time = "05:45 PM",
        isRead = false
    ),
    Notification(
        title = "Account Upgrade Offer",
        body = "Upgrade to our premium account for enhanced features and lower transaction fees.",
        date = "30 Aug, 2023",
        time = "09:10 AM",
        isRead = true
    ),
    Notification(
        title = "Holiday Closure Notice",
        body = "Our customer support will be closed on September 3, 2023, due to a national holiday.",
        date = "30 Aug, 2023",
        time = "04:00 PM",
        isRead = false
    ),
    Notification(
        title = "New Chat Support Available",
        body = "Need assistance? We now offer 24/7 chat support. Click here to start a conversation.",
        date = "29 Aug, 2023",
        time = "07:30 AM",
        isRead = true
    ),
    Notification(
        title = "Account Verification Required",
        body = "Complete your account verification to enjoy uninterrupted service and increased transaction limits.",
        date = "29 Aug, 2023",
        time = "12:15 PM",
        isRead = false
    ),
    Notification(
        title = "Feedback Survey",
        body = "Share your feedback and help us improve. Participate in our survey for a chance to win exciting prizes!",
        date = "28 Aug, 2023",
        time = "03:50 PM",
        isRead = false
    ),
    Notification(
        title = "Mobile App Update",
        body = "A new version of our mobile app is available. Update now for enhanced performance and security.",
        date = "28 Aug, 2023",
        time = "09:00 AM",
        isRead = true
    ),
    Notification(
        title = "Welcome to SwiftPay",
        body = "Thank you for choosing SwiftPay! We're excited to have you as our customer.",
        date = "27 Aug, 2023",
        time = "10:20 AM",
        isRead = true
    )
)
