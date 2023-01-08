package ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        //      glue= {"src/main/java/ui/steps"},
        features = {"src/test/resources/features"}
     //   tags = "@API, @UI"
)
public class RunCucumberTest {
}

/*
* как запускать тесты по тегам?
* как вынести before and after методы в отдельный класс? /// глюк кукумбера
* вопросы по поводу glue
* вопрос по аннтотации Step
* логирование не получилось как хотела (в аллюр не идет, самое главное, что потоки не отображаются)
* потоки не получаются
* по поводу куки
*
* Логируем название сценария, и номер потока ... в методе бефоре, например
*
*
*
* в аллюр шло вен зен
* добавить проперти кукумбера - добавит в тест модуль
* заставить работать в параллеле
* запуск по тегам - добавь в билд гредел
* прописать глю - скормить папаку с проперти
* и вынести хуки в отдельный класс
* уточнить по поводу зависимости джиюнит4 и джиюнит5 класс Раннер
*
*
* */