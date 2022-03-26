package com.example.kotlininaction.chapter02

fun main(args: Array<String>) {

    /**
     * 함수
     */
    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b // 블록이 본문
    }

    fun max2(a: Int, b: Int): Int = if (a > b) a else b // 식이 본문
    fun max3(a: Int, b: Int) = if (a > b) a else b  // 식이 본문이면 리턴 타입 생략 가능(타입추론)

    /**
     * 변수
     */
    // 함수는 fun으로 정의하며 블럭문이 아닌 식으로도 정의 가능
    fun hello() = println("Hello")
    // val은 java final과 동일하게 재할당이 불가능
    val name1: String = "Dexter"
    // var은 재할당 가능, 타입은 고정
    var name2: String = "Dexter"

}

class Main {

}