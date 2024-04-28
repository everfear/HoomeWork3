import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsPageTest
{

    @BeforeAll
    static void beforeAll()
    {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void findJUnit5CodeTest()
    {

        open("/selenide/selenide");

        $("#wiki-tab").click();
        $("#wiki-pages-filter").click();
        $("#wiki-pages-filter").sendKeys("SoftAssertions");
        $("#wiki-pages-box").$(byText("SoftAssertions")).shouldBe(visible);
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $$("div.markdown-heading").findBy(text("JUnit5")).sibling(0).shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                 class Tests {
                   @Test
                   void test() {
                     Configuration.assertionMode = SOFT;
                     open("page.html");
                 
                     $("#first").should(visible).click();
                     $("#second").should(visible).click();
                   }
                 }"""));

        closeWebDriver();

    }
}
