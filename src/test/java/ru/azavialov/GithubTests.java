package ru.azavialov;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

public class GithubTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void testHoverOnMainGithubPageTest() {
        open("");
        $$(".HeaderMenu-link").findBy(text("Solutions")).hover();
        $("#solutions-for-heading").sibling(0).$(byText("Enterprise")).click();
        $(".enterprise-hero-heading").shouldBe(visible).shouldHave(text("The AI-powered developer platform."));

    }
}
