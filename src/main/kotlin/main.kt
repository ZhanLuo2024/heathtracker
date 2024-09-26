import models.User
import utils.ValidationUtility

var user = User()
var verifyTool = ValidationUtility()



fun main() {
    print("welcome to Health Tracker")

    runApp()
}

fun addUser() {
    println("Please enter the following for the user:")
    print("    Name: ")
    var tempString = ""
    tempString = readLine()!!
    // verify user name
    verifyTool.verifyUsername(tempString)

    print("    Email: ")
    tempString = readLine()!!
    // verify email
    verifyTool.verifyemail(tempString)

    print("    Gender: Female,male,other")
    tempString = readLine()!!
    // verify gender
    verifyTool.verifyGender(tempString)

    print("    Id: ")
    user.id = readLine()?.toInt() ?: -1

    print(" weight: ")
    user.id = readLine()?.toInt() ?: -1


}

fun listUsers() {
    print("The user details are:$user")
}

fun menu(): Int {
    println("\nMain Menu:")
    println("1. Add User")
    println("2. List Users")
    println("0. Exit")
    print("""
        |Main Menu:
        |   1. Add User
        |   2. List Users
        |   0. Exit
        |Please enter your option: """.trimIndent())

    return readlnOrNull()?.toIntOrNull() ?: -1
}

fun runApp() {
    var input: Int

    do {
        input = menu()

        when (input) {
            1 -> addUser()
            2 -> listUsers()
            in (3..6) -> println("Feature coming soon")
            0 -> println("Invalid option")

        }
    } while (input != 0)
}