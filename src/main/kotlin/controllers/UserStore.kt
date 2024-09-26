package controllers

import models.User

class UserStore {

    val users = ArrayList<User>()

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
        users.add(user)
    }
}