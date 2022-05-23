package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSelenideWikiTest extends BaseTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com/";
    }

    @BeforeEach
    public void openWikiPage() {
        open("selenide/selenide");
        $("#wiki-tab").click();
        $(byText("Show 2 more pages…")).click();
    }

    @Test
    @DisplayName("Check Pages sidebar has SoftAssertions item")
    public void pagesHasSoftAssertions() {
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
    }

    @Test
    public void softAssertionsPageHasJUnit5Example() {
        $(byText("SoftAssertions")).click();

        $(".markdown-body")
                .shouldHave(text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"))
                .shouldHave(text("3. Using JUnit5 extend test class:"))
                .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }


}
