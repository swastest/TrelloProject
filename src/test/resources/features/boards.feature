@UI
Feature: Доски авторизованного пользователя

  Scenario Outline: Проверка главной страницы Boards
    Given Юзер TEST_USER_1 авторизирован
    Then Проверка основного экрана досок <text1>, <text2>
    Examples:
      | text1                       | text2   |
      | "ВАШИ РАБОЧИЕ ПРОСТРАНСТВА" | "Доски" |


  Scenario: Все открытые доски отображаются на домашнем экране
    Given Юзер TEST_USER_1 авторизирован
    Then Проверка открытых досок пользователя TEST_USER_1

  Scenario: Все новые доски отображаются на домашнем экране
    Given Пользователь TEST_USER_1 добавляет доску "НоваяДоска"
    Given Юзер TEST_USER_1 авторизирован
    Then Проверка, что новая доска "НоваяДоска" отображается на домашнем экране
    Then Удаление добавленной доски "НоваяДоска" юзером TEST_USER_1
