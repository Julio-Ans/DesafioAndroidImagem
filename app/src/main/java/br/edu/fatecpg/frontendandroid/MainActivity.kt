package br.edu.fatecpg.frontendandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import br.edu.fatecpg.frontendandroid.dao.produtoDAO
import br.edu.fatecpg.frontendandroid.model.Produto
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtnome = findViewById<EditText>(R.id.edtNome)
        val edtvalor = findViewById<EditText>(R.id.edtValor)
        val edturl = findViewById<EditText>(R.id.edtURL)
        val btncadastrar = findViewById<Button>(R.id.btnCadastrar)
        val txtverlista = findViewById<TextView>(R.id.txtLista)


        val dao = produtoDAO()

        btncadastrar.setOnClickListener{
            val nome = edtnome.text.toString()
            val valor = edtvalor.text.toString()
            val url = edturl.text.toString()
            val produto = Produto(nome, valor, url)
            dao.addProduto(produto)

            edtnome.text.clear()
            edtvalor.text.clear()
            edturl.text.clear()
        }

        txtverlista.setOnClickListener{
            val intent = Intent(this, ListaActivity::class.java )
            startActivity(intent)
        }




        val swtTema = findViewById<SwitchCompat>(R.id.switch_tema)

        swtTema.setOnCheckedChangeListener(){
            _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(
            if(isChecked) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
            )
        }

    }
}