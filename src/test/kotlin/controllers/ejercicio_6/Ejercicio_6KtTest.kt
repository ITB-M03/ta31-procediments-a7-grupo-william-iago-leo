package controllers.ejercicio_6

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class PilaTests {
    @Test
    fun testPush() {
        val pila = Pila()
        push(pila, 5)
        assertEquals(listOf(5), pila.elementos)
    }

    @Test
    fun testPushPila() {
        val pila = Pila(elementos = MutableList(10) { it }, maximo = 10)
        assertFailsWith<IllegalStateException> { push(pila, 11) }
    }
}