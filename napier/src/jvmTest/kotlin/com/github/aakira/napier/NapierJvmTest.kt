package com.github.aakira.napier

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class NapierJvmTest {

    private val debugAntilog = DebugAntilog()

    @Test
    fun `Check createStackElementTag`() {
        assertEquals("Hoge", debugAntilog.createStackElementTag("com.github.aakira.napier.Hoge"))
        assertEquals("Hoge2", debugAntilog.createStackElementTag("AA\$com.github.aakira.napier.Hoge2"))
        assertNotEquals("default", debugAntilog.createStackElementTag("com.github.aakira.napier.Hoge3\$default"))
    }

    @Test
    fun `Check buildLog`() {
        assertEquals(
            "[VERBOSE] defaultTag - message",
            debugAntilog.buildLog(Napier.Level.VERBOSE, "defaultTag", "message")
        )
    }
}
