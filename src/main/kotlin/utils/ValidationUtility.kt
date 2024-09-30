package utils
import java.util.regex.Pattern

/**
* Validate the gender input
*/
val genderList = listOf('F', 'M', 'O')
fun isValidGender(genderToValidate: Char) = genderToValidate in genderList

fun isValidInRange(valueToCheck: Double, minValue: Double, maxValue: Double): Boolean{
    return (valueToCheck >= minValue) && (valueToCheck <= maxValue)
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
    return Pattern.matches(emailRegex, email)
}