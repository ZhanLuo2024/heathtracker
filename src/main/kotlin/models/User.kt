package models

import javax.print.attribute.standard.MediaSize


enum class Gender{
    FEMALE, MALE, OTHERS
}

data class User (
    var id: Int = -1,
    var name: String = "no name yet",
    var email: String = "no email yet",
    var weight: Double = 0.0,
    var height: Double = 0.0,
    var gender: Gender = Gender.OTHERS
)


