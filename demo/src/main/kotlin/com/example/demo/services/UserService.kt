package com.example.demo.services

import com.example.demo.UserData
import com.example.demo.models.User
import org.springframework.stereotype.Service

@Service
class UserService() {

    fun createUser(name: String, age: Int, sex: String): Boolean {

        val no = UserData.userList.size + 1
        println("Service fun createUser new no => $no")

        return UserData.userList.add(User(no, name, age, sex))
    }

    fun searchUser(no: Int): User? {

        println("Service fun searchUser no => $no")

        var user: User? = null

        for (i in UserData.userList) {
            if (i.no == no) {
                println("Cor Match $i")
                user = i
                break
            }
        }

        return user
    }

    fun updateUser(no: Int, name: String?, age: Int?, sex: String?): Boolean {
        var target = searchUser(no)

        return if (target == null) {
            false
        } else {
            target.name = name ?: target.name
            target.age = age ?: target.age
            target.sex = sex ?: target.sex

            UserData.userList[no] = target

            true
        }
    }


    fun deleteUser(no: Int): Boolean {
        val target = searchUser(no)

        return if (target != null) {
            UserData.userList.remove(target)
        } else {
            false
        }
    }

    fun findAll():List<User>{
        return UserData.userList
    }


}