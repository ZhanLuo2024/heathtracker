package controllers
import models.User

class UserStore {

    private val users = ArrayList<User>()
    private var lastId = 0
    private fun getId() = lastId++

    /**
     * To find all users
     *
     * return array<User>
    */
    fun findAll(): List<User> {
        return users
    }

    /**
     *
     *  add new user
     *
     * */
    fun createUser(user: User) {
        user.id = getId()
        users.add(user)
    }

    /**
     *
     *  find user by user id
     *
     *  return user
     * */
    fun findUserById(id: Int): User? {
        return users.find { p -> p.id == id }
    }

    /**
     *
     *  find user by gender
     *
     *  list<user>
     * */
    fun findUserByGender(gender: Char?): List<User> {
        // return all match users
        return findAll().filter { u -> u.gender == gender }
    }

    /**
     *
     *  delete user
     *
     *  return Boolean
     *
     * */
    fun delete(user: User?): Boolean {
        return users.remove(user)
    }

    /**
     *
     *  update users information
     *
     *  return Boolean
     *
     * */
    fun update(user: User): Boolean {
        val foundUser = findUserById(user.id)
        if (foundUser != null) {
            foundUser.name = user.name
            foundUser.email = user.email
            foundUser.gender = user.gender
            foundUser.height = user.height
            foundUser.weight = user.weight
            return true
        }
        return false
    }

}