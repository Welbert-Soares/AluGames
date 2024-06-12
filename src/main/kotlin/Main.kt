package org.example

import com.google.gson.Gson
import org.jetbrains.annotations.Nullable
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()
    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

//    try {
//        val meuJogo = Jogo(
//            meuInfoJogo.info.title,
//            meuInfoJogo.info.thumb)
//
//        println(meuJogo)
//    } catch (ex: NullPointerException) {
//        println("Jogo inexistente, tente novamente com outro código.")
//    }

    val resultado = runCatching {
        val meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb)

        println(meuJogo)
    }

    resultado.onFailure {
        println("Jogo inexistente, tente novamente com outro código.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada para o jogo? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)) {
            println("Insira a descrição:")
            val descricao = leitura.nextLine()
            meuJogo.descricao
        } else {

        }
    }
}