package com.example.kotlininaction.chapter03

import com.example.kotlininaction.chapter03.strings.lastChar

fun main() {
    val list = listOf<Int>(1, 2, 3)
    val joinToString = joinToString(list, ", ", "!", "!")
    println("list = ${list}")

    var c = "Kotlin".lastChar()
    println("c = ${c}")

}