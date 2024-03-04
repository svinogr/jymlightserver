package info.upump.jym.javaconfig

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.ByteArrayHttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class Config : WebMvcConfigurer {

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(byteArrayHttpMessageConverter())
        super.configureMessageConverters(converters)
    }

    @Bean
    fun byteArrayHttpMessageConverter(): ByteArrayHttpMessageConverter{
        val byteArrayHttpMessageConverter = ByteArrayHttpMessageConverter()
        byteArrayHttpMessageConverter.supportedMediaTypes = (listOf(MediaType.IMAGE_JPEG, MediaType.APPLICATION_OCTET_STREAM))

        return byteArrayHttpMessageConverter
    }
}
