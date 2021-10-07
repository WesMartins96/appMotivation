package com.example.appmotivation.repository

import com.example.appmotivation.infra.MotivationConstants
import java.util.*

data class frase (val descricao: String, val categoria: Int)

class Mock {

    private val ALL = MotivationConstants.FRASE.ALL
    private val HAPPY = MotivationConstants.FRASE.HAPPY
    private val MORNING = MotivationConstants.FRASE.MORNING

    private val mListFrases: List<frase> = listOf(
        //HAPPY
        frase("O que não te desafia não te transforma", HAPPY),
        frase("Se você não gosta do seu destino, não o aceite. Em vez disso, tenha a coragem de mudá-lo do jeito que você quer que ele seja", HAPPY),
        frase("Desista de me fazer desistir!", HAPPY),
        frase("Saber o que é certo e escolher ignorá-lo é um ato de covardia", HAPPY),
        frase("Desde que você não desista, vai sempre existir salvação", HAPPY),
        frase("Não importa o quão poderoso você se torne nunca tente fazer tudo sozinho, caso contrario irá falhar", HAPPY),
        frase("Pode se encontrar a felicidade mesmo nas horas mais sombrias, se a pessoa se lembrar de acender a luz", HAPPY),
        //MORNING
        frase("Mantenha o foco. Nunca desvie seus olhos, porque se uma abertura surge, mesmo nosso poder insignificante pode ser suficiente para determinar o destino do mundo. É por isso que todos devem ficar alertas e prontos a atacar a qualquer momento!", MORNING),
        frase("Na sociedade, aqueles que não possuem muitas habilidades, tendem a reclamar mais", MORNING),
        frase("Trabalho duro é inútil para aqueles que não acreditam em si mesmos", MORNING),
        frase("Enquanto você está vivo, você precisa de uma razão para sua existência. Ser incapaz de encontrar uma razão é o mesmo que estar morto", MORNING),
        frase("A vida das pessoas não termina quando eles morrem. Termina quando elas perdem a fé", MORNING),
        frase("Aproveite tudo ao seu redor, antes que os momentos se tornem memórias", MORNING),
        frase("Se você não se sente a altura,suba até ela", MORNING)
    )

    fun getFrase(categoriaId: Int) : String {

        val filtrado = mListFrases.filter { (it.categoria == categoriaId || categoriaId == ALL) }
        val rand = Random().nextInt(filtrado.size)
        return filtrado[rand].descricao
    }
}