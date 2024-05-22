package com.devhevertonaraujo.mvp

import com.devhevertonaraujo.mvp.Model.Produto
import org.junit.Assert
import org.junit.Test
import org.mockito.Mock

class ProdutoTest {

    @Mock
    val produtos: MutableList<Produto> = mutableListOf(
        Produto( "Placa de video", "R$ 800", "desc1"),
        Produto( "Processador", "R$ 1800", "desc2"),
        Produto( "SSD", "R$ 600", "desc3"),
        )
    @Test
    fun `test se  a nossa lista de esta vazia`() {
        val nao_esta_vazia = produtos.isNotEmpty()
        val esta_vazia = produtos.isEmpty()


        if (nao_esta_vazia) {
            for (prt in 0..produtos.size - 1) {

                print("" + produtos.get(prt).nome)
                print("" + produtos.get(prt).preco)
                print("" + produtos.get(prt).descricao + "\n")

            }
        } else if (esta_vazia) {
            print("A lista esta vazia!")
        }
        Assert.assertEquals(nao_esta_vazia, true)
    }
        @Test
        fun `test Vereficar quantos intens tem na nossa lista`() {
            Assert.assertEquals(produtos.size, 3)

        }
    @Test
    fun `test vereficar se os produtos são adicionados na lista de produtos`() {
        val produto4 = Produto("HD", "R$200","desc4")
        produtos.add(produto4)
        Assert.assertEquals(produtos.get(3).nome, "HD")

        }
        }



