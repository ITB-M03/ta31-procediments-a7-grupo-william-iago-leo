package controllers.ejercicio_3

import java.util.*

fun main(){

    val scan = inicioscan()

    println("ingresa un numero entre 1 y 3999:")
    val numero = leerNumero(scan)

    val romanos = numerosRomanos(numero)

    imprimirNumerosRomanos(numero,romanos)

    finScan(scan)
}

fun inicioscan(): Scanner {
    return Scanner(System.`in`).useLocale(Locale.UK)
}

fun leerNumero(scan: Scanner):Int{
    val numero = scan.nextInt()
        return numero
}

fun numerosRomanos(numero:Int):String{
    val valores = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val simbolos = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

    var num = numero
    val resultado = StringBuilder()

    for (i in valores.indices){
        while(num >= valores[i]){
            resultado.append(simbolos[i])
            num -= valores[i]
        }
    }
    return resultado.toString()
}

fun imprimirNumerosRomanos(numero: Int, romano:String){
    if (numero > 0 && numero <= 3999){
        println("el numero $numero en romano es $romano")
    }
    else println("el numero se encuentra fuera de los limites")
}

fun finScan(scan:Scanner){
    scan.close()
}
