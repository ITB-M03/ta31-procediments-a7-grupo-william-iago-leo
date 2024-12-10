package controllers.ejercicio_2

import java.util.Scanner
import java.time.LocalDate
import java.time.format.DateTimeFormatter


/**
 *@author Iago M
 */
data class Datos(
    val precio: Int,
    val tipoIva: Int,
    val fechaFormateada: LocalDate
)

fun main() {
    val scan = Scanner(System.`in`)

    val almacenar = pedirAlUsuario(scan)
    val impuesto = almacenarTablaDeIva()

    calcularImpuesto(almacenar, impuesto)
}

/**
 * Lo usaremos para almacenar la tabla usando la clase tipo Impuestos
 * @author IagoM
 *  @return Devuelve la lista almacenada
 */
fun almacenarTablaDeIva(): List<Impuestos> {
    return listOf(
        Impuestos(LocalDate.parse("01-01-1986", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 12, 6, 0, 0),
        Impuestos(LocalDate.parse("01-01-1992", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 15, 6, 0, 0),
        Impuestos(LocalDate.parse("01-01-1993", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 15, 6, 3, 0),
        Impuestos(LocalDate.parse("01-01-1995", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 16, 7, 4, 0),
        Impuestos(LocalDate.parse("01-01-2010", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 18, 8, 4, 0),
        Impuestos(LocalDate.parse("15-07-2012", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 21, 10, 4, 0)
    )
}

fun pedirAlUsuario(scanner: Scanner): List<Datos> {
    println("Dime el precio de lo que has comprado")
    val precio = scanner.nextInt()
    println("""Dime el tipo de iva que tiene el producto (Indícalo con el número de cada opción)
        1 -- General
        2 -- Reduit
        3 -- Superreduit
        4 -- Exempt
    """.trimIndent())
    val tipoIva = scanner.nextInt()
    println("Dime el día de la compra")
    val fechaCompraDia = scanner.nextInt()
    println("Dime el mes de la compra")
    val fechaCompraMes = scanner.nextInt()
    println("Dime el año de la compra")
    val fechaCompraAño = scanner.nextInt()

    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    val fechaCompra = LocalDate.of(fechaCompraAño, fechaCompraMes, fechaCompraDia)
    val fechaFormateada = fechaCompra

    println("Fecha de compra formateada: $fechaFormateada")

    val lista: List<Datos> = listOf(Datos(precio, tipoIva, fechaFormateada))
    return lista
}

fun calcularImpuesto(datos: List<Datos>, impuestos: List<Impuestos>) {
    for (dato in datos) {
        val impuestoVigente = impuestos.last { it.fecha <= dato.fechaFormateada }
        val ivaAplicado = impuestoVigente.obtenerIvaVigente(dato.fechaFormateada, dato.tipoIva)
        val precioConIva = calcularIVA(dato.precio, ivaAplicado)
        println("Precio original: ${dato.precio} € - IVA aplicado: $ivaAplicado% - Precio con IVA: $precioConIva €")
    }
}

fun calcularIVA(precio: Int, tipoIva: Int): Double {
    val calculo = precio * (1 + tipoIva / 100.0)
    return calculo
}

/**
 * Lo usaremos para tener los datos en una lista sin problemas con las fechas
 *
 * @author IagoM
 *
 */
data class Impuestos(
    val fecha: LocalDate,
    val general: Int,
    val reduit: Int,
    val superReduit: Int,
    val exempt: Int
) {
    /**
     * Convertimos el tipo de iva que nos ha dado el usuario para poder usarlo para buscar
     * @author IagoM
     * @param fechaCompra Le pasamos la fecha de compra
     * @param tipoIva le pasamos el tipoDeIVa
     */
    fun obtenerIvaVigente(fechaCompra: LocalDate, tipoIva: Int): Int {
        val tipoDelIVa = if (fechaCompra.isAfter(fecha)) {
            when (tipoIva) {
                1 -> general
                2 -> reduit
                3 -> superReduit
                4 -> exempt
                else -> throw IllegalArgumentException("Tipo de IVA no válido")
            }
        } else {
            // Si la fecha de compra no está después de la fecha del impuesto, devolvemos el IVA correspondiente
            when (tipoIva) {
                1 -> general
                2 -> reduit
                3 -> superReduit
                4 -> exempt
                else ->  exempt
            }
        }
        return tipoIva
    }
}