package klaxonPad

import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import kotlin.test.assertFailsWith

class JsonReaderFromStreamTest {
    @Test
    fun `when valid filePath read file from JSON stream`() {
        JsonReaderFromStream().let {
            val persons : List<Person> = it.readPersonsFromStream(filePath = "data/klaxon/person-data.json")
            persons.isNullOrEmpty()
        }
    }

    @Test
    fun `when filePath is empty throw IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            JsonReaderFromStream().let {
                it.readPersonsFromStream(filePath = "")
            }
        }
    }

    @Test
    fun `when not valid filePath throw FileNotFoundException`() {
        assertFailsWith<FileNotFoundException> {
            JsonReaderFromStream().let {
                it.readPersonsFromStream(filePath = "data/klaxon/not-a-valid-filePath.json")
            }
        }
    }
}