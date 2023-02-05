package com.nameisjayant.chatappui.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.nameisjayant.chatappui.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val id: Int = 0,
    val name: String = "",
    @DrawableRes val icon: Int = R.drawable.person_1
):Parcelable

val personList = listOf(
    Person(
        1,
        "Pranav",
        R.drawable.person_1
    ),
    Person(
        2,
        "Ayesha",
        R.drawable.person_2
    ),
    Person(
        3,
        "Roshini",
        R.drawable.person_3
    ),
    Person(
        4,
        "Kaushik",
        R.drawable.person_4
    ),
    Person(
        5,
        "Dad",
        R.drawable.person_5
    ),
    Person(
        6,
        "Pranav",
        R.drawable.person_1
    ),
    Person(
        7,
        "Ayesha",
        R.drawable.person_2
    ),
    Person(
        8,
        "Roshini",
        R.drawable.person_3
    ),
    Person(
        9,
        "Kaushik",
        R.drawable.person_4
    ),
    Person(
        10,
        "Dad",
        R.drawable.person_5
    ),
)