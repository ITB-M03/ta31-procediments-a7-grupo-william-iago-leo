package controllers.ejercicio_2

import java.util.Scanner
import java.time.LocalDate
import java.time.format.DateTimeFormatter


data class Impuestos(
    val fecha:LocalDate,
    val general:Int,
    val reduit:Int,
    val superReduit:Int,
    val exempt:Int

)
data class datos(
    val precio:Int,
    val tipoIVa: Int,
    val fechaFormateada:LocalDate
)
fun main(){
    val scan = Scanner(System.`in`)

    var almacenar =  pedirAlUsuario(scan)

    var impuesto = calcularIva()

     calcularImpuesto(almacenar,impuesto)

}

fun calcularIva():List<Impuestos> {
    val impuestos = listOf(
        Impuestos(LocalDate.parse("01-01-1986", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 12, 6, 0, 0),
        Impuestos(LocalDate.parse("01-01-1992", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 15, 6, 0, 0),
        Impuestos(LocalDate.parse("01-01-1993", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 15, 6, 3, 0),
        Impuestos(LocalDate.parse("01-01-1995", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 16, 7, 4, 0),
        Impuestos(LocalDate.parse("01-01-2010", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 18, 8, 4, 0),
        Impuestos(LocalDate.parse("15-07-2012", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 21, 10, 4, 0)
    )

    return impuestos
}

fun pedirAlUsuario(scanner: Scanner): List<datos> {
    println("Dime el precio de lo que has comprado")
    val precio = scanner.nextInt()
    println("""Dime el tipo de iva que tiene el producto (Indicamelo con el numero de cada opción)
        1 -- general
        2 -- Reduit
        3 -- Superreduit
        4 -- Exempt
    """.trimIndent())
    val tipoIva = scanner.nextInt()
    println("Dime el día de la compra")
    val fechaCompra_dia = scanner.nextInt()
    println("Dime el mes de la compra")
    val fechaCompra_mes = scanner.nextInt()
    println("Dime el año de la compra")
    val fechaCompra_año = scanner.nextInt()

    // Definir el formato
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    // Crear la fecha usando LocalDate
    val fechaCompra = LocalDate.of(fechaCompra_año, fechaCompra_mes, fechaCompra_dia)
    val fechaFormateada = fechaCompra

    println("Fecha de compra formateada: $fechaFormateada")

    val lista: List<datos> = listOf(datos(precio, tipoIva, fechaFormateada))
    return lista
}

fun calcularImpuesto(datos: List<datos>, impuestos: List<Impuestos>){


}










