package br.com.w3soft.alugames.modelo

import kotlin.random.Random

data class Gamer(var nome: String, var email:String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var idInterno: String? = null
        private set

    constructor(nome:String, email:String, dataNascimento:String, usuario:String) :
            this(nome, email) {
                this.dataNascimento = dataNascimento
                this.usuario = usuario
                criarIdInterno()
            }

    init {
        if (nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome não pode ser vazio")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\$")
        if (regex.matches(email)){
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

}
