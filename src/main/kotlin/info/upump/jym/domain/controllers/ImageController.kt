package info.upump.jym.domain.controllers

import info.upump.jym.domain.service.StorageService
import jakarta.servlet.ServletContext
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController()
@RequestMapping("/api/image")
class ImageController {
    @Autowired
    lateinit var servCo: ServletContext

    @Autowired
    lateinit var storageService: StorageService

    @GetMapping("upload/{name}", MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    fun getImage(@PathVariable name: String, h: HttpServletResponse): ByteArray? {
        println(name)

        //   val i = ByteArrayInputStream(File("info/upump/jym/pic/arnold.jpg").readBytes())

      //  val inp = servCo.getResourceAsStream("/info/upump/jym/pic/arnold.jpg")
      return  storageService.loadAsResource(name).file.readBytes()

        //return inp.readAllBytes()
    }

    @PostMapping("upload", consumes = ["multipart/form-data"])
    fun uploadImage(@RequestParam("file") file: MultipartFile) {
        println("upload ${file.bytes.size}")
        storageService.storage(file)
    }

}