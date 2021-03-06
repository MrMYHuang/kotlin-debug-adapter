package org.javacs.ktda.core

import org.javacs.ktda.core.event.DebuggeeEventBus
import org.javacs.ktda.util.ObservableList
import java.io.InputStream
import java.io.OutputStream

/** A debuggee that is launched upon construction */
interface Debuggee {
	val threads: ObservableList<DebuggeeThread>
	val eventBus: DebuggeeEventBus
	val stdin: OutputStream?
		get() = null
	val stdout: InputStream?
		get() = null
	val stderr: InputStream?
		get() = null
	
	fun exit()
	
	fun threadByID(id: Long): DebuggeeThread? = threads
		.asSequence()
		.filter { it.id == id }
		.firstOrNull()
}
