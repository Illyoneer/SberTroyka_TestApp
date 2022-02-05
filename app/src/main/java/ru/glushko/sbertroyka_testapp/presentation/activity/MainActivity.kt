package ru.glushko.sbertroyka_testapp.presentation.activity

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ru.glushko.sbertroyka_testapp.R
import ru.glushko.sbertroyka_testapp.databinding.ActivityMainBinding
import ru.glushko.sbertroyka_testapp.presentation.fragments.WalksFragment

class MainActivity : AppCompatActivity() {

    private lateinit var _mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)

        if (isOnline(this))
            directToWalksFragment()
        else
            showInternetAlertDialog()

        setContentView(_mainActivityBinding.root)
    }

    private fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    private fun showInternetAlertDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Нет подключения к интернету!")
            .setCancelable(false)
            .setPositiveButton("Закрыть") { _, _ ->
                this.finish()
            }
            .show()
    }

    private fun directToWalksFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, WalksFragment())
            .commit()
    }
}