package com.example.kotlininaction.chapter03

fun Collection<String>.joinToString(
        separator: String = ", ",
        prefix: String = "[",
        postfix: String = "]"
): String {
    val result = StringBuffer(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


