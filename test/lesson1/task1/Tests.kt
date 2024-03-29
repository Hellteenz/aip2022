package lesson1.task1

import lesson6.task1.computeDeviceCells
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.math.PI

class Tests {
    @Test
    @Tag("Example")
    fun sqr() {
        assertEquals(0, sqr(0))
        assertEquals(4, sqr(2))
        assertEquals(9, sqr(-3))
    }

    @Test
    @Tag("Example")
    fun sqrDouble() {
        assertEquals(0.0, sqr(0.0), 1e-13)
        assertEquals(4.0, sqr(2.0), 1e-13)
        assertEquals(9.0, sqr(-3.0), 1e-13)
    }

    @Test
    @Tag("Example")
    fun discriminant() {
        assertEquals(0.0, discriminant(0.0, 0.0, 0.0), 1e-13)
        assertEquals(0.0, discriminant(1.0, -2.0, 1.0), 1e-13)
        assertEquals(1.0, discriminant(1.0, 3.0, 2.0), 1e-13)
    }

    @Test
    @Tag("Example")
    fun quadraticEquationRoot() {
        assertEquals(2.0, quadraticEquationRoot(1.0, -3.0, 2.0), 1e-13)
        assertEquals(1.0, quadraticEquationRoot(1.0, -2.0, 1.0), 1e-13)
        assertEquals(-3.0, quadraticEquationRoot(1.0, 6.0, 9.0), 1e-13)
    }

    @Test
    @Tag("Example")
    fun quadraticRootProduct() {
        assertEquals(1.0, quadraticRootProduct(1.0, -2.0, 1.0), 1e-13)
        assertEquals(9.0, quadraticRootProduct(1.0, 6.0, 9.0), 1e-13)
        assertEquals(2.0, quadraticRootProduct(1.0, 3.0, 2.0), 1e-13)
    }

    @Test
    @Tag("3")
    fun seconds() {
        assertEquals(30035, seconds(8, 20, 35))
        assertEquals(86400, seconds(24, 0, 0))
        assertEquals(13, seconds(0, 0, 13))
    }

    @Test
    @Tag("1")
    fun lengthInMeters() {
        assertEquals(18.98, lengthInMeters(8, 2, 11), 1e-2)
        assertEquals(2.13, lengthInMeters(1, 0, 0), 1e-2)
    }

    @Test
    @Tag("1")
    fun angleInRadian() {
        assertEquals(0.63256, angleInRadian(36, 14, 35), 1e-5)
        assertEquals(PI / 2.0, angleInRadian(90, 0, 0), 1e-5)
    }

    @Test
    @Tag("1")
    fun trackLength() {
        assertEquals(5.0, trackLength(3.0, 0.0, 0.0, 4.0), 1e-5)
        assertEquals(1.0, trackLength(0.0, 1.0, -1.0, 1.0), 1e-5)
        assertEquals(1.41, trackLength(1.0, 1.0, 2.0, 2.0), 1e-2)
    }

    @Test
    @Tag("2")
    fun thirdDigit() {
        assertEquals(8, thirdDigit(3801))
        assertEquals(1, thirdDigit(100))
        assertEquals(0, thirdDigit(1000))
    }

    @Test
    @Tag("2")
    fun travelMinutes() {
        assertEquals(216, travelMinutes(9, 25, 13, 1))
        assertEquals(1, travelMinutes(21, 59, 22, 0))
    }

    @Test
    @Tag("2")
    fun accountInThreeYears() {
        assertEquals(133.1, accountInThreeYears(100, 10), 1e-2)
        assertEquals(1.0, accountInThreeYears(1, 0), 1e-2)
        assertEquals(104.0, accountInThreeYears(13, 100), 1e-2)
    }

    @Test
    @Tag("2")
    fun numberRevert() {
        assertEquals(874, numberRevert(478))
        assertEquals(201, numberRevert(102))
    }

    @Test
    fun binarySearching() {
        assertEquals(true, binarySearching(listOf(1, 2, 3, 4, 5, 6), 3))
        assertEquals(true, binarySearching(listOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 11))
    }

    @Test
    fun fastSearchingPhone() {
        assertEquals(listOf("Maxim", "Oczin"),
            fastSearchingPhone(listOf("Maxim", "Oleg", "Oczin"), "62946")
        )
        assertEquals(
            listOf("Vladimir", "Tkafinis", "Vladimir"),
            fastSearchingPhone(
                listOf("Alexander", "Vladimir", "Anna", "Tkafinis", "Vladimir"),
                "85234647"
            )
        )
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            fastSearchingPhone(
                listOf(
                    "Ion12"
                ), "210"
            )
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            fastSearchingPhone(
                listOf(
                    "maxim"
                ), "210"
            )
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            fastSearchingPhone(
                listOf(
                    "Maxim"
                ), "ac21"
            )
        }
    }

    @Test
    fun neighbors() {
        assertEquals(
            "1",
            neighbors(
                listOf(
                    "Иванов Петр: улица Ленина, 41, кв. 2",
                    "Ульянова Анна: улица Ленина, 41, кв. 45",
                    "Сазанов Кирилл: улица Демидовская, 32, кв. 4"
                ),
                "Иванов Петр, Ульянова Анна"
            )
        )
        //assertEquals(true, neighbors(listOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 11))
    }

    @Test
    fun myFun() {
        assertEquals("ООО Горняк - 12000.0, Сбербанк - 17100.0", myFun(
            mapOf("Производство напитков" to 4, "Горнодобыв пром" to 12, "Банковские операции" to 9),
            """ООО Горняк - Горнодобыв пром - 100000 
            |Сбербанк - Банковские операции - 190000""".trimMargin()
        )
        )
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            fastSearchingPhone(
                listOf(
                    "Maxim"
                ), "ac21"
            )
        }
    }
}