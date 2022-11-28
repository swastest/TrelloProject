package ui.pom.elements;

import com.codeborne.selenide.SelenideElement;

public class Column {
    private final SelenideElement root;
    private static final String TITLE = "div.list-header";
    private static final String ADD_CARD_BUTTON = "a.open-card-composer";
    private static final String CONFIRM_ADDED_CARD = "input.confirm";
    private static final String INPUT_TXT = "textarea.list-card-composer-textarea";

    public Column(SelenideElement root) {
        this.root = root;
    }

    public SelenideElement getRoot() {
        return root;
    }

    public String getColumnTitle() {
        return root.$(TITLE).text();
    }

    public void clickAddCardButton() {
        root.$(ADD_CARD_BUTTON).click();
    }

    public void selValInNexCard(String text) {
        root.$(INPUT_TXT).val(text);
    }

    public void clickConfirmAddedNewCard() {
        root.$(CONFIRM_ADDED_CARD).click();
    }
}
