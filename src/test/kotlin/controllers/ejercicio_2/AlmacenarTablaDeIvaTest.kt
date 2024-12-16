package controllers.ejercicio_2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AlmacenarTablaDeIvaTest {

@Test
 fun tamanyRespostaTest(){
  val expected=6
  val impuestos = almacenarTablaDeIva()
  assertEquals(6, impuestos.size)
 }
  @Test
  fun primerValorTest(){
   val impuestos = almacenarTablaDeIva()
   val expected = LocalDate.parse("01-01-1986", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
   assertEquals(expected, impuestos[0])
  }
 @Test
 fun ultimValorTest(){
  val impuestos = almacenarTablaDeIva()
  val expected = LocalDate.parse("15-07-2012", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
  assertEquals(expected, impuestos.last())
 }
}