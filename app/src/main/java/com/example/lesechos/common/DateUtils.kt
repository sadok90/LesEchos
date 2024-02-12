package com.example.lesechos.common

import java.text.SimpleDateFormat
import java.util.Date

object DateUtils {
    @JvmStatic
    fun toSimpleString(date: Date): String {
        val format = SimpleDateFormat("dd/MM/yyy")
        return format.format(date)
    }
}