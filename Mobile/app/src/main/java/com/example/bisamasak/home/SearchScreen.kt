package com.example.bisamasak.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    textFieldState: MutableState<TextFieldValue>,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
) {
    var isActive by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier) {
        SearchBar(
            query = textFieldState.value.text,
            onQueryChange = {
                textFieldState.value = TextFieldValue(it)
            },
            onSearch = {
                onSearch(textFieldState.value.text)
                isActive = false
            },
            active = isActive,
            onActiveChange = { isActive = it },
            placeholder = {
                Text("Cari resep, bahan...")
            },
            modifier = Modifier.fillMaxWidth()
        ) {}

        if (isActive && searchResults.isNotEmpty()) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                searchResults.forEach { result ->
                    ListItem(
                        headlineContent = { Text(result) },
                        modifier = Modifier
                            .clickable {
                                textFieldState.value = TextFieldValue(result)
                                isActive = false
                            }
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}
