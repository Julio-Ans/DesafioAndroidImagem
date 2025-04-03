package br.edu.fatecpg.frontendandroid.dao

import br.edu.fatecpg.frontendandroid.model.Produto

class produtoDAO {
    companion object{
        private val produtos = mutableListOf<Produto>()
    }
    fun addProduto(produto: Produto){
        produtos.add(produto)
    }

    fun getProdutos():List<Produto>{
        return produtos
    }

}