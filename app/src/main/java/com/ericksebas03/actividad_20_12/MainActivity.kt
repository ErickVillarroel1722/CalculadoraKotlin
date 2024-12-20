package com.ericksebas03.actividad_20_12

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Elementos de la interfaz
        val numero1 = findViewById<EditText>(R.id.numero1)
        val numero2 = findViewById<EditText>(R.id.numero2)
        val resultado = findViewById<TextView>(R.id.resultado)

        // Botones de operaciones básicas
        val btnSuma = findViewById<Button>(R.id.btn_suma)
        val btnResta = findViewById<Button>(R.id.btn_resta)
        val btnMultiplica = findViewById<Button>(R.id.btn_multiplica)
        val btnDivide = findViewById<Button>(R.id.btn_divide)

        // Botones de funciones trigonométricas
        val btnSeno = findViewById<Button>(R.id.btn_seno)
        val btnCoseno = findViewById<Button>(R.id.btn_coseno)
        val btnTangente = findViewById<Button>(R.id.btn_tangente)

        // Listeners para operaciones básicas
        btnSuma.setOnClickListener {
            realizarOperacion(numero1, numero2, resultado) { a, b -> a + b }
        }

        btnResta.setOnClickListener {
            realizarOperacion(numero1, numero2, resultado) { a, b -> a - b }
        }

        btnMultiplica.setOnClickListener {
            realizarOperacion(numero1, numero2, resultado) { a, b -> a * b }
        }

        btnDivide.setOnClickListener {
            realizarOperacion(numero1, numero2, resultado) { a, b ->
                if (b != 0.0) a / b else Double.NaN
            }
        }

        // Listeners para funciones trigonométricas
        btnSeno.setOnClickListener {
            realizarTrigonometria(numero1, resultado) { a -> sin(a) }
        }

        btnCoseno.setOnClickListener {
            realizarTrigonometria(numero1, resultado) { a -> cos(a) }
        }

        btnTangente.setOnClickListener {
            realizarTrigonometria(numero1, resultado) { a -> tan(a) }
        }
    }

    // Función para operaciones básicas
    private fun realizarOperacion(
        numero1: EditText,
        numero2: EditText,
        resultado: TextView,
        operacion: (Double, Double) -> Double
    ) {
        try {
            val n1 = numero1.text.toString().toDouble()
            val n2 = numero2.text.toString().toDouble()
            val res = operacion(n1, n2)
            resultado.text = "Resultado: $res"
        } catch (e: Exception) {
            Toast.makeText(this, "Por favor, ingresa números válidos", Toast.LENGTH_SHORT).show()
        }
    }

    // Función para trigonometría
    private fun realizarTrigonometria(
        numero: EditText,
        resultado: TextView,
        funcion: (Double) -> Double
    ) {
        try {
            val n = numero.text.toString().toDouble()
            val res = funcion(Math.toRadians(n)) // Convertir a radianes
            resultado.text = "Resultado: $res"
        } catch (e: Exception) {
            Toast.makeText(this, "Por favor, ingresa un número válido", Toast.LENGTH_SHORT).show()
        }
    }
}

