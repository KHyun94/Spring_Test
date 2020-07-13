package com.example.demo.controllers

import com.example.demo.UserData
import com.example.demo.models.User
import com.example.demo.services.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
class UserController() {

    val userService = UserService()

    @PostMapping("/createUser")
    fun createUser(@RequestParam name: String,
                   @RequestParam age: Int,
                   @RequestParam sex: String): Boolean {

        println("Controller API:/createUser RequestParam name => $name")
        println("Controller API:/createUser RequestParam age => $age")
        println("Controller API:/createUser RequestParam sex => $sex")

        return userService.createUser(name, age, sex)
    }

    @GetMapping("/searchUser")
    fun searchUser(@RequestParam no: Int): User? {
        println("Controller API:/searchUser RequestParam no => $no")
        return userService.searchUser(no = no)
    }

    @PutMapping("/updateUser")
    fun updateUser(@RequestParam no: Int,
                   @RequestParam name: String?,
                   @RequestParam age: Int?,
                   @RequestParam sex: String?) :Boolean {

        println("Controller API:/updateUser RequestParam name => $name")
        println("Controller API:/updateUser RequestParam age => $age")
        println("Controller API:/updateUser RequestParam sex => $sex")

        return userService.updateUser(no, name, age, sex)
    }

    @DeleteMapping("/deleteUser")
    fun deleteUser(@RequestParam no: Int): Boolean {
        println("Controller API:/deleteUser RequestParam no => $no")
        return userService.deleteUser(no)
    }

    @GetMapping("/findAll")
    fun findAllUser(): List<User> {
        println("Controller API:/findAll")
        return userService.findAll()
    }

}