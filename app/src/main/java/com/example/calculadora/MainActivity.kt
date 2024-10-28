package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var numero1 = 0.0
    private var numero2 = 0.0
    private var operacion: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        operacion = null

        binding.boton0.setOnClickListener(this)
        binding.boton1.setOnClickListener(this)
        binding.boton2.setOnClickListener(this)
        binding.boton3.setOnClickListener(this)
        binding.boton4.setOnClickListener(this)
        binding.boton5.setOnClickListener(this)
        binding.boton6.setOnClickListener(this)
        binding.boton7.setOnClickListener(this)
        binding.boton8.setOnClickListener(this)
        binding.boton9.setOnClickListener(this)
        binding.botonMulti.setOnClickListener(this)
        binding.botonDivision.setOnClickListener(this)
        binding.botonMas.setOnClickListener(this)
        binding.botonMinus.setOnClickListener(this)
        binding.botonClear.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)
        binding.botonComa.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view){
            binding.boton0 -> onNumberPressed("0")
            binding.boton1 -> onNumberPressed("1")
            binding.boton2 -> onNumberPressed("2")
            binding.boton3 -> onNumberPressed("3")
            binding.boton4 -> onNumberPressed("4")
            binding.boton5 -> onNumberPressed("5")
            binding.boton6 -> onNumberPressed("6")
            binding.boton7 -> onNumberPressed("7")
            binding.boton8 -> onNumberPressed("8")
            binding.boton9 -> onNumberPressed("9")
            binding.botonMulti -> ""
            binding.botonDivision -> ""
            binding.botonMas -> ""
            binding.botonMinus -> ""
            binding.botonComa -> onNumberPressed(",")
            binding.botonClear -> ""
            binding.botonIgual -> ""
        }
    }

    private fun onNumberPressed(num: String){
        renderScreen(num)
        checkOperacion()
    }

    private fun renderScreen(num: String){
        val resultado:String
        if(binding.pantalla.text == "0" && num != ",")
            resultado = num
        else
            resultado = "${binding.pantalla.text}$num"

        binding.pantalla.text = resultado
    }

    private fun checkOperacion(){
        if(operacion == null)
            numero1 = binding.pantalla.text.toString().toDouble()
        else
            numero2 = binding.pantalla.text.toString().toDouble()
    }
}