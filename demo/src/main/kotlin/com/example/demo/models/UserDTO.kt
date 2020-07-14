package com.example.demo.models

import lombok.Getter
import lombok.Setter


@Getter
@Setter
class UserDTO {

    val no: Int
    var name: String
    var age: Int
    var sex: String

    constructor(no: Int, name: String, age: Int, sex: String) {
        this.no = no
        this.name = name
        this.age = age
        this.sex = sex
    }

    fun setUser(userVO: UserVO){
        this.name = userVO.name?:name
        this.sex = userVO.sex?:sex
        this.age = userVO.age?:age
    }
}