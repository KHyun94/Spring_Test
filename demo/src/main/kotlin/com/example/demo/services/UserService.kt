package com.example.demo.services

import com.example.demo.UserData
import com.example.demo.models.ApiResult
import com.example.demo.models.User
import org.springframework.stereotype.Service

@Service
class UserService() {

    fun createUser(name: String, age: Int, sex: String): ApiResult<Boolean> {

        val no = UserData.userList.size + 1
        println("Service fun createUser new no => $no")

        val isCreate = UserData.userList.add(User(no, name, age, sex))

        return if (isCreate) {
            ApiResult(data = isCreate, message = "Success Create User")
        } else {
            ApiResult(data = isCreate, message = "Fail Create User")
        }
    }

    fun searchUser(no: Int): ApiResult<User?> {

        println("Service fun searchUser no => $no")

        var user: User? = null

        for (i in UserData.userList) {
            if (i.no == no) {
                println("Cor Match $i")
                user = i
                break
            }
        }

        return if (user != null) {
            ApiResult(data = user, message = "Success Search User")
        } else {
            ApiResult(data = null, message = "Fail Search User")
        }
    }

    fun updateUser(no: Int, name: String?, age: Int?, sex: String?): ApiResult<Boolean> {

        var target = searchUser(no).data

        return if (target == null) {
            ApiResult(data = false, message = "Fail Don't search user")
        } else {
            target.name = name ?: target.name
            target.age = age ?: target.age
            target.sex = sex ?: target.sex

            UserData.userList[no] = target

            ApiResult(data = true, message = "Success Update User")
        }
    }


    fun deleteUser(no: Int): ApiResult<Boolean> {
        val target = searchUser(no).data

        return if (target == null) {
            ApiResult(data = false, message = "Fail Don't search user")
        } else {
            val isDelete = UserData.userList.remove(target)

            when {
                isDelete -> ApiResult(data = true, message = "Success Delete User")
                else -> ApiResult(data = false, message = "Fail Delete User")
            }
        }
    }

    fun searchAllUser(): ApiResult<List<User>?> {

        val size  = UserData.userList.size

        return if(size == 0)
            ApiResult(data = null, message = "Fail Search All User")
        else
            ApiResult(data = UserData.userList, message = "Success Search All User")
    }


}