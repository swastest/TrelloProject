package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class SelenideActions {

    public void click(SelenideElement element) {
        element.shouldBe(Condition.visible).click();
    }
}
