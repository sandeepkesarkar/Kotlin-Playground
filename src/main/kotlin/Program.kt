import klaxonPad.PersonsJsonReaderFromFile
import klaxonPad.PersonsPrintList

fun mainLoadPersonsFromJson() {
    PersonsJsonReaderFromFile().readPersonsFromJson(filePath = "data/klaxon/person-data.json").let { persons ->
        persons?.let {
            PersonsPrintList().let {
                it.printPersonsFromJsonToConsole(persons)
            }
        }
    }
}

fun main() {
    mainLoadPersonsFromJson()
}