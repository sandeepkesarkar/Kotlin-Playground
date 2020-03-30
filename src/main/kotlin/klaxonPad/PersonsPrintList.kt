package klaxonPad

class PersonsPrintList {
    fun printPersonsFromJsonToConsole(persons: List<Person>) {
        persons.let {
            for (person in persons) {
                println("My name is ${person.name} and I am ${person.age} years old")
            }
        }
    }
}