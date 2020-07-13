package com.example.demo.util

import java.text.SimpleDateFormat
import java.util.*


object DateUtil {
     fun getCurrentDate():String{
        val format1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        val time = Date()

        return format1.format(time)
    }
}