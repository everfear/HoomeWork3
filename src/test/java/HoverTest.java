import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
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

        $$("button.HeaderMenu-link.border-0.width-full.width-lg-auto." +
                "px-0.px-lg-2.py-3.py-lg-2.no-wrap.d-flex.flex-items-center." +
                "flex-justify-between.js-details-target")
                .findBy(text("Solutions")).hover();
        $("[href='/enterprise']").click();
        webdriver().shouldHave(url("https://github.com/enterprise"));

        closeWebDriver();

    }
}