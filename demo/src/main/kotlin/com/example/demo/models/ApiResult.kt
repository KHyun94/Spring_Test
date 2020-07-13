package com.example.demo.models

import com.example.demo.util.DateUtil

data class ApiResult<T>(val datetime: String = DateUtil.getCurrentDate()
                        , val data: T?, val message: String)