package controllers.ejercicio_4

import java.util.*

fun main(){

    val scan =  iniScanner()

    val palabraClave = "superusuario"

    println("introduce el password:")
   val contrasenya = password(scan)

    validarSuperusuario(palabraClave, contrasenya)

    finScanner(scan)

}

fun iniScanner():Scanner{
    return Scanner(System.`in`).useLocale(Locale.UK)
}

fun password(scan: Scanner):String{
    val password = scan.nextLine()
    return password
}

fun validarSuperusuario(password:String,palabraClave:String){
    var intentos = 3
    if (password != palabraClave){
        while(intentos > 0){
            if (password != palabraClave){
                println("introduce la contraseña otra vez")
            }
            intentos--
        }
        println("la contraseña es incorrecta")
    }
    else println("la contraseña es correcta")
}

fun finScanner(scan:Scanner){
    scan.close()
}

