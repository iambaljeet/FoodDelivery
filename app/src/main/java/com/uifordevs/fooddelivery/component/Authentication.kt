@file:OptIn(ExperimentalPagerApi::class)

package com.uifordevs.fooddelivery.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.uifordevs.fooddelivery.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Authentication(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            shape = RoundedCornerShape(
                bottomStart = 20.dp,
                bottomEnd = 20.dp
            ),
            elevation = 10.dp
        ) {
            Column(
                modifier = modifier
                    .wrapContentWidth()
                    .padding(
                        start = 24.dp, end = 24.dp,
                        top = 24.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    modifier = modifier
                        .padding(
                            bottom = 24.dp
                        )
                        .weight(1f)
                        .size(100.dp),
                    painter = painterResource(id = R.drawable.ic_onboarding_logo),
                    contentDescription = "Logo"
                )
                TabRow(
                    modifier = modifier
                        .fillMaxWidth(),
                    selectedTabIndex = pagerState.currentPage,
                ) {
                    TabItem(
                        modifier = modifier,
                        isSelected = pagerState.currentPage == 0,
                        label = stringResource(id = R.string.login)
                    ) {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                0
                            )
                        }
                    }
                    TabItem(
                        modifier = modifier,
                        isSelected = pagerState.currentPage == 1,
                        label = stringResource(id = R.string.sign_up)
                    ) {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                1
                            )
                        }
                    }
                }
            }
        }
        AuthPages(
            pagerState = pagerState
        )
    }
}

@Composable
private fun TabItem(
    modifier: Modifier,
    isSelected: Boolean,
    label: String,
    onSelected: () -> Unit
) {
    Tab(
        modifier = modifier.padding(
            top = 10.dp,
            bottom = 10.dp
        ),
        selected = isSelected,
        onClick = onSelected,
        selectedContentColor = MaterialTheme.colors.onBackground,
        unselectedContentColor = MaterialTheme.colors.onBackground
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun AuthPages(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    HorizontalPager(
        modifier = modifier
            .fillMaxSize(),
        count = 2,
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically
    ) { page ->
        if (page == 0) {
            Login()
        } else {
            Register()
        }
    }
}

@Composable
fun Login(modifier: Modifier = Modifier) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = modifier
                .weight(1f)
                .verticalScroll(
                    state = rememberScrollState(),
                    enabled = true
                ),
            verticalArrangement = Arrangement.Center
        ) {
            HintTextField(
                modifier = modifier.fillMaxWidth(),
                value = email,
                label = stringResource(id = R.string.email_label),
                placeholder = stringResource(id = R.string.email_placeholder),
                textStyle = MaterialTheme.typography.body1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            ) { value ->
                email = value
            }
            Spacer(
                modifier = modifier
                    .height(24.dp)
            )
            HintTextField(
                modifier = modifier.fillMaxWidth(),
                value = password,
                label = stringResource(id = R.string.password_label),
                placeholder = stringResource(id = R.string.password_placeholder),
                textStyle = MaterialTheme.typography.body1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Go
                ),
            ) { value ->
                password = value
            }
            TextButton(onClick = {}) {
                Text(
                    text = stringResource(id = R.string.forgot_password),
                    style = MaterialTheme.typography.h6.copy(
                        color = MaterialTheme.colors.secondary,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
        Button(
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(60.dp),
            onClick = {},
            colors = ButtonDefaults
                .buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary
                )
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.button
            )
        }
    }
}

@Composable
fun Register(modifier: Modifier = Modifier) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = modifier
                .weight(1f)
                .verticalScroll(
                    state = rememberScrollState(),
                    enabled = true
                ),
            verticalArrangement = Arrangement.Center,
        ) {
            HintTextField(
                modifier = modifier.fillMaxWidth(),
                value = name,
                label = stringResource(id = R.string.name_label),
                placeholder = stringResource(id = R.string.name_placeholder),
                textStyle = MaterialTheme.typography.body1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            ) { value ->
                name = value
            }
            Spacer(
                modifier = modifier
                    .height(24.dp)
            )
            HintTextField(
                modifier = modifier.fillMaxWidth(),
                value = email,
                label = stringResource(id = R.string.email_label),
                placeholder = stringResource(id = R.string.email_placeholder),
                textStyle = MaterialTheme.typography.body1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            ) { value ->
                email = value
            }
            Spacer(
                modifier = modifier
                    .height(24.dp)
            )
            HintTextField(
                modifier = modifier.fillMaxWidth(),
                value = password,
                label = stringResource(id = R.string.password_label),
                placeholder = stringResource(id = R.string.password_placeholder),
                textStyle = MaterialTheme.typography.body1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Go
                ),
            ) { value ->
                password = value
            }
            TextButton(onClick = {}) {
                Text(
                    text = stringResource(id = R.string.forgot_password),
                    style = MaterialTheme.typography.h6.copy(
                        color = MaterialTheme.colors.secondary,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
        Button(
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(60.dp),
            onClick = {},
            colors = ButtonDefaults
                .buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary
                )
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.button
            )
        }
    }
}

@Composable
fun HintTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String = String(),
    placeholder: String = String(),
    textStyle: TextStyle,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    onValueChange: (value: String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography
                .body2.copy(
                    fontWeight = FontWeight.Bold
                )
        )
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = placeholder)
            },
            keyboardOptions = keyboardOptions,
            textStyle = textStyle,
            colors = TextFieldDefaults
                .textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = MaterialTheme.colors.onBackground,
                    unfocusedIndicatorColor = MaterialTheme.colors.onBackground,
                    cursorColor = MaterialTheme.colors.onBackground
                )
        )
    }
}
@Composable
fun HintTextField1(
    modifier: Modifier = Modifier,
    value: String,
    label: String = String(),
    placeholder: String = String(),
    textStyle: TextStyle,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    onValueChange: (value: String) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        decorationBox = {
            Text(text = stringResource(id = R.string.password_placeholder))
        },
    )
}