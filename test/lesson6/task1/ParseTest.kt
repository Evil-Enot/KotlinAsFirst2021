package lesson6.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Tag("NewTests")
class ParseTest {
    @Test
    fun bestHighJump() {
        // Проверка некорректных входных данных
        assertEquals(
            -1,
            bestHighJump("")
        )

        assertEquals(
            -1,
            bestHighJump("2658 + qwerty + 45 %-")
        )

        assertEquals(
            -1,
            bestHighJump("2658qwd1sd + 1457t + 45 %-")
        )

        assertEquals(
            -1,
            bestHighJump("f2s2d2431w + ww1211q + 2141 %- 532 %-+")
        )

        // Проверка корректных входных данных
        assertEquals(
            256,
            bestHighJump("256 +")
        )

        assertEquals(
            256,
            bestHighJump("351 %%- 256 %%%+ 369 -")
        )

        assertEquals(
            256,
            bestHighJump("34 %+ 347 %- 256 %%+ 257 -")
        )

        assertEquals(
            600,
            bestHighJump("100 + 200 %+ 300 %- 400 + 500 %%- 600 %+")
        )

        assertEquals(
            268,
            bestHighJump("95 + 130 -+ 2141 %- 268 %-+")
        )
    }

    @Test
    fun mostExpensive() {
        // Проверка некорректных входных данных
        assertEquals(
            "",
            mostExpensive("")
        )

        assertEquals(
            "",
            mostExpensive("Хлеб Молоко")
        )

        assertEquals(
            "",
            mostExpensive("55.0 Хлеб; Молоко 123.4")
        )

        // Проверка корректных входных данных
        assertEquals(
            "Молоко",
            mostExpensive("Хлеб 55.0; Молоко 123.4")
        )

        assertEquals(
            "Мясо",
            mostExpensive("Курица 356.0; Хлеб 123.4; Мясо 356.0")
        )

        assertEquals(
            "Конфеты",
            mostExpensive("Молоко 123.4; Хлеб 456.2; Конфеты 987.9; Круассаны 456.2")
        )

        assertEquals(
            "Мыло",
            mostExpensive("Круассаны 56.5; Мыло 099.4; Хлеб 23.5")
        )

        // Проверка корректных входных данных, при которых название товара - различные символы
        assertEquals(
            "96.89",
            mostExpensive("Круассаны 56.5; 96.89 099.4; Хлеб 23.5")
        )

        assertEquals(
            "@$%£",
            mostExpensive("@$%£ 56.5; Хлеб 23.5; Молоко 23")
        )

        assertEquals(
            "'",
            mostExpensive("' 56.5; Хлеб 23.5; Молоко 23")
        )

//      Проверка ошибки при некорректном вводе: когда название товара пропущено
        assertThrows<IndexOutOfBoundsException> {
            mostExpensive("Курица 356.0; Хлеб 123.4; 356.0")
        }

//      Проверка ошибки при некорректном вводе: когда название пропущено и добавлен дополниельный пробел
        assertThrows<IndexOutOfBoundsException> {
            mostExpensive("Курица 356.0; Хлеб 123.4;  356.0")
        }
    }
}