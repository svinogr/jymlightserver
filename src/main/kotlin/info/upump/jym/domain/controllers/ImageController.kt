package info.upump.jym.domain.controllers

import jakarta.servlet.ServletContext
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream

@Controller()
@RequestMapping("api/image")
class ImageController {
    @Autowired
    lateinit var servCo: ServletContext
    @GetMapping("{name}", MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    fun getImage(@PathVariable name: String, h: HttpServletResponse): ByteArray? {
        println(name)

     //   val i = ByteArrayInputStream(File("info/upump/jym/pic/arnold.jpg").readBytes())

     val inp =  servCo.getResourceAsStream("/info/upump/jym/pic/arnold.jpg")

        return inp.readAllBytes()
    }
}