package cz.fim.kotlinSpring

import cz.fim.kotlinSpring.model.Osoba
import cz.fim.kotlinSpring.model.OsobaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


/**
 * Webové kontroléry - namapované pod cestu ../html
 */
@Controller
@RequestMapping("/html")
class OsobaWebController(@Autowired val osobaRepository: OsobaRepository) {

    /**
     * Zobrazí všechny osoby prostřednictvím view osoby.html
     */
    @GetMapping("/osoby")
    fun getAll(model: Model): String {
        model.addAttribute("osoby", osobaRepository.findAll())
        return "osoby"
    }

    /**
     * Zobrazí formulář pro přidání osoby pomocí view osobaForm.html
     */
    @GetMapping("/osoby/add")
    fun newOsoba(model: Model): String {
        model.addAttribute("osoba", Osoba())
        return "osobaForm"
    }

    /**
     * Ukládá osobu z formy osobaForm.html do databáze
     * Používá se jak pro Edit, tak pro Add
     */
    @PostMapping("/osoby/save")
    fun saveOsoba(osoba: Osoba): String {
        osobaRepository.save(osoba)
        return "redirect:/html/osoby"
    }

    /**
     * Zobrazí formulář pro editaci existující osoby pomocí view osobaForm.html
     */
    @GetMapping("/osoby/{id}")
    fun editOsoba(model: Model, @PathVariable id: Long): String {
        model.addAttribute("osoba", osobaRepository.getReferenceById(id))
        return "osobaForm"
    }

    /**
     * Smaže osobu z databáze - voláno z view osoby.html
     */
    @GetMapping("/osoby/{id}/delete")
    fun deleteOsoba(@PathVariable id: Long): String {
        osobaRepository.deleteById(id)
        return "redirect:/html/osoby"
    }
}