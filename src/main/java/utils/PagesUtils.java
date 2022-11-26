package utils;

import org.aeonbits.owner.ConfigFactory;
import ui.flow.HomePageFlow;
import ui.flow.MainPageFlow;
import ui.flow.SingInPageFlow;

public abstract class PagesUtils {
    protected  HomePageFlow homePageFlow = new HomePageFlow();
    protected  MainPageFlow mainPageFlow = new MainPageFlow();
    protected  SingInPageFlow singInPageFlow = new SingInPageFlow();

}
