package com.example.art_space

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ArtSpaceCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun artSpaceCardTest() {
        // Запускаем  Composable
        composeTestRule.setContent {
            ArtSpaceCard()
        }

        // Проверяем, что на экране отображается нужный текст
        composeTestRule.onNodeWithText("Назад").assertExists()
        composeTestRule.onNodeWithText("Вперед").assertExists()

        // Имитируем нажатие кнопки "Вперед"
        composeTestRule.onNode(hasText("Вперед")).performClick()
    }
    @Test
    fun artSpaceCardImageTest() {
        composeTestRule.setContent {
            ArtSpaceCard()
        }
        composeTestRule.onNode(hasTestTag("ArtWorkImage")).assertExists()


    }
}