package com.example.demo.repositories

import com.example.demo.models.User


interface UserRepo {
    fun getName():String
    fun setName(name:String)
    fun getAge():Int
    fun setAge(age:Int)
    fun getSex():String
    fun setSex(set:String)
    fun getUser():User
    fun setUser(u:User)
}