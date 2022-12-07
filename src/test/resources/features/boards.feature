Feature: Доски авторизованного пользователя
  Background: Открыта главная страница сайта
    Given Открыта главная страница сайта "https://trello.com"


  Scenario Outline: Проверка главной страницы Boards
    When Нажать на кнопку Log In
    And Ввод в поле логин "nid.swastest@gmail.com"
    And Нажать на кнопку продолжить
    And Ввод пароля юзера "nid.swastest@gmail.com"
    And Нажать на кнопку Войти
    Then Проверка основного экрана досок <text1>, <text2>
    Examples:
      | text1                       | text2                           |
      | "ВАШИ РАБОЧИЕ ПРОСТРАНСТВА" | "Доски" |


  Scenario: Все открытые доски отображаются на домашнем экране
    Given Юзер "nid.swastest@gmail.com" авторизирован
    Then Проверка открытых досок пользователя "nid.swastest@gmail.com"
