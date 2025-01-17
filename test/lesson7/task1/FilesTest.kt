package lesson7.task1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.File

@Tag("NewTests")
class FilesTest {
    // Функция для сравнения ожидаемых результатов и данных из файла
    private fun sevenTaskTests(lhv: Int, rhv: Int, result: String, pointer: Int) {
        if (File("temp.txt").exists()) File("temp.txt").delete()

        if (pointer == 0) {
            printMultiplicationProcess(lhv, rhv, "temp.txt")
        } else {
            printDivisionProcess(lhv, rhv, "temp.txt")
        }

        val file = File("temp.txt")
        Assertions.assertEquals(result.trimIndent(), file.readLines().joinToString("\n"))

        File("temp.txt").delete()
    }

    @Test
    fun printMultiplicationProcess() {
        // Проверка корректных входных данных
        sevenTaskTests(
            1,
            25648,
            """
                     1
                *25648
                ------
                     8
                +   4
                +  6
                + 5
                +2
                ------
                 25648
             """,
            0
        )

        sevenTaskTests(
            2145,
            34587,
            """
                     2145
                *   34587
                ---------
                    15015
                +  17160
                + 10725
                + 8580
                +6435
                ---------
                 74189115
             """,
            0
        )

        sevenTaskTests(
            412745,
            4124,
            """
                     412745
                *      4124
                -----------
                    1650980
                +   825490
                +  412745
                +1650980
                -----------
                 1702160380
             """,
            0
        )

        sevenTaskTests(
            23412,
            22,
            """
                  23412
                *    22
                -------
                  46824
                +46824
                -------
                 515064
             """,
            0
        )

        // Проверка некорректных входных данных
        // Проверка, что будет выброшено исключение при отрицательном числе
        assertThrows<IllegalArgumentException> {
            printMultiplicationProcess(2353, -2, "temp.txt")
        }

        // Проверка, что будет выброшено исключение при нуле
        assertThrows<IllegalArgumentException> {
            printDivisionProcess(0, 516, "temp.txt")
        }
    }

    @Test
    fun printDivisionProcess() {
        // Проверка корректных входных данных
        sevenTaskTests(
            12845,
            1,
            """
                 12845 | 1
                -1       12845
                --
                 02
                 -2
                 --
                  08
                  -8
                  --
                   04
                   -4
                   --
                    05
                    -5
                    --
                     0
             """,
            1
        )

        sevenTaskTests(
            2342,
            23,
            """
                 2342 | 23
                -23     101
                ---
                  04
                  -0
                  --
                   42
                  -23
                  ---
                   19
             """,
            1
        )

        sevenTaskTests(
            35198,
            2,
            """
                 35198 | 2
                -2       17599
                --
                 15
                -14
                ---
                  11
                 -10
                 ---
                   19
                  -18
                  ---
                    18
                   -18
                   ---
                     0
             """,
            1
        )

        sevenTaskTests(
            123125,
            12355673,
            """
                123125 | 12355673
                    -0   0
                ------
                123125
             """,
            1
        )

        // Проверка некорректных входных данных
        // Проверка, что будет выброшено исключение при нуле
        assertThrows<ArithmeticException> {
            printDivisionProcess(126, 0, "temp.txt")
        }

        // Проверка, что будет выброшено исключение при нуле
        assertThrows<IllegalArgumentException> {
            printDivisionProcess(0, 234, "temp.txt")
        }

        // Проверка, что будет выброшено исключение при отрицательном числе
        assertThrows<IllegalArgumentException> {
            printDivisionProcess(126, -1, "temp.txt")
        }
    }
}
