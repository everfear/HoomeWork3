import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class HoverTest
{

    @BeforeAll
    static void beforeAll()
    {

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void hoverEnterprisePageTest()
    {

        open("https://github.com");

        $(byTagAndText("button","Solutions")).hover();
        $("[href='/enterprise']").click();
        webdriver().shouldHave(url("https://github.com/enterprise"));

        closeWebDriver();

    }
}