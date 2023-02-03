package com.example.ejercicio9_full_layout

import android.content.Intent
import android.content.IntentSender
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.ejercicio9_full_layout.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val telIntent: Intent = Uri.parse("tel:666666666").let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        val gmailIntent: Intent = Uri.parse("https://mail.google.com/mail/").let { webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }
        val geoIntent: Intent = Uri.parse("geo:52.36524017156559,4.926453531223001").let { location ->
            Intent(Intent.ACTION_VIEW, location)
        }
        val mapsIntent: Intent = Uri.parse("https://maps.google.com/").let { webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }
        val hangoutsIntent: Intent = Uri.parse("https://hangouts.google.com/").let {webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }
        val hangoutsAppIntent: Intent = Uri.parse("com.google.hangouts://").let {app ->
            Intent(Intent.ACTION_VIEW,app)
        }
        binding.mapsButton.setOnClickListener {
            startActivity(mapsIntent)
        }
        binding.hangoutsButton.setOnClickListener {
            try {
                startActivity(hangoutsAppIntent)
            }catch (e: java.lang.Exception){
                startActivity(hangoutsIntent)
            }

        }
        binding.gmailButton.setOnClickListener {
            startActivity(gmailIntent)
        }
        binding.firstCard.setOnClickListener {
            startActivity(geoIntent)
        }
        binding.secondCard.setOnClickListener {
            startActivity(telIntent)
        }


        /*
        Esquinas redondeadas
        https://developer.android.com/develop/ui/views/theming/rounded-corners
         */

    }
}