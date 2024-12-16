package controllers.ejercicio_2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class CalcularIVATest {

@Test
 fun valorRespostaTest() {
  val result:Double=calcularIVA(2, 2)
  val expected=2.04
  assertEquals(expected,result)
 }
  @Test
  fun valorRespostaTest2() {
   val result:Double=calcularIVA(1, 1)
   val expected=1.01
   assertEquals(expected,result)
  }
  @Test
  fun valorRespostaTest3() {
   val result:Double=calcularIVA(3, 3)
   val expected=3.09
   assertEquals(expected,result)
  }
}