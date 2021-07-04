package com.marinj.catfacts.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.marinj.catfacts.Greeting
import com.marinj.catfacts.android.core.theme.CatInfoTheme
import com.marinj.catfacts.android.feature.catinfo.CatInfoScreen

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatInfoTheme {
                CatInfoScreen()
            }
        }
    }
}
