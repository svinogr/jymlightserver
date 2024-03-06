package info.upump.jym

import info.upump.jym.domain.service.StorageService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class JymApplication

fun main(args: Array<String>) {
	runApplication<JymApplication>(*args)
}

@Bean
fun init(storageService: StorageService): CommandLineRunner? {
	return CommandLineRunner { args: Array<String?>? ->
		print("init__________")
		storageService.init()
	}
}