package lesson5.task1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MapTest {
    @Test
    fun extractRepeats() {
        // Проверка пустого ввода
        Assertions.assertEquals(
            emptyMap<String, Int>(),
            extractRepeats(emptyList())
        )

        // Приверка входных данных без повторений
        Assertions.assertEquals(
            emptyMap<String, Int>(),
            extractRepeats(listOf("a", "b", "c", "d", "e"))
        )

        //Проверка обычных входных данных (с ожидаемым корректным результатом)
        Assertions.assertEquals(
            mapOf("a" to 2),
            extractRepeats(listOf("a", "b", "a", "c", "d", "e"))
        )

        Assertions.assertEquals(
            mapOf("a" to 5),
            extractRepeats(listOf("a", "a", "a", "a", "a"))
        )

        Assertions.assertEquals(
            mapOf("a" to 3, "b" to 2),
            extractRepeats(listOf("a", "b", "a", "c", "d", "b", "a", "e"))
        )

        Assertions.assertEquals(
            mapOf("b" to 2, "2" to 2),
            extractRepeats(listOf("a", "b", "2", "c", "@", "b", "&", "2", ""))
        )

        // Проверка входных данных из символов
        Assertions.assertEquals(
            mapOf("b" to 2, "@" to 2),
            extractRepeats(listOf("a", "b", "2", "c", "@", "b", "&", "@", ""))
        )

        Assertions.assertEquals(
            mapOf("" to 4),
            extractRepeats(listOf("a", "", "2", "", "b", "", "@", ""))
        )

        Assertions.assertEquals(
            mapOf("\"" to 2),
            extractRepeats(listOf("a", "\"", "2", "\"", "b", "@", ""))
        )
    }

    @Test
    fun findSumOfTwo() {
        // Проверка некооректных введенных данных
        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(emptyList(), 2)
        )

        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(listOf(2), 2)
        )

        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(listOf(7), 3)
        )

        Assertions.assertEquals(
            Pair(-1, -1),
            findSumOfTwo(listOf(1, 5, 9), 4)
        )

        // Проверка корректных входных данных
        Assertions.assertEquals(
            Pair(0, 3),
            findSumOfTwo(listOf(0, 5, 3, 4, 6), 4)
        )

        Assertions.assertEquals(
            Pair(0, 2),
            findSumOfTwo(listOf(1, 5, 3, 2, 6), 4)
        )

        Assertions.assertEquals(
            Pair(1, 3),
            findSumOfTwo(listOf(1, 5, 2, 3, 7), 8)
        )
    }
}