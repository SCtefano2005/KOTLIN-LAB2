package com.villalva.stefano.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        val btnLlamar: Button = findViewById(R.id.btnLlamar)
        val btnUbicacion: Button = findViewById(R.id.btnUbicacion)

        // Obtener los datos pasados desde el Intent
        val numeroCliente = intent.getStringExtra("numero_cliente") ?: "123456789"
        val direccionCliente = intent.getStringExtra("direccion_cliente") ?: "Lima, Peru"

        // Acción para el botón de Llamar, usando el número del cliente
        btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$numeroCliente")
            startActivity(intent)
        }

        // Acción para el botón de Ubicación, usando la dirección del cliente
        btnUbicacion.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=$direccionCliente")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}
