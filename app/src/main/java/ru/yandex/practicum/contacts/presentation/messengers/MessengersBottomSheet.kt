package ru.yandex.practicum.contacts.presentation.messengers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.yandex.practicum.contacts.data.models.MessagingApp // Импорт из data.models
import ru.yandex.practicum.contacts.presentation.ui.components.CommonBottomSheet

@Composable      
fun MessengersBottomSheet(
    messagingApps: List<MessagingApp>,
    selectedApps: Set<MessagingApp>,
    onAppsSelected: (Set<MessagingApp>) -> Unit,
    onDismiss: () -> Unit
) {
    CommonBottomSheet(
        title = "Мессенджер",
        items = messagingApps,
        selectedItems = selectedApps,
        onItemsSelected = onAppsSelected,
        onDismiss = onDismiss
    ) { messagingApp: MessagingApp, isSelected: Boolean ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val newSelection = selectedApps.toMutableSet()
                    if (isSelected) {
                        newSelection.remove(messagingApp)
                    } else {
                        newSelection.add(messagingApp)
                    }
                    onAppsSelected(newSelection)
                }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = messagingApp.name,
                modifier = Modifier.weight(1f)
            )
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selected"
                )
            }
        }
    }
}