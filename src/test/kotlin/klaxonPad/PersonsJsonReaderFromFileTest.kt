package klaxonPad

import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import kotlin.test.assertFailsWith

class PersonsJsonReaderFromFileTest {
    @Test
    fun `when valid filePath read JSON data from file`() {
        PersonsJsonReaderFromFile().let {
            var persons = it.readPersonsFromJson(filePath = "data/klaxon/person-data.json")
            persons.isNullOrEmpty()
        }
    }

    @Test
    fun `when filePath is empty throw IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            PersonsJsonReaderFromFile().let {
                it.readPersonsFromJson(filePath = "")
            }
        }
    }

    @Test
    fun `when not valid filePath throw FileNotFoundException`() {
        assertFailsWith<FileNotFoundException> {
            PersonsJsonReaderFromFile().let {
                it.readPersonsFromJson(filePath = "data/klaxon/not-a-valid-filePath.json")
            }
        }
    }
}