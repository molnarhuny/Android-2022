import java.util.*
import java.util.function.Predicate
import kotlin.math.absoluteValue

fun isPrimeNumber(number: Int) : Boolean{
    for(i in 2..number/2) {
        if (number % i == 0)
            return false;
    }
    return true;
}

fun daysOfWeekExercise() {
    val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    val iterator = daysOfWeek.iterator();

    println("The list of daysOfWeek:");
    iterator.forEach {
        print("$it ");
    }

    print("\n\n")

    println("Elements, which starts with 'T':");
    daysOfWeek
        .filter { it.startsWith("T") }
        .forEach { print("$it ") }

    print("\n\n")

    println("Elements, which contains the letter 'e':");
    daysOfWeek
        .filter { it.contains("e") }
        .forEach { print("$it ") }

    print("\n\n")

    println("Elements, which has exactly the lenght of 6:");
    daysOfWeek
        .filter { it.length.equals(6) }
        .forEach { print("$it ") }

    print("\n\n")
}

fun testingStringTemplate() {
    val first = 2;
    val second = 3;
    println("$first + $second = ${first+second}\n");
}

fun encodeAndDecode(secretString: String) {
    //encode the String
    val encoder: Base64.Encoder = Base64.getEncoder();
    val encoded : String = encoder.encodeToString(secretString.toByteArray());
    println("The result of encoding is: $encoded");

    // decode the Encoded String
    val decoder: Base64.Decoder = Base64.getDecoder();
    val decoded = String(decoder.decode(encoded))
    print("This was the original string after decoding: $decoded");
}

fun evenNumberInList(x: List<Int>) = x.filter { it%2 == 0 }.forEach { print("$it ") };

fun mapSpecificTasks() {
    val listOfNumbers = arrayListOf(1, 2, 3, 4, 5)
    println("Double every element of a list:")
    print(listOfNumbers.map{ it * it })

    print("\n\n")

    val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    println("Capitalize every day of the week:")
    print(daysOfWeek.map { it.uppercase() } )

    print("\n\n")

    println("Print the first character of each day:")
    print(daysOfWeek.map { it.uppercase().first() } )

    print("\n\n")

    println("Number of characters of each day in week:")
    print(daysOfWeek.map { it.length })

    print("\n\n")

    println("Average days in a week:")
    print(daysOfWeek
        .map { it.length }
        .average()
    )
}

fun <T> remove(list: MutableList<T>, predicate: Predicate<T>) {
    list.removeIf { x: T -> predicate.test(x) }
}

fun mutableListTasks() {
    var daysOfWeek = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    var daysWithN = Predicate { day : String -> day.contains("n") }
    remove(daysOfWeek, daysWithN)

    print("Elements of the list, without the letter 'n':\n $daysOfWeek")

    print("\n\n")

    println("Days of week converted with index:")
    val convertedDaysOfWeek = daysOfWeek.withIndex();
    for((index, value) in convertedDaysOfWeek) {
        println("Item at $index is $value")
    }

    print("\n")

    daysOfWeek.sort();
    print("Days of week sorted alphabetically: \n$daysOfWeek")
}

fun arrayTasks() {
    println("Random array printed every element in newline:")
    val randomArray = (1..10).map{Random().nextInt(100 )}
    randomArray
        .forEach{ println("$it ") }

    print("\n")

    println("Random array sorted:")
    print(randomArray.sortedBy { it.absoluteValue })

    print("\n\n")

    println("Even numbers in the sorted array:")

    var anyEvenNumber = false;
    var amountOfEvenNumbers = 0;
    randomArray
        .map { it.absoluteValue }
        .filter { it%2==0 }
        .forEach { print("$it ");
                   anyEvenNumber=true;
                   amountOfEvenNumbers++; }

    print("\n")
    if (anyEvenNumber)
        print("Check complete: there are even numbers in the random list.")
    else
        print("Check complete: there aren't any even numbers in the list.")

    print("\n\n")

    if ((amountOfEvenNumbers as Int)==randomArray.size)
        print("All numbers are even.")
    else
        print("Not every generated numbers are even.")

    print("\n\n")

    print("The average of generated numbers: ${amountOfEvenNumbers/randomArray.size.toFloat()}")
}

fun main(args: Array<String>) {

    // 1. Exercise
    testingStringTemplate();

    // 2. Exercise
    daysOfWeekExercise();

    // 3. Exercise
    val numberToCheck = 99
    if (isPrimeNumber(numberToCheck))
        print("$numberToCheck is prime.");
    else
        print("$numberToCheck is not prime.")

    print("\n\n")

    // 4. Exercise
    encodeAndDecode("Badumts.");

    print("\n\n")

    // 5. Exercise
    val numberList = arrayListOf(1,2,3,4,5,6,7,8,9);
    println("Even numbers from the list:")
    evenNumberInList(numberList);

    print("\n\n")

    // 6. Exercise
    mapSpecificTasks()

    print("\n\n")

    // 7. Exercise
    mutableListTasks()

    print("\n\n")

    // 8. Exercise
    arrayTasks()
}
