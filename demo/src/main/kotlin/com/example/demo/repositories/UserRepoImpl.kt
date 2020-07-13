package com.example.demo.repositories

import com.example.demo.UserData
import com.example.demo.models.User
import org.springframework.beans.factory.annotation.Autowired

class UserRepoImpl(private val u: User) : UserRepo {

    private var user: User = u

    override fun getName(): String {
        return user.name
    }

    override fun setName(name: String) {
        TODO("Not yet implemented")
    }

    override fun getAge(): Int {
        TODO("Not yet implemented")
    }

    override fun setAge(age: Int) {
        TODO("Not yet implemented")
    }

    override fun getSex(): String {
        TODO("Not yet implemented")
    }

    override fun setSex(set: String) {
        TODO("Not yet implemented")
    }

    override fun getUser(): User {
        TODO("Not yet implemented")
    }

    override fun setUser(u: User) {

    }
}