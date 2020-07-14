package com.example.demo.controllers

import com.example.demo.models.ApiResult
import com.example.demo.models.UserDTO
import com.example.demo.models.UserVO
import com.example.demo.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class UserController() {

    val userService = UserService()

    // 데이터 등록(생성)
    @PostMapping("", consumes= ["application/json"],headers = ["content-type=application/x-www-form-urlencoded"])
    fun enrollUser(userVO: UserVO): ApiResult<Boolean> {

        println("Controller API:/createUser RequestParam name => $userVO")

        return userService.createUser(user = userVO)
    }

    // 전체 유저 조회
    @GetMapping("")
    fun searchAllUser(): ApiResult<List<UserDTO>?> {
        println("Controller API:/findAll")
        return userService.searchAllUser()
    }

    // 특정 유저 조회
    @GetMapping("/{no}")
    fun searchUser(@PathVariable("no") no: Int): ApiResult<UserDTO?> {
        println("Controller API:/searchUser RequestParam no => $no")
        return userService.searchUser(no)
    }

    // 유저 업데이트
    @PutMapping("{no}")
    fun updateUser(@PathVariable no: Int,
                   userVO: UserVO) :ApiResult<Boolean> {

        println("Controller API:/updateUser RequestParam name => $userVO")

        return userService.updateUser(no = no, userVO = userVO)
    }

    // 유저 삭제
    @DeleteMapping("/{no}")
    fun deleteUser(@PathVariable("no") no: Int): ApiResult<Boolean> {
        println("Controller API:/deleteUser RequestParam no => $no")
        return userService.deleteUser(no)
    }



}