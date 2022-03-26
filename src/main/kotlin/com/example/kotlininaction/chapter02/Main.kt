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

    /**
     * 문자열 템플릿
     */
    var name = "ok"
    println("Hello, $name!")    // 뒤에 변수 사용
    println("Hello, ${name}입니다.")   // $ 뒤에 중괄호 사용
    println("\$name의 값 = $name")    // $ 자체는 \$ 탈출문자 사용
    println("max(1, 2) = ${max(1, 2)}") // 중괄호 안에서 식 사용
    println("args: ${if (args.isEmpty()) "empty" else args[0]}") // 식에서 큰 따옴표 사용

}

class Main {

}