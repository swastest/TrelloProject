package ui.pom.pages;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class SomeTable {

    @FindBy(css ="div#board")
    ElementsCollection trelloColumn;
}
