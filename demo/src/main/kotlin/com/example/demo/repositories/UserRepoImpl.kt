package com.example.demo.repositories

import com.example.demo.models.UserDTO

class UserRepoImpl(private val u: UserDTO) : UserRepo {

    private var user: UserDTO = u

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

    override fun getUser(): UserDTO {
        TODO("Not yet implemented")
    }

    override fun setUser(u: UserDTO) {

    }
}