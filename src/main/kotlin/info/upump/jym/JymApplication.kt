package info.upump.jym

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JymApplication

fun main(args: Array<String>) {
	runApplication<JymApplication>(*args)
}
