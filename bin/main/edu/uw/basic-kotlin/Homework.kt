package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(word: Any?): String {
    if (word is String) {
        if (word == "Hello") {
            return "world"
        } else {
            return "Say what?"
        }
    } else if (word is Int) {
        if (word == 0) {
            return "zero"
        } else if (word == 1) {
            return "one"
        } else if(word in 2..10) {
            return "low number"
        } else {
            return "a number"
        }
    } else {
        return "I don't understand"
    }
}
// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(int1: Int, int2: Int): Int {
    return int1 + int2
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(int1: Int, int2: Int): Int {
    return int1 - int2
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(int1: Int, int2: Int, operation: (Int, Int) -> Int): Int {
    return operation(int1, int2)
}

// write a class "Person" with first name, last name and age

class Person(var firstName: String, var lastName: String, var age: Int) {
    val debugString = "[Person firstName:" + firstName + " lastName:" + lastName + " age:" + age +"]"
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
//
//class Money(var amount: Int, var currency: String) {
//    init {
//        require(amount > 0)
//        require(currency in setOf("USD", "EUR", "CAN", "GBP")) { "Invalid currency" }
//    }
//    fun convert(targetCurrency: String): Money {
//        if (targetCurrency == currency) {
//            return Money(amount, currency)
//        }
//
//        val convertedAmount = when (currency to targetCurrency) {
//            "USD" to "GBP" -> amount / 2
//            "USD" to "EUR" -> amount * 1.5
//            "USD" to "CAN" -> (amount * 5) / 4
//            "GBP" to "USD" -> amount * 2
//            "GBP" to "EUR" -> amount * 3
//            "GBP" to "CAN" -> (amount * 5) / 2
//            "EUR" to "USD" -> (amount * 2) / 3
//            "EUR" to "GBP" -> amount / 3
//            "EUR" to "CAN" -> (amount * 5) / 6
//            "CAN" to "USD" -> (amount * 4) / 5
//            "CAN" to "EUR" -> (amount * 6) / 5
//            "CAN" to "GBP" -> (amount * 2) / 5
//            else -> throw IllegalArgumentException("Unsupported conversion")
//        }
//
//        return Money(convertedAmount, targetCurrency)
//    }
//
//    operator fun plus(other: Money): Money {
//        val otherConverted = other.convert(this.currency)
//        return Money(this.amount + otherConverted.amount, this.currency)
//    }
//}

class Money(var amount: Int, var currency: String) {
    init {
        require(amount >= 0) { "Amount cannot be less than 0" }
        require(currency in setOf("USD", "EUR", "CAN", "GBP")) { "Invalid currency" }
    }

    fun convert(targetCurrency: String): Money {
        if (targetCurrency == currency) {
            return Money(amount, currency)
        }

        val convertedAmount: Int = when (currency to targetCurrency) {
            "USD" to "GBP" -> amount / 2
            "USD" to "EUR" -> (amount * 1.5).toInt()
            "USD" to "CAN" -> (amount * 5) / 4
            "GBP" to "USD" -> amount * 2
            "GBP" to "EUR" -> amount * 3
            "GBP" to "CAN" -> (amount * 5) / 2
            "EUR" to "USD" -> (amount * 2) / 3
            "EUR" to "GBP" -> amount / 3
            "EUR" to "CAN" -> (amount * 5) / 6
            "CAN" to "USD" -> (amount * 4) / 5
            "CAN" to "EUR" -> (amount * 6) / 5
            "CAN" to "GBP" -> (amount * 2) / 5
            else -> throw IllegalArgumentException("Unsupported conversion")
        }

        return Money(convertedAmount, targetCurrency)
    }

    operator fun plus(other: Money): Money {
        val otherConverted = other.convert(this.currency)
        return Money(this.amount + otherConverted.amount, this.currency)
    }
}