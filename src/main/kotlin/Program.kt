import klaxonPad.JsonReaderFromFile

fun main() {
    val jsonReaderFromFile = JsonReaderFromFile().also { it ->
        var persons = it.readPersonsFromJson(filePath = "data/klaxon/person-data.json")
        if (persons != null) {
            it.printPersonsFromJson(persons)
        }
    }
}