package com.nameisjayant.chatappui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nameisjayant.chatappui.R
import com.nameisjayant.chatappui.navigation.HOME_SCREEN
import com.nameisjayant.chatappui.ui.theme.Aqua
import com.nameisjayant.chatappui.ui.theme.InterBold
import com.nameisjayant.chatappui.ui.theme.InterSemibold


@Composable
fun StartScreen(
    navHostController: NavHostController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background), contentDescription = "",
            contentScale = ContentScale.FillWidth
        )

        Box(
            modifier = Modifier
                .padding(top = 220.dp)
                .align(Alignment.Center)
                .background(Color.Black)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 40.dp)
            ) {
                Text(
                    text = stringResource(R.string.stay_with_your_friends),
                    style = TextStyle(
                        fontSize = 36.sp,
                        color = Color.White,
                        fontFamily = InterBold
                    )
                )
                CustomCheckBox()

            }
        }
        Button(
            onClick = {
                      navHostController.navigate(HOME_SCREEN)
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.BottomCenter)
                .height(60.dp),
            shape = RoundedCornerShape(100.dp),
            elevation = ButtonDefaults.elevation(0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            )
        ) {
            Text(
                text = stringResource(R.string.get_started), style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = InterBold
                )
            )
        }
    }
}

@Composable
fun CustomCheckBox() {

    Row(
        modifier = Modifier.padding(vertical = 15.dp)
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp, topEnd = 10.dp, bottomStart = 80.dp, bottomEnd = 80.dp
                    )
                )
                .background(Aqua), contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Check,
                contentDescription = "",
                modifier = Modifier.size(15.dp),
                tint = Color.Black
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = stringResource(R.string.secure_private_messaging), style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = InterSemibold
            )
        )
    }

}