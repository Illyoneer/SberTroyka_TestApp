package ru.glushko.sbertroyka_testapp.presentation.activity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.glushko.sbertroyka_testapp.R
import ru.glushko.sbertroyka_testapp.databinding.ActivityMainBinding
import ru.glushko.sbertroyka_testapp.presentation.fragments.WalksFragment

class MainActivity : AppCompatActivity() {

    private lateinit var _mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#6B5C87")))

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, WalksFragment()).commit()

        setContentView(_mainActivityBinding.root)
    }
}