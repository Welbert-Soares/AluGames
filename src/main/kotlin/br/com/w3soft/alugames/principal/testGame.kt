import br.com.w3soft.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Welbert", "welbertsoares@outlook.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Jeni",
        "jeni@email.com",
        "01/01/1990",
        "jeni")

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "27/02/1999"
        it.usuario = "W3Nitro"

    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "W3Nitrooo"
    println(gamer1)
}