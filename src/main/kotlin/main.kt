import models.User
import utils.readValidGender
import utils.readValidEmail
import utils.readValidDouble
import controllers.UserStore
import io.github.oshai.kotlinlogging.KotlinLogging
import jdk.incubator.vector.VectorOperators.Conversion
import java.lang.System.exit


//var user = User()
val userStore = UserStore()

// logger
private val logger = KotlinLogging.logger {}


fun main() {
    logger.info{"Welcome to Health Tracker"}

    //Some Temporary Test Data
    userStore.createUser(User(1, "Homer Simpson", "homer@simpson.com", 178.0, 2.0, 'M'))
    userStore.createUser((User(2, "Marge Simpson", "marge@simpson.com", 140.0, 1.6, 'F')))
    userStore.createUser((User(3, "Lisa Simpson", "lisa@simpson.com", 100.0, 1.2, 'F')))
    userStore.createUser((User(4, "Bart Simpson", "bart@simpson.com", 80.0, 1.0, 'M')))
    userStore.createUser((User(5, "Maggie Simpson", "maggie@simpson.com", 50.0, 0.7, 'F')))

    runApp()
}

private fun addUser() {
    userStore.createUser(getUserDetails())
}

private fun listUsers() {
    println("The user details are:")
    userStore.findAll()
        .sortedBy { it.name }
        .forEach{println(it)}
}

private fun menu(): Int {
    println("\nMain Menu:")
    println("1. Add User")
    println("2. List Users")
    println("0. Exit")
    print("""
        |Main Menu:
        |   1. Add User
        |   2. List Users
        |   3. search User by Id
        |   4. delete User
        |   5. update User
        |   6. search User by Gender
        |   0. Exit
        |Please enter your option: """.trimIndent())

    return readlnOrNull()?.toIntOrNull() ?: -1
}

private fun runApp() {
    var input: Int

    do {
        input = menu()

        when (input) {
            1 -> addUser()
            2 -> listUsers()
            3 -> searchById()
            4 -> deleteUser()
            5 -> updateUser()
            6 -> searchByGender()
            in (7..10) -> println("Feature coming soon")
            0 -> println("Invalid option")

        }
    } while (input != 0)
}


private fun getUserById(): User? {
    print("Enter the id of the user: ")
    return  userStore.findUserById(readlnOrNull()?.toIntOrNull() ?: -1)
}

private fun getUserByGender(): List<User> {
    print("Enter the id of the user: ")
    return  userStore.findUserByGender(readln().uppercase().getOrNull(0) ?: ' ')
}


private fun searchById() {
    val user = getUserById()
    if (user == null)
        logger.info{"Search - no user found"}
    else
        println(user)
}

private fun searchByGender() {
    val matchUsers = getUserByGender()
    if (matchUsers.isEmpty())
        logger.info{"Search - no user found"}
    else
        println(matchUsers.forEach{println(it)})
}

private fun usersReport() {

    val users = userStore.findAll()

    println("""
        |------------------------
        |     USERS REPORT
        |------------------------
        |
        |  Number of Users:  ${users.size}
        |  Gender Breakdown: ${users.groupingBy{it.gender}.eachCount()}
        |  Average Weight:   ${users.sumOf { it.weight }.div(users.size)} kg
        |  Min Weight:       ${users.minByOrNull { it.weight }?.weight} kg
        |  Max Weight:       ${users.maxByOrNull { it.weight }?.weight} kg

        |  Min Height:       ${users.minByOrNull { it.height }?.height} metres
        |  Max Height:       ${users.maxByOrNull { it.height }?.height} metres
        |
        |------------------------
        |""".trimMargin())
}

private fun deleteUser(){
    if (userStore.delete(getUserById()))
        println ("User deleted")
    else
        println ("No user")
}

private fun getUserDetails() : User{
    println("Please enter the following for the user:")

    val user = User()
    userStore.createUser(user)

//    print("    Id: ")
//    user.id = readlnOrNull()?.toIntOrNull() ?: -1
    print("    Name: ")
    user.name = readln()

    user.email = readValidEmail("    Email: ")
    user.weight = readValidDouble("    Weight: ", 40.0, 600.0)
    user.height = readValidDouble("    Height: ", 100.0, 300.0)
    user.gender = readValidGender("    Gender: ")

    return user
}

private fun updateUser() {
    listUsers()
    val foundUser = getUserById()

    if(foundUser != null) {
        //read in user data
        val user = getUserDetails()
        user.id = foundUser.id
        //using the id from foundUser and the details read from the console, update the user.
        if (userStore.update(user))
            println("User updated")
        else
            println("User not updated")
    }
    else
        println("User not found")
}