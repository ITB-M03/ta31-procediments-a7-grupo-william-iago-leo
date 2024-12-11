package controllers.ejercicio_6

import java.util.*

data class Pila {
    val elementos = mutableListOf<Int>()
    val maximo = 10
}

fun main() {
    val scan = leerscan()
    val pila = Pila() // Crear una instancia de Pila

    var opcion: Int
    do {
        menu()
        opcion = seleccionarOpcion(scan)

        when (opcion) {
            1 -> {
                println("Introduce un número para añadir a la pila:")
                val numero = scan.nextInt()
                push(pila, numero)
            }
            2 -> {
                pop(pila)
            }
            3 -> {
                mostrarContenido(pila)
            }
            4 -> {
                println("Saliendo del programa.")
            }
            else -> {
                println("Elige una opción correcta.")
            }
        }
    } while (opcion != 4)

    terminarScanner(scan)
}

fun leerscan(): Scanner {
    return Scanner(System.`in`).useLocale(Locale.UK)
}

fun seleccionarOpcion(scan: Scanner): Int {
    return scan.nextInt()
}

fun menu() {
    println("Elige qué quieres hacer:")
    println("1 -- Añadir número (push)")
    println("2 -- Quitar número (pop)")
    println("3 -- Mostrar contenido de la pila")
    println("4 -- Salir")
}

fun push(pila: Pila, num: Int) {
    if (pila.elementos.size < pila.maximo) {
        pila.elementos.add(num)
        println("Número $num añadido a la pila.")
    } else {
        println("La pila está llena. No se puede añadir el número $num.")
    }
}

fun pop(pila: Pila) {
    if (pila.elementos.isNotEmpty()) {
        val numero = pila.elementos.removeAt(pila.elementos.lastIndex)
        println("Número $numero eliminado de la pila.")
    } else {
        println("La pila está vacía. No se puede quitar ningún número.")
    }
}

fun mostrarContenido(pila: Pila) {
    if (pila.elementos.isNotEmpty()) {
        println("Contenido de la pila: ${pila.elementos}")
    } else {
        println("La pila está vacía.")
    }
}

fun terminarScanner(scan: Scanner) {
    scan.close()
}
