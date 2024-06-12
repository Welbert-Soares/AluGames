package org.example.br.com.w3soft.alugames.modelo

data class InfoJogo(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}