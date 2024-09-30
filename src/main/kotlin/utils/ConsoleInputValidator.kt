package utils

fun readValidEmail(prompt: String): String {
    var email = ""
    do {
        print(prompt)
        email = readln()
        when {
            isValidEmail(email) -> return email
            else -> println ("       Invalid Email format.  Try again.")
        }
    }while (true)
}

fun readValidDouble(prompt: String, min: Double, max: Double): Double {
    var value: Double
    do {
        print(prompt)
        value = readlnOrNull()?.toDoubleOrNull() ?: 0.0
        when {
            isValidInRange(value, min, max) -> return value
            else -> println ("       Outside range ($min to $max).  Try again.")
        }
    }while (true)
}

fun readValidGender(prompt: String): Char {
    var gender = ' '
    do {
        print(prompt)
        gender = readln().uppercase().getOrNull(0) ?: ' '
        when {
            isValidGender(gender) -> return gender
            gender == ' ' -> return gender
            else -> println ("       Invalid Value.  Valid values are ${genderList}. Try again.")
        }
    }while (true)
}