package ru.yandex.practicum.contacts.presentation.country

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.yandex.practicum.contacts.R
import ru.yandex.practicum.contacts.data.models.CountryCode
import ru.yandex.practicum.contacts.presentation.ui.components.CommonBottomSheet

@Composable
fun CountryCodeBottomSheet(
    selectedCodes: Set<CountryCode>,
    onCodesSelected: (Set<CountryCode>) -> Unit,
    onDismiss: () -> Unit
) {
    CommonBottomSheet(
        title = stringResource(R.string.filter_by_country_code),
        items = CountryCode.COMMON_CODES,
        selectedItems = selectedCodes,
        onItemsSelected = onCodesSelected,
        onDismiss = onDismiss
    ) { countryCode: CountryCode, isSelected: Boolean ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val newSelection = selectedCodes.toMutableSet()
                    if (isSelected) {
                        newSelection.remove(countryCode)
                    } else {
                        newSelection.add(countryCode)
                    }
                    onCodesSelected(newSelection)
                }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(countryCode.code)
                Text(
                    countryCode.country,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selected" // Заменили на прямую строку
                )
            }
        }
    }
}