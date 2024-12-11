package controllers.ejercicio_6

import java.util.*

/**
 * Clase que representa una pila con un tamaño máximo de elementos.
 * @property elementos Lista mutable que almacena los elementos de la pila.
 * @property maximo Tamaño máximo de la pila (10 elementos).
 */
data class Pila(
    val elementos: MutableList<Int> = mutableListOf(),
    val maximo: Int = 10
)

/**
 * Función principal
 */
fun main() {
    val scan = leerscan() // Inicializar el Scanner para entrada de datos.
    val pila = Pila() // Crear una instancia de Pila.

    var opcion: Int
    do {
        menu() // Mostrar el menú de opciones.
        opcion = seleccionarOpcion(scan) // Leer la opción seleccionada por el usuario.

        when (opcion) {
            1 -> {
                println("Introduce un número para añadir a la pila:")
                val numero = scan.nextInt()
                push(pila, numero) // Añadir el número a la pila.
            }
            2 -> {
                pop(pila) // Quitar el último número de la pila.
            }
            3 -> {
                mostrarContenido(pila) // Mostrar el contenido de la pila.
            }
            4 -> {
                println("Saliendo del programa.")
            }
            else -> {
                println("Elige una opción correcta.")
            }
        }
    } while (opcion != 4) // Repetir hasta que el usuario elija salir.

    terminarScanner(scan) // Cerrar el Scanner.
}

/**
 * Crea y devuelve un objeto Scanner
 * @return Objeto Scanner para leer la entrada del usuario
 */
fun leerscan(): Scanner {
    return Scanner(System.`in`).useLocale(Locale.UK)
}

/**
 * Lee y devuelve la opción seleccionada por el usuario
 * @param scan Objeto Scanner para leer la entrada del usuario
 * @return Número opcion seleccionada
 */
fun seleccionarOpcion(scan: Scanner): Int {
    return scan.nextInt()
}

/**
 * Muestra el menú de opciones
 */
fun menu() {
    println("Elige qué quieres hacer:")
    println("1 -- Añadir número (push)")
    println("2 -- Quitar número (pop)")
    println("3 -- Mostrar contenido de la pila")
    println("4 -- Salir")
}

/**
 * Añade un número a la pila si no ha alcanzado su capacidad máxima
 * @param pila donde se añadirá el número.
 * @param num Número que se añade a la pila
 */
fun push(pila: Pila, num: Int) {
    if (pila.elementos.size < pila.maximo) {
        pila.elementos.add(num)
        println("Número $num añadido a la pila.")
    } else {
        println("La pila está llena. No se puede añadir el número $num.")
    }
}

/**
 * Quita y muestra el último número añadido a la pila si no está vacía
 * @param pila se eliminará el número.
 */
fun pop(pila: Pila) {
    if (pila.elementos.isNotEmpty()) {
        val numero = pila.elementos.removeAt(pila.elementos.lastIndex)
        println("Número $numero eliminado de la pila.")
    } else {
        println("La pila está vacía. No se puede quitar ningún número.")
    }
}

/**
 * Muestra el contenido actual de la pila si no está vacía
 * @param pila muestra el contendido de la pila
 */
fun mostrarContenido(pila: Pila) {
    if (pila.elementos.isNotEmpty()) {
        println("Contenido de la pila: ${pila.elementos}")
    } else {
        println("La pila está vacía.")
    }
}

/**
 * Cierra el objeto Scanner
 * @param scan Objeto Scanner que se cerrará
 */
fun terminarScanner(scan: Scanner) {
    scan.close()
}
