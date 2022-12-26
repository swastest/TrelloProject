package utils.testData;

import api.conrtollers.BoardController;
import api.conrtollers.ListController;
import configProperties.UserProperties;
import org.aeonbits.owner.ConfigFactory;
import ui.flow.*;

public class PagesUtils {

    protected HomePageFlow homePageFlow = new HomePageFlow();
    protected MainPageFlow mainPageFlow = new MainPageFlow();
    protected SingInPageFlow singInPageFlow = new SingInPageFlow();
    protected MainBoardPageFlow mainBoardPageFlow = new MainBoardPageFlow();
    protected SomeTableFlow someTableFlow = new SomeTableFlow();
    protected static UserProperties userConfig = ConfigFactory.create(UserProperties.class, System.getProperties());
    protected BoardController boardController = new BoardController();
    protected ListController listController = new ListController();


/*    public Map<Users, List<String>> context;

   @Before(order = 1, value = "@API")
    public void startMethod(){
        context = new HashMap<>();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @After(order = 9999, value = "@API")
    public void lastMethod(){
        context.forEach((k, v)->v.forEach(id->boardController.deleteTable(k, id,200)));
    }

    @Before(value = "@UI")
    public static void beforeMethod(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        System.out.println("++++++++++++++ _________------------");
        Configuration.browserSize = "1800x500";
    }
    @After(value = "@UI")
    public void afterMethod(){
        Attach.screenshotAs("LastStep");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Selenide.closeWebDriver();

        System.out.println("++++++++++++++ _________------------");
    }*/
}
