package klaxonPad

import com.beust.klaxon.Klaxon
import java.io.File
import java.io.FileNotFoundException

class PersonsJsonReaderFromFile {
    fun readPersonsFromJson(filePath:String): List<Person>? {
        if (filePath.isNullOrEmpty())
            throw IllegalArgumentException("filePath can't be null or empty")

        return try {
            Klaxon().parseArray(File(filePath).readText())
        } catch (fileEx: FileNotFoundException) {
            throw fileEx
        }
        catch (ex:Exception) {
            throw Exception(ex)
        }
    }
}