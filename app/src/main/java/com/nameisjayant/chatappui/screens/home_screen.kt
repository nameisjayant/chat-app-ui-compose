package com.nameisjayant.chatappui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nameisjayant.chatappui.R
import com.nameisjayant.chatappui.data.Person
import com.nameisjayant.chatappui.data.personList
import com.nameisjayant.chatappui.navigation.CHAT_SCREEN
import com.nameisjayant.chatappui.ui.theme.*


@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Header()
            LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
                item {
                    AddStoryLayout(modifier = Modifier.padding(start = 23.dp))
                    Spacer(modifier = Modifier.width(10.dp))
                }
                items(personList, key = { it.id }) {
                    UserStory(person = it)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 30.dp, topEnd = 30.dp
                        )
                    )
                    .background(Color.White)
            ) {
                RoundedCorner(modifier = Modifier.align(TopCenter).padding(top = 15.dp))
                LazyColumn(
                    modifier = Modifier.padding(bottom = 15.dp, top = 30.dp)
                ) {
                    items(personList, key = { it.id }) {
                        UserEachRow(person = it){
                            navHostController.currentBackStackEntry?.savedStateHandle?.set("data",it)
                            navHostController.navigate(CHAT_SCREEN)
                        }
                    }
                }
            }
        }

    }

}


@Composable
fun RoundedCorner(
    modifier: Modifier
) {

    Box(
        modifier = modifier
            .width(90.dp)
            .height(5.dp)
            .clip(RoundedCornerShape(90.dp))
            .background(
                Gray400
            )
    )
}


@Composable
fun UserEachRow(
    person: Person,
    onClick:()->Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .noRippleEffect { onClick() }
            .padding(horizontal = 20.dp, vertical = 5.dp),
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = person.icon),
                        contentDescription = "",
                        modifier = Modifier.size(60.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(
                    ) {
                        Text(
                            text = person.name, style = TextStyle(
                                color = Color.Black, fontSize = 15.sp, fontFamily = InterBold
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Okay", style = TextStyle(
                                color = Gray, fontSize = 14.sp, fontFamily = InterMedium
                            )
                        )
                    }

                }
                Text(
                    text = "12:23 PM", style = TextStyle(
                        color = Gray, fontSize = 12.sp, fontFamily = InterMedium
                    )
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Line)
        }
    }

}

@Composable
fun UserStory(
    person: Person, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(end = 10.dp)
    ) {

        Card(
            modifier = Modifier.size(70.dp),
            shape = CircleShape,
            border = BorderStroke(2.dp, Yellow),
            elevation = 0.dp,
            backgroundColor = Color.Black
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(CircleShape)
                    .background(Yellow),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = person.icon),
                    contentDescription = "",
                    modifier = Modifier.size(60.dp),
                    tint = Color.Unspecified
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = person.name, style = TextStyle(
                color = Color.White, fontSize = 13.sp, fontFamily = InterMedium
            ), modifier = Modifier.align(CenterHorizontally)
        )

    }
}


@Composable
fun AddStoryLayout(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {

        Card(
            modifier = Modifier.size(70.dp),
            shape = CircleShape,
            border = BorderStroke(2.dp, DarkGray),
            elevation = 0.dp,
            backgroundColor = Color.Black
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(CircleShape)
                    .background(Yellow),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "",
                        modifier = Modifier.size(12.dp),
                        tint = Yellow
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.add_story), style = TextStyle(
                color = Color.White, fontSize = 13.sp, fontFamily = InterMedium
            ), modifier = Modifier.align(CenterHorizontally)
        )

    }

}

@Composable
fun Header() {

    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontFamily = InterRegular,
                fontSize = 20.sp,
                fontWeight = FontWeight.W300
            )
        ) {
            append("Welcome back, ")
        }
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontFamily = InterSemibold,
                fontSize = 20.sp,
            )
        ) {
            append("Jayant!")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 60.dp)
    ) {
        Text(text = annotatedString)
    }

}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.noRippleEffect(onClick:()->Unit) = composed {
    clickable(
        interactionSource = MutableInteractionSource(),
        indication = null
    ) {
        onClick()
    }
}