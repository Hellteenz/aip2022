@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import lesson3.task1.isPrime
import kotlin.math.sqrt
import kotlin.math.pow

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.lowercase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    if (v.isNotEmpty()) {
        var s = 0.0
        for (e in v) {
            s += e * e
        }
        return sqrt(s)
    } else return 0.0
}

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if (list.isNotEmpty()) {
        var s = 0.0
        for (e in list) {
            s += e
        }
        return s / list.size
    } else return 0.0
}

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    if (list.isNotEmpty()) {
        var s = 0.0
        for (e in list) {
            s += e
        }
        s /= list.size
        for (i in 0 until list.size) {
            list[i] -= s
        }
        return list
    } else return list
}

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    if (a.isNotEmpty() && b.isNotEmpty()) {
        var c = 0
        for (i in a.indices) {
            c += a[i] * b[i]
        }
        return c
    } else return 0
}

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {
    if (p.isNotEmpty()) {
        var px = 0.0
        for (i in p.indices) {
            px += p[i] * x.toDouble().pow(i)
        }
        return px.toInt()
    } else return 0
}

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    if (list.size > 0) {
        var sum = list[0]
        var a = 0
        for (i in 1 until list.size) {
            a = sum
            sum += list[i]
            list[i] += a
        }
        return list
    } else return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val listOfDiffSis = mutableListOf<Int>()
    var x = n
    if (x == 0) listOfDiffSis += 0
    while (x > 0) {
        listOfDiffSis += x % base
        x /= base
    }
    return listOfDiffSis.reversed()
}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String {
    var strOfDiffSis = ""
    var x = n
    val num = "1234567890"
    val alph = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
    if (x == 0) strOfDiffSis += "0"
    while (x > 0) {
        if (x % base < 10) strOfDiffSis += (x % base).toString()
        else strOfDiffSis += alph[x % base - 10]
        x /= base
    }
    return strOfDiffSis.reversed()
}

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var x = 0
    for (i in digits.indices) {
        x += digits[i] * base.toDouble().pow(digits.size - i - 1).toInt()
    }
    return x
}

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int {
    var x = 0
    val alph = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
    for (i in str.indices) {
        if (str[i].isDigit()) x += str[i].toString().toInt() * base.toDouble().pow(str.length - i - 1).toInt()
        else x += (alph.indexOf(str[i].toString()) + 10) * base.toDouble().pow(str.length - i - 1).toInt()
    }
    return x
}


/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun thusRussian(ns: String, singlediff: List<String>, thus: List<String>, hund: List<String>, dozens: List<String>, single: List<String>): String{
    if (ns[0].toInt() == 1) return singlediff[0] + " " + thus[0] + " " + hund[(ns[1]).toInt()] + " " + dozens[(ns[2]).toInt()] + " " + single[(ns[3]).toInt()]
    if (ns[0].toInt() == 2) return singlediff[1] + " " + thus[1] + " " + hund[(ns[1]).toInt()] + " " + dozens[(ns[2]).toInt()] + " " + single[(ns[3]).toInt()]
    if (ns[0].toInt() in 3..4) return singlediff[ns[0].toInt()] + " " + thus[1] + " " + hund[(ns[1]).toInt()] + " " + dozens[(ns[2]).toInt()] + " " + single[(ns[3]).toInt()]
    if (ns[0].toInt() in 5..9) return singlediff[ns[0].toInt()] + " " + thus[2] + " " + hund[(ns[1]).toInt()] + " " + dozens[(ns[2]).toInt()] + " " + single[(ns[3]).toInt()]
    else return "0"
}
fun tenThusRus(ns: String, singlediff: List<String>, thus: List<String>, hund: List<String>, dozens: List<String>, single: List<String>, teens: List<String>): String {
    return if (ns[0].toInt() == 1) teens[ns[1].toInt()] + " " + thusRussian((ns.toInt() % 1000).toString(), singlediff, thus, hund, dozens, single)
    else dozens[(ns[0]).toInt()] + " " + thusRussian((ns.toInt() % 1000).toString(), singlediff, thus, hund, dozens, single)
}
fun russian(n: Int): String {
    val hund = listOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    val single = listOf("ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    val singlediff = listOf("одна", "две")
    val teens = listOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семьнадцать", "восемьнадцать", "девятнадцать")
    val dozens = listOf("", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
    val thus = listOf("тысяча", "тысячи", "тысяч")
    val ns = n.toString()
    if (ns.length == 1) return single[n]
    if (ns.length == 2) {
        return if (ns[0].toInt() == 1) teens[(ns[1]).toInt()]
        else dozens[(ns[0]).toInt()] + " " + single[(ns[1]).toInt()]
    }
    if (ns.length == 3) {
        return if (ns[1].toInt() == 1) hund[(ns[0]).toInt()] + " " + teens[(ns[2]).toInt()]
        else hund[(ns[0]).toInt()] + " " + dozens[(ns[1]).toInt()] + " " + single[(ns[2]).toInt()]
    }
    if (ns.length == 4) return thusRussian(ns, singlediff, thus, hund, dozens, single)
    if (ns.length == 5) return tenThusRus(ns, singlediff, thus, hund, dozens, single, teens)
    if (ns.length == 6) return hund[(ns[0]).toInt()] + " " + tenThusRus((ns.toInt() % 10000).toString(), singlediff, thus, hund, dozens, single, teens)
    else return "Error"
}