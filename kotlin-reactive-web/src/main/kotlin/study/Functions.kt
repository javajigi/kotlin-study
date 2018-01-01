package study

fun String.lastChar(): Char = get(length - 1)

fun <T> Collection<T>.joinString(
        separator: String = ", ",
        prefix: String = "",
        suffix: String = ""
): String {
    val result = StringBuilder(prefix)

    for((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(suffix)
    return result.toString()
}

fun Collection<String>.join(
        separator: String = ", ",
        prefix: String = "",
        suffix: String = ""
) = joinString(separator, prefix, suffix)