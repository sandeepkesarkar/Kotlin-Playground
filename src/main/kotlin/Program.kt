import klaxonPad.PersonsJsonReaderFromFile
import klaxonPad.PersonsPrintList

fun mainLoadPersonsFromJson() {
    PersonsJsonReaderFromFile().readPersonsFromJson(filePath = "data/klaxon/person-data.json").let {
        persons ->
            PersonsPrintList().let {
                persons?.let { it1 -> it.printPersonsFromJsonToConsole(it1) }
            }
    }
}

fun main() {
    mainLoadPersonsFromJson()
}