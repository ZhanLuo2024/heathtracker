package utils
import models.Gender
import user

/**
 * To verify user input
 *
 */
class ValidationUtility {
    // verify user name
    fun verifyUsername(username: String) {
        if (!username.isBlank()) {
            user.name = username
        } else {
            throw RuntimeException("Name cannot be blank")
        }
    }

    /**
     * To verify user email
     *
     * */
    fun verifyemail(useremail: String) {
        val regex = Regex("[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
        val matches = regex.find(useremail)
        if (matches != null) {
            user.email = useremail
        } else {
            throw RuntimeException("Please enter a correct email address")
        }
    }

    /**
     * To verify user gender
     *
     * */
    fun verifyGender(gender: String) {
        if (gender == "Male" || gender == "male") {
            user.gender = Gender.MALE
        } else if (gender == "FeMale" || gender == "female") {
            user.gender = Gender.FEMALE
        } else {
            user.gender = Gender.OTHER
        }
    }



}