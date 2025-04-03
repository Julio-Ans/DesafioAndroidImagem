package br.edu.fatecpg.frontendandroid

import android.os.Bundle
import android.os.StrictMode
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.frontendandroid.adapter.produtoAdapter
import br.edu.fatecpg.frontendandroid.dao.produtoDAO


class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dao = produtoDAO()
        val produtos = dao.getProdutos()

        val rvFilmes = findViewById<RecyclerView>(R.id.rv_lista)
        rvFilmes.layoutManager = LinearLayoutManager(this)
        rvFilmes.adapter = produtoAdapter(produtos)
    }
}