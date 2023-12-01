package cz.fim.kotlinSpring.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Entita Osoba
 */
@Entity
class Osoba() {  //musí mít bezparametrický konstruktor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var jmeno: String = ""
    var prijmeni: String = ""
    var email: String = ""
}

/**
 * JPA Repositář pro entitu Osoba - bude vygenerováno v Runtimu
 */
interface OsobaRepository : JpaRepository<Osoba, Long>
