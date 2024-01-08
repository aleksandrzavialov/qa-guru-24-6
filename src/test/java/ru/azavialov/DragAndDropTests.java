package ru.azavialov;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

public class DragAndDropTests {
    SelenideElement firstRectangle = $("#column-a");
    SelenideElement secondRectangle = $("#column-b");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void beforeEach() {
        open("");
        firstRectangle.shouldHave(text("A"));
        secondRectangle.shouldHave(text("B"));
    }

    @Test
    void dragAndDropWithSelenideActionsTest() {
        actions().dragAndDrop(firstRectangle, secondRectangle).perform();
        firstRectangle.shouldHave(text("B"));
        secondRectangle.shouldHave(text("A"));

    }

    @Test
    void dragAndDropWithElementCommandTest() {
        firstRectangle.dragAndDrop(DragAndDropOptions.to(secondRectangle));
        firstRectangle.shouldHave(text("B"));
        secondRectangle.shouldHave(text("A"));
    }
}
