package controllers.ejercicio_4

import java.util.*

fun main(){

    val scan =  iniScanner()

    val palabraClave = "superusuario"



    println("introduce el password:")
    validarSuperusuario(palabraClave,scan)

    finScanner(scan)

}

fun iniScanner():Scanner{
    return Scanner(System.`in`).useLocale(Locale.UK)
}

fun password(scan: Scanner):String{
    val password = scan.nextLine()
    return password
}

fun validarSuperusuario(palabraClave:String, scan: Scanner){
    var intentos = 3
    var pass = password(scan)

    if (pass != palabraClave){
        println("introduce la contraseña otra vez")
        pass = password(scan)
        while(intentos > 0){
            if (pass != palabraClave){
                println("introduce la contraseña otra vez")
                pass = password(scan)


            }
            intentos--
        }
        println("la contraseña es correcta")
    }
    else println("la contraseña es incorrecta")
}

fun finScanner(scan:Scanner){
    scan.close()
}

