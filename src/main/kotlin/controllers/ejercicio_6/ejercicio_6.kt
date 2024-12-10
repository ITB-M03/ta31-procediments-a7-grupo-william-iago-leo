package controllers.ejercicio_6

import java.util.*

data class pila{

}

fun main(){
    val scan = leerscan()

    val numero = seleccionarOpcion(scan)

    menu(numero)

    terminarScanner(scan)
}

fun leerscan():Scanner {
    return Scanner(System.`in`).useLocale(Locale.UK)
}

fun seleccionarOpcion(scan: Scanner):Int{
    val seleccion = scan.nextInt()
    return seleccion
}


fun menu(seleccion:Int){

    when(seleccion){

    }

}


fun terminarScanner(scan:Scanner){
    scan.close()
}