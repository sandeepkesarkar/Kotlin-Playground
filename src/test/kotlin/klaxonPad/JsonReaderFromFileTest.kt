package klaxonPad

import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import kotlin.test.assertFailsWith

class JsonReaderFromFileTest {
    @Test
    fun `when filePath is empty throw IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            JsonReaderFromFile().let {
                it.readPersonsFromJson(filePath = "")
            }
        }
    }

    @Test
    fun `when not valid filePath throw FileNotFoundException`() {
        assertFailsWith<FileNotFoundException> {
            JsonReaderFromFile().let {
                it.readPersonsFromJson(filePath = "data/klaxon/not-a-valid-filePath.json")
            }
        }
    }

    @Test
    fun `when valid filePath read JSON data from file`() {
        JsonReaderFromFile().let {
            var persons = it.readPersonsFromJson(filePath = "data/klaxon/person-data.json")
            persons.isNullOrEmpty()
        }
    }
}