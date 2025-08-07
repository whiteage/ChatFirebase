package com.example.chatfirebase.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.chatfirebase.presentation.entity.ChatCardEntity
import com.example.chatfirebase.presentation.navigation.Screens
import com.example.chatfirebase.presentation.viewmodel.MainVM

@Composable
fun ChatCard(chatItem: ChatCardEntity, navHostController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navHostController.navigate(Screens.DaialogScreen.route) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Аватар пользователя
        Image(
            imageVector = Icons.Default.AccountBox,
            contentDescription = "Аватар",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Имя и последнее сообщение
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = chatItem.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = chatItem.lastMessage,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Время и счётчик непрочитанных сообщений
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = chatItem.time,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (chatItem.unreadCount > 0) {
                Spacer(modifier = Modifier.height(4.dp))
                Badge(
                    content = { Text(text = chatItem.unreadCount.toString()) },
                    containerColor = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}