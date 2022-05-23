package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest extends BaseTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
    }

    @Test
    public void dragAtoB() {
        open("drag_and_drop");

        $("#column-a").dragAndDropTo("#column-b");
        $("#column-b").$("header").shouldHave(text("A"));
    }

}
