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

    /**
     * enum
     */
    // 자바의 switch와 유사, when은 식
    fun getWarmth(color: Color) =
            when (color) {
                Color.RED -> "warm"
                Color.ORANGE -> "warm"
                Color.YELLOW -> "warm"
                Color.BLUE -> "cold"
                Color.VIOLET -> "cold"
                Color.GREEN -> "warm"
            }

    // 2. 여러 매치 패턴을 지정할 수 있음
    fun getWarmth2(color: Color) =
            when (color) {
                Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN -> "warm"
                Color.BLUE, Color.VIOLET -> "cold"
            }

    // 3. 모든 분기 식에 만족하지 않으면 else 
    fun getWarmth3(color: Color) =
            when (color) {
                Color.RED -> "very warm"
                Color.ORANGE, Color.YELLOW -> "warm"
                else -> "cold"
            }

    // 4. when 식은 동등성
    fun mix(c1: Color, c2: Color) =
            when (setOf(c1, c2)) {
                setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
                setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
                else -> throw Exception("Drity color")
            }

    // 5. When에 인자가 없으려면, 각 분기의 조건에 불리언 결과를 계산하는 식이어야함.
    fun mimOpt(c1: Color, c2: Color) =
            when {
                c1 == Color.RED && c2 == Color.YELLOW -> Color.ORANGE
                c1 == Color.YELLOW && c2 == Color.RED -> Color.ORANGE
                c1 == Color.YELLOW && c2 == Color.BLUE -> Color.GREEN
                else -> throw Exception("Drity color")
            }

    /**
     * 스마트 케스팅
     */
    class Num(var value: Int) : Expr
    class Sum(val left: Expr, val right: Expr) : Expr

    // 스마트 캐스팅을 지원한다.
    fun eval(e: Expr): Int =
            when (e) {
                is Num -> e.value
                is Sum -> eval(e.left) + eval(e.right)
                else -> throw java.lang.IllegalArgumentException()
            }

    val eval = eval(Sum(Num(1), Num(2)))
    println(eval)

    val sum = Sum(Num(1), Num(2))

    if (sum.left is Num) {
        println(sum.left.value)
    }

    if (sum.right is Num) {
        println(sum)
    }
}

interface Expr

class Main {

}