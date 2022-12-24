package ui.steps;

import api.conrtollers.BoardController;
import api.conrtollers.ListController;
import configProperties.UserProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.aeonbits.owner.ConfigFactory;
import ui.flow.*;
import utils.testData.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagesUtils {

    protected HomePageFlow homePageFlow = new HomePageFlow();
    protected MainPageFlow mainPageFlow = new MainPageFlow();
    protected SingInPageFlow singInPageFlow = new SingInPageFlow();
    protected MainBoardPageFlow mainBoardPageFlow = new MainBoardPageFlow();
    protected SomeTableFlow someTableFlow = new SomeTableFlow();
    protected UserProperties userConfig = ConfigFactory.create(UserProperties.class, System.getProperties());
    protected BoardController boardController = new BoardController();
    protected ListController listController = new ListController();


/*    public Map<Users, List<String>> context;

    @Before(order = 1, value = "API")
    public void startMethod(){
        context = new HashMap<>();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @After(order = 9999, value = "API")
    public void lastMethod(){
        context.forEach((k, v)->v.forEach(id->boardController.deleteTable(k, id,200)));
    }*/
}
