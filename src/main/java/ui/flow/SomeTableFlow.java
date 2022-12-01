package ui.flow;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import ui.pom.elements.Column;
import ui.pom.pages.SomeTable;

public class SomeTableFlow {
    public SomeTableFlow checkColumnName(Integer integer, String expectColumnName){
        Assertions.assertThat(new Column(Selenide.page(SomeTable.class)
                        .getTrelloColumn().get(integer)).getColumnTitle()).contains(expectColumnName);
        return this;
    }
    public SomeTableFlow clickAddCard(Integer integer){
        new Column(Selenide.page(SomeTable.class).getTrelloColumn().get(integer)).clickAddCardButton();
        return this;
    }
    public SomeTableFlow setTextInNewCard(Integer integer, String text){
        new Column(Selenide.page(SomeTable.class).getTrelloColumn().get(integer)).selValInNexCard(text);
        return this;
    }

    public SomeTableFlow checkColumnContent(Integer integer, String containText){
        new Column(Selenide.page(SomeTable.class).getTrelloColumn().get(integer)).getRoot()
                .shouldHave(Condition.text(containText));
        return this;
    }
    public SomeTableFlow confirmAddedText(Integer integer){
        new Column(Selenide.page(SomeTable.class).getTrelloColumn().get(integer)).clickConfirmAddedNewCard();
        return this;
    }

    private SelenideElement getColumnString(String columnName){
        return Selenide.page(SomeTable.class).getTrelloColumn().findBy(Condition.text(columnName));
    }

    public SomeTableFlow test(String str){
        new Column(getColumnString(str)).clickAddCardButton();
        return this;
    }

    public SomeTableFlow clickAddCard (String columnName){
        new Column(getColumnString(columnName)).clickAddCardButton();
        return this;
    }

    public SomeTableFlow setTextInNewCard(String columnName, String text){
        new Column(getColumnString(columnName)).selValInNexCard(text);
        return this;
    }
    public SomeTableFlow confirmAddedText(String columnName){
        new Column(getColumnString(columnName)).clickConfirmAddedNewCard();
        return this;
    }

    public SomeTableFlow checkColumnContent(String columnName, String containText){
        new Column(getColumnString(columnName)).getRoot().shouldHave(Condition.text(containText));
        return this;
    }
}
