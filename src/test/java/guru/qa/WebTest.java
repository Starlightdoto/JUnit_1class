package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest {

    @BeforeEach
    void setUp() {
        open("https://learn.javascript.ru/");
    }


    @CsvSource({"Учебник, Современный учебник JavaScript",
                "Курсы, Онлайн-курсы по JavaScript-технологиям"})
    @ParameterizedTest(name = "Asserting tab {0}" + "shows header {1}")
    void tabContentTest(String tabName, String header) {
        $(".sitetoolbar__section").$(byText("Учебник")).click();
        $(".frontpage-banner__col").shouldHave(text("Современный учебник JavaScript"));
    }
}
