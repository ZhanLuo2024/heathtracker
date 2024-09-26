package models


enum class Gender(i: Int) {
    FEMALE(0),
    MALE(1),
    OTHER(99);
}

data class User (
    var id: Int = -1,
    var name: String = "no name yet",
    var email: String = "no email yet",
    var weight: Double = 0.0,
    var height: Double = 0.0,
    var gender: Gender = Gender.OTHER
)


