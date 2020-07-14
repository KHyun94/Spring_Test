package com.example.demo.services

import com.example.demo.UserData
import com.example.demo.models.ApiResult
import com.example.demo.models.UserDTO
import com.example.demo.models.UserVO
import org.springframework.stereotype.Service
import java.net.http.HttpRequest

@Service
class UserService() {

    fun createUser(user:UserVO): ApiResult<Boolean> {

        val no = UserData.userList.size + 1
        println("Service fun createUser new no => $no")

        val isCreate = UserData.userList.add(UserDTO(no, user.name!!, user.age!!, user.sex!!))

        return if (isCreate) {
            ApiResult(data = isCreate, message = "Success Create User")
        } else {
            ApiResult(data = isCreate, message = "Fail Create User")
        }
    }

    fun searchUser(no: Int): ApiResult<UserDTO?> {

        println("Service fun searchUser no => $no")

        var userDTO: UserDTO? = null

        for (i in UserData.userList) {
            if (i.no == no) {
                println("Cor Match $i")
                userDTO = i
                break
            }
        }

        return when {
            userDTO != null -> ApiResult(data = userDTO, message = "Success Search User")
            else -> ApiResult(data = null, message = "Fail Search User")
        }
    }

    fun updateUser(no: Int, userVO: UserVO): ApiResult<Boolean> {

        var target = searchUser(no).data

        return if (target == null) {
            ApiResult(data = false, message = "Fail Don't search user")
        } else {
            target.setUser(userVO = userVO)

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

    fun searchAllUser(): ApiResult<List<UserDTO>?> {

        val size  = UserData.userList.size

        return if(size == 0)
            ApiResult(data = null, message = "Fail Search All User")
        else
            ApiResult(data = UserData.userList, message = "Success Search All User")
    }


}