package ui.flow;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
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
}
