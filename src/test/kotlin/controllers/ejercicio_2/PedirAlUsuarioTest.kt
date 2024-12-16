package controllers.ejercicio_2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayInputStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class PedirAlUsuarioTest {

@Test
 fun tamanyRespostaTest() {
  val simulado=pedirAlUsuario(scanner = Scanner(System.`in`))
  val expected=1
  assertEquals(expected, simulado.size)
 }
 @Test
 fun anyPetitTest() {
  val input = """
            2
            2
            2
            2
            2
        """.trimIndent()
  val scanner = Scanner(ByteArrayInputStream(input.toByteArray()))
  val result = pedirAlUsuario(scanner)
  val expected = Datos(250, 2, LocalDate.parse("02-02-0002", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
  assertEquals(expected, result[0])
 }
 @Test
 fun anyGranTest() {
  val input = """
            2
            2
            2
            2
            2222
        """.trimIndent()
  val scanner = Scanner(ByteArrayInputStream(input.toByteArray()))
  val result = pedirAlUsuario(scanner)
  val expected = Datos(250, 2, LocalDate.parse("02-02-2222", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
  assertEquals(expected, result[0])
 }
}