@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.*

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var cnt = 0
    var num = n
    if (num == 0) return 1
    else while (num > 0) {
        cnt++
        num /= 10
    }
    return cnt
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int =
    if ((n == 1) || (n == 2)) 1
    else fib(n - 2) + fib(n - 1)


/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var del = 0
    for (i in 2..n){
        del = i
        if (n % i == 0) break
    }
    return del
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var del = 0
    for (i in n - 1 downTo 1){
        del = i
        if (n % i == 0) break
    }
    return del
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var xx = x
    var cnt = 0
    while (xx != 1) {
        if (x % 2 == 0) xx /= 2 else xx = xx * 3 + 1
        cnt++
    }
    return cnt
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var mul = 0
    for (k in 1..n * m) {
        mul = k
        if ((k % n == 0) && (k % m == 0)) break
    }
    return mul
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val delM = mutableListOf<Int>()
    val delN = mutableListOf<Int>()
    var answer = 0
    for (i in 1..m){
        if (m % i == 0) delM.add(i)
    }
    for (j in 1..n){
        if (n % j == 0) delN.add(j)
    }
    for (i in delM) {
        if ((i in delN) && (i != 1)) {
            answer = 0
            break
        } else answer = 1
    }
    if (answer == 1) return true else return false
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    val list = mutableListOf<Int>()
    var x = n
    while (x > 0) {
        list.add(x % 10)
        x /= 10
    }
    val len = list.size
    var res = 0
    for (i in 0..(len - 1)) {
        res += list[i] * (10.0.pow(len - 1 - i)).toInt()
    }
    return res
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    val cut = mutableListOf<Int>()
    var x = n
    while (x > 0) {
        cut.add(x % 10)
        x /= 10
    }
    val len = cut.size
    var res = 1
    for (i in 0..(len - 1) / 2) {
        if (cut[i] != cut[len - 1 - i]) {
            res = 0
            break
        }
    }
    if (res == 1) return true else return false
}

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    val numbers = Array(10, {0})
    var x = n
    var flag = 10
    while (x > 0) {
        flag = x % 10
        numbers[flag] += 1
        x /= 10
    }
    var cnt = 0
    for (i in 0..9) {
        if (numbers[i] != 0) cnt++
    }
    if (cnt >= 2) return true else return false
}


/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */

fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()


/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    val elements = mutableListOf<Int>()
    val sqrList = mutableListOf<Int>()
    var numToSquare = 0
    var square = 0
    while (elements.size < n) {
        numToSquare += 1
        square = numToSquare * numToSquare
        while (square > 0) {
            sqrList.add(square % 10)
            square /= 10
        }
        for (i in 0..(sqrList.size - 1)) {
            elements += sqrList[sqrList.size - 1 - i]
        }
        sqrList.clear()
    }
    return elements[n - 1]
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    val elements = mutableListOf<Int>()
    val fibList = mutableListOf<Int>()
    var numToFib = 0
    var fibNum = 0
    while (elements.size < n) {
        numToFib += 1
        fibNum = fib(numToFib)
        while (fibNum > 0) {
            fibList.add(fibNum % 10)
            fibNum /= 10
        }
        for (i in 0..(fibList.size - 1)) {
            elements += fibList[fibList.size - 1 - i]
        }
        fibList.clear()
    }
    return elements[n - 1]
}