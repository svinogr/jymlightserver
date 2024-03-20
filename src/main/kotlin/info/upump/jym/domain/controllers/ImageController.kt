package info.upump.jym.domain.controllers

import com.google.gson.JsonObject
import info.upump.jym.domain.exception.NotHaveObjectInDB
import info.upump.jym.domain.exception.NotHaveResource
import info.upump.jym.domain.service.StorageService
import jakarta.servlet.ServletContext
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController()
@RequestMapping("/api/image")
class ImageController {
    @Autowired
    lateinit var servCo: ServletContext

    @Autowired
    lateinit var storageService: StorageService

    @GetMapping("{name}", MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    fun getImage(@PathVariable name: String, h: HttpServletResponse): ByteArray? {
        println(name)
                return storageService.loadAsResource(name).file.readBytes()

    }

    @PostMapping(consumes = ["multipart/form-data"])
    fun uploadImage(@RequestParam("file") file: MultipartFile) {
        println("upload ${file.bytes.size}")
        println("upload ${file.name}")
        storageService.storage(file)
    }

    @ExceptionHandler(NotHaveResource::class)
    fun responseNotHaveResource(e: NotHaveResource): ResponseEntity<String> {
        val responseJSON = JsonObject()
        responseJSON.addProperty("message", e.message)

        return ResponseEntity<String>(responseJSON.toString(), HttpStatus.NOT_FOUND)
    }

}