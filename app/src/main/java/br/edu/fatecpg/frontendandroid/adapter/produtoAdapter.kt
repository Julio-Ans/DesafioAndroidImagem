package br.edu.fatecpg.frontendandroid.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.frontendandroid.R
import br.edu.fatecpg.frontendandroid.model.Produto
import com.bumptech.glide.Glide
import kotlinx.coroutines.withContext

class produtoAdapter(private val produtos:List<Produto>)
    : RecyclerView.Adapter<produtoAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val txvNome = itemView.findViewById<TextView>(R.id.txvNome)
        val txvValor = itemView.findViewById<TextView>(R.id.txvValor)
        val imgProduto = itemView.findViewById<ImageView>(R.id.ivImagem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.txvNome.text = produto.nome
        holder.txvValor.text = produto.valor
        Glide.with(holder.itemView)
            .load(produto.url)
            .dontAnimate()
            .into(holder.imgProduto);



    }


}