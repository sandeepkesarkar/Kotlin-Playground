package klaxonPad

import com.beust.klaxon.Klaxon
import java.io.File

class JsonReaderFromFile {
    fun readPersonsFromJson(filePath:String): List<Person>? {
        if (filePath.isNullOrEmpty())
            throw IllegalArgumentException("filePath can't be null or empty")

        return try {
            Klaxon().parseArray(File(filePath).readText())
        } catch (ex:Exception) {
            throw Exception(ex)
        }
    }

    fun printPersonsFromJson(persons: List<Person>) {
        persons.let {
            for (person in persons) {
                println("My name is ${person.name} and I am ${person.age} years old")
            }
        }
    }

    fun mainPersonsFromJson() {
        val persons =  readPersonsFromJson(filePath = "data/klaxon/person-data.json")
        persons?.let { this.printPersonsFromJson(it) }
    }
}