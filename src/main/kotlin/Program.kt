import klaxonPad.JsonReaderFromFile

fun main() {
    val jsonReaderFromFile = JsonReaderFromFile().also { it ->
        it.mainLoadPersonsFromJson()
    }
}