package com.example.quizapp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val question1 = Question(1,
            "What does a data class not offer?",
            "Auto-generated hashCode() and equals() methods",
            "An auto-generated toString() method",
            "Automatic conversion from/to JSON",
            "A generated copy(...) method, to create copies of instances",
            1)

        val question2 = Question(2,
            "What does this code do? --> foo()()",
            "Calls foo asynchronously",
            "Fails compilation",
            "Calls a function which is returned by the call of foo",
            "Creates a two-dimensional array",
            3)

        val question3 = Question(3,
            "What is to in the example below: 'val test = 33 to 42'",
            "A Kotlin keyword to create a Pair(33,42)",
            "A Kotlin keyword to create a Range from 33 to 42",
            "An infix extension function creating a Pair(33,42)",
            "A syntax error",
            3)

        val question4 = Question(4,
            "What is the correct way to declare a variable of integer type in Kotlin?",
            "int i = 42",
            "var i : int = 42",
            "let i = 42",
            "var i : Int = 42",
            4)

        val question5 = Question(5,
            "What does the following code print? 'val listA = mutableListOf(1, 2, 3)\n" +
                    "val listB = listA.add(4)\n" +
                    "print(listB)'",
            "true",
            "Nothing, there is a compile error",
            "Unit",
            "[1,2,3,4]",
            1)

        questionsList.add(question1)
        questionsList.add(question2)
        questionsList.add(question3)
        questionsList.add(question4)
        questionsList.add(question5)
        return questionsList
    }
}