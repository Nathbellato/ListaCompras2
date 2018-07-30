package com.example.ncbel.listacompras2

import java.math.BigDecimal


class Transacao (valor: BigDecimal,
                 categoria: String = "Indefinido"){

    private val valor : BigDecimal = valor
    private val categoria : String = categoria


    fun getValor() : BigDecimal {
        return valor
    }

    fun getCategoria() : String{
        return categoria
    }

}


