package com.example.trocatela_pos2025

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class LancamentoActivity : AppCompatActivity() {

    private lateinit var nrCod : EditText
    private lateinit var nrQtd : EditText
    private lateinit var nrValor : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento)

        nrCod = findViewById(R.id.nrCod)
        nrQtd = findViewById(R.id.nrQtd)
        nrValor = findViewById(R.id.nrValor)
    }

    fun btConfirmarOnClick(view: View) {
        val intent = Intent(this, ConfirmarActivity::class.java)

        intent.putExtra("cod", nrCod.text.toString())
        intent.putExtra("qtd", nrQtd.text.toString())
        intent.putExtra("valor", nrValor.text.toString())

        startActivity(intent)
    }

    fun btListarOnClick(view: View) {
        val intent = Intent(this, ListarActivity::class.java)
        getResult.launch(intent)
    }

    private val getResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {it ->
        if(it.resultCode == RESULT_OK){
            val codRetorno = it.data?.getIntExtra("codRetorno", 0)
            nrCod.setText(codRetorno.toString())
        }

    }
}