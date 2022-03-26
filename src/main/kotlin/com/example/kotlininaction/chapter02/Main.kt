package com.example.kotlininaction.chapter02

fun main(args: Array<String>) {

    // 함수
    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b // 블록이 본문
    }

    fun max2(a: Int, b: Int): Int = if (a > b) a else b // 식이 본문
    fun max3(a: Int, b: Int) = if (a > b) a else b  // 식이 본문이면 리턴 타입 생략 가능(타입추론)
}

class Main {

}