package com.example.chatfirebase.presentation.screens


import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatfirebase.presentation.entity.DialogCardEntity


@Composable
fun BubbleScreen(
    item : DialogCardEntity
) {
    val bubbleColor = if (item.isFromMe) Color(0xFFDCF8C6) else Color.White
    val alignment = if (item.isFromMe) Alignment.End else Alignment.Start
    val shape = if (item.isFromMe) {
        RoundedCornerShape(12.dp, 0.dp, 12.dp, 12.dp)
    } else {
        RoundedCornerShape(0.dp, 12.dp, 12.dp, 12.dp)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalAlignment = alignment
    ) {
        Box(
            modifier = Modifier
                .background(color = bubbleColor, shape = shape)
                .padding(12.dp)
                .widthIn(max = 280.dp)
        ) {
            Column {
                if (!item.isFromMe && item.senderName != null) {
                    Text(
                        text = item.senderName,
                        color = Color(0xFF3885F4),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }

                Text(
                    text = item.message,
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = item.time,
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}