package com.example.demo


typealias User = com.example.demo.models.User

object UserData {
    var userList = mutableListOf<User>(
            User(1, "테스트1", 19, "M"),
            User(2, "테스트2", 21, "F"),
            User(3, "테스트3", 25, "M"),
            User(4, "테스트4", 30, "M"),
            User(5, "테스트5", 18, "M"),
            User(6, "테스트6", 35, "F"),
            User(7, "테스트7", 25, "M"),
            User(8, "테스트8", 30, "M")
    )
}