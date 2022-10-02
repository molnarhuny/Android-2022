import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

fun firstProblem() {

    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}

fun String.monogram() = this.split(" ").map { it.first() }.joinToString (separator = "")
fun List<String>.compactString() = this.joinToString(separator = "#")
fun List<String>.longestString() = this.maxByOrNull { it.length }

fun secondProblem() {

    var testString = "Pinter Bela"
    println("The monogram of the test Person: ${testString.monogram()}")

    val list = listOf("apple", "pear", "melon")
    println("The compact list with the '#' separator is: ${list.compactString()}");

    val fruits = mutableListOf<String>("apple", "pear", "melon", "strawberry")
    println("The longest fruit name in the list is: ${list.longestString()}");

}


data class DateClass(var dateProperty: LocalDateTime)

fun LocalDateTime.leapYearCheck() = this.dayOfMonth == 28
fun LocalDateTime.validDateCheck() = this.month

fun thirdProblem() {
    var date = DateClass(LocalDateTime.now()).dateProperty
    println("The current date: ${date}\n")
    println("Is a leap year this year? ---> ${date.leapYearCheck()}")

}

fun main(){

    // First problem call:
    // firstProblem()

    // Second problem call:
    //secondProblem()

    // Third problem call:
    // Its under construction :)))
    //thirdProblem()
}


