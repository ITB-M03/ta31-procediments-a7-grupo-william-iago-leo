package controllers.ejercicio_5

import java.util.Scanner

/**
 * Función principal
 */
fun main(){
    val scan = Scanner(System.`in`)
    val textoUser = pedirTitulo(scanner = scan)
    title(textoUser)



}

/**
 * Función para hacer un
 */
fun title(texto:String){
    val anchoPantalla = 80
    val espacioIzquierda = (anchoPantalla - texto.length) / 2
    val textoCentrado = " ".repeat(espacioIzquierda) + texto
    println(textoCentrado)


}
fun pedirTitulo(scanner: Scanner):String{
   val titulo =  scanner.next()
    return titulo

}