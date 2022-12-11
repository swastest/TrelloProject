Feature: Доски авторизованного пользователя
  Background: Открыта главная страница сайта
    Given Открыта главная страница сайта "https://trello.com"


  Scenario Outline: Проверка главной страницы Boards
    Given Юзер "nid.swastest@gmail.com" авторизирован
    Then Проверка основного экрана досок <text1>, <text2>
    Examples:
      | text1                       | text2   |
      | "ВАШИ РАБОЧИЕ ПРОСТРАНСТВА" | "Доски" |


  Scenario: Все открытые доски отображаются на домашнем экране
    Given Юзер "nid.swastest@gmail.com" авторизирован
    Then Проверка открытых досок пользователя "nid.swastest@gmail.com"

  Scenario: Все новые доски отображаются на домашнем экране
    Given Создать новую доску "НоваяДоска" юзером "nid.swastest@gmail.com"
    Given Юзер "nid.swastest@gmail.com" авторизирован
    Then Проверка, что новая доска "НоваяДоска" отображается на домашнем экране
    Then Удаление добавленной доски "НоваяДоска" юзером "nid.swastest@gmail.com"
