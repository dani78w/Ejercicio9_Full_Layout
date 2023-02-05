package com.example.ejercicio9_full_layout

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio9_full_layout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mapsButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/")))
        }

        binding.hangoutsButton.setOnClickListener {
            // La URI de Hangouts es "com.google.hangouts://" pero si no tiene la app instalada manejamos la excepción y abrimos la web
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("com.google.hangouts://")
                    )
                )
            } catch (e: java.lang.Exception) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://hangouts.google.com/")
                    )
                )
            }
        }

        val mailAction: (View) -> Unit = {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://mail.google.com/mail/")
                    )
                )
            }

        binding.gmailButton.setOnClickListener(mailAction)
        binding.thirdCard.setOnClickListener(mailAction)

        binding.firstCard.setOnClickListener {
            // Para abrir la app de Maps con una localización concreta, se le pasa la URI "geo:latitud,longitud"
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:52.36524017156559,4.926453531223001")
                )
            )
        }

        binding.secondCard.setOnClickListener {
            // Para abrir la app de llamadas, se le pasa la URI "tel:numero" con la acción ACTION_DIAL
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:666666666")))
        }

        binding.voiceIcon.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VOICE_COMMAND)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }
    }
}