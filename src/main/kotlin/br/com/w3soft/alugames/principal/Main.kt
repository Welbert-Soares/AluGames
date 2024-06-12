package org.example.br.com.w3soft.alugames.principal

import br.com.w3soft.alugames.servicos.ConsumoApi
import org.example.br.com.w3soft.alugames.modelo.Jogo
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)

    do {
        println("Digite um código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb)
        }

        resultado.onFailure {
            println("Jogo inexistente, tente novamente com outro código.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada para o jogo? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a descrição:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }

            println(meuJogo)
        }

        println("Deseja buscar outro jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true))

    println("Jogo encontrado com sucesso!")
}