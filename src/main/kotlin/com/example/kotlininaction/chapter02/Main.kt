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

    /**
     * 클래스
     */
    class Person(
            // val은 읽기 전용으로 비공개 필드와 getter 제공
            val name: String,
            // var은 변경 가능하므로 비공개 필드와 getter, setter 제공
            var isMarried: Boolean
    )

    var p = Person("yuncheol", false)
    println(p.name)
    println(p.isMarried)
    p.isMarried = true;

    /**
     * 커스텀 접근자
     */
    class Rectangle(val height: Int, val width: Int) {
        val isSquare: Boolean
            get() {
                return height == width
            }
        val size: Int
            get() = height * width
    }

}

class Main {

}