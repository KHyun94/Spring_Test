package com.example.demo.controllers

import com.example.demo.UserData
import com.example.demo.models.ApiResult
import com.example.demo.models.User
import com.example.demo.services.UserService
import jdk.jfr.ContentType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class UserController() {

    val userService = UserService()

    // 데이터 등록(생성)
    @PostMapping("")
    fun enrollUser(@RequestParam name: String,
                   @RequestParam age: Int,
                   @RequestParam sex: String): ApiResult<Boolean> {

        println("Controller API:/createUser RequestParam name => $name")
        println("Controller API:/createUser RequestParam age => $age")
        println("Controller API:/createUser RequestParam sex => $sex")

        return userService.createUser(name, age, sex)
    }

    // 전체 유저 조회
    @GetMapping("")
    fun searchAllUser(): ApiResult<List<User>?> {
        println("Controller API:/findAll")
        return userService.searchAllUser()
    }

    // 특정 유저 조회
    @GetMapping("/{no}")
    fun searchUser(@PathVariable("no") no: Int): ApiResult<User?> {
        println("Controller API:/searchUser RequestParam no => $no")
        return userService.searchUser(no)
    }

    // 유저 업데이트
    @PutMapping("{no}")
    fun updateUser(@PathVariable no: Int,
                   @RequestParam name: String?,
                   @RequestParam age: Int?,
                   @RequestParam sex: String?) :ApiResult<Boolean> {

        println("Controller API:/updateUser RequestParam name => $name")
        println("Controller API:/updateUser RequestParam age => $age")
        println("Controller API:/updateUser RequestParam sex => $sex")

        return userService.updateUser(no, name, age, sex)
    }

    // 유저 삭제
    @DeleteMapping("/{no}")
    fun deleteUser(@PathVariable("no") no: Int): ApiResult<Boolean> {
        println("Controller API:/deleteUser RequestParam no => $no")
        return userService.deleteUser(no)
    }



}