package klaxonPad

import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import kotlin.test.assertFailsWith

class PersonsJsonReaderFromStreamTest {
    @Test
    fun `when valid filePath read file from JSON stream`() {
        PersonsJsonReaderFromStream().let {
            val persons : List<Person> = it.readPersonsFromStream(filePath = "data/klaxon/person-data.json")
            persons.isNullOrEmpty()
        }
    }

    @Test
    fun `when filePath is empty throw IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            PersonsJsonReaderFromStream().let {
                it.readPersonsFromStream(filePath = "")
            }
        }
    }

    @Test
    fun `when not valid filePath throw FileNotFoundException`() {
        assertFailsWith<FileNotFoundException> {
            PersonsJsonReaderFromStream().let {
                it.readPersonsFromStream(filePath = "data/klaxon/not-a-valid-filePath.json")
            }
        }
    }
}