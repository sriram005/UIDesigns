package com.mofosoft.uidesigns.collapsingToolbar

import com.mofosoft.uidesigns.ui.theme.UIDesignsTheme
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mofosoft.uidesigns.R
import com.mofosoft.uidesigns.ui.theme.Orange


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingToolbar() {
    UIDesignsTheme{
        var text by remember { mutableStateOf("") }
        val lazyListState = rememberLazyListState()


        val padding by animateDpAsState(
            targetValue = if(lazyListState.isScrolled) 0.dp else 56.dp,
            animationSpec = tween(300)
        )

        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(text = "My App") },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = Orange,
                            titleContentColor = Color.White
                        )
                    )
                }

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .padding(it),
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Orange)
                            .animateContentSize(animationSpec = tween(300))
                            .height(if (lazyListState.isScrolled) 0.dp else 80.dp)
                            .padding(10.dp)
                    ){
                        TextField(
                            value = text,
                            onValueChange = {
                                text = it
                            },
                            placeholder = { Text(text = "Search here")},
                            modifier = Modifier.fillMaxWidth(1f),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White,
                                cursorColor = Color.Gray,
                                focusedLabelColor = Color.Transparent,
                                textColor = Color.Black,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "search",
                                )
                            }
                        )
                    }
                    LazyColumn (
                        state = lazyListState,
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        items(200){
                            Image(
                                painter = painterResource(id = R.drawable.baseline_favorite_24),
                                contentDescription = "heart",
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(100.dp)
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }

        }
    }
}
val LazyListState.isScrolled : Boolean get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0

@Preview
@Composable
fun PreviewCollapsingToolbar() {
    CollapsingToolbar()
}