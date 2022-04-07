package com.example.kotlininaction.chapter03

fun main() {
    val list = listOf<Int>(1, 2, 3)
    joinToString(list, ", ", "!", "!")
}