package com.example.kotlininaction.chapter03

fun main() {

    val list = listOf(1, 2, 3)
    println(list)

    val joinToString = joinToString(list, "!", "[", "]")
    println(joinToString)
}

fun <T> joinToString(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "[",
        postfix: String = "]"
): String {
    val result = StringBuffer(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


