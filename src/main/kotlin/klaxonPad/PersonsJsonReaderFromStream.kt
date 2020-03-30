package klaxonPad

import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import java.io.File
import java.io.StringReader

class PersonsJsonReaderFromStream {
    fun readPersonsFromStream(filePath: String): List<Person> {
        if (filePath.isNullOrEmpty())
            throw IllegalArgumentException("filePath can't be null or empty")

        val persons = arrayListOf<Person>()
        JsonReader(StringReader(File(filePath).readText())).use { reader ->
            {
                reader.beginArray {
                    while (reader.hasNext()) {
                        val person = Klaxon().parse<Person>(reader)
                        person?.let { persons.add(it) }
                    }
                }
            }
        }
        return persons
    }
}