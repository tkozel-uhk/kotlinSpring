package cz.fim.kotlinSpring.web

import cz.fim.kotlinSpring.model.Osoba
import cz.fim.kotlinSpring.model.OsobaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * REST kontroléry - namapované pod cestu ../rest
 */
@RestController
@RequestMapping("/rest")
class OsobaController(@Autowired val osobaRepository: OsobaRepository) {

    @GetMapping("/osoby")
    fun getAll(): List<Osoba> = osobaRepository.findAll()

    @GetMapping("/osoby/{id}")
    fun getOsoba(@PathVariable id: Long): Osoba = osobaRepository.getReferenceById(id)

}
