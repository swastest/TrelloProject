@API
Feature: Какие то апи тесты

  Scenario: Новая добавленная доска отображается в методе вывода досок
    When Пользователь TEST_USER_1 добавляет доску "Доска из теста"
    Then Проверка, что новая доска "Доска из теста" отображается в списке всех досок, для пользователя TEST_USER_1

  Scenario: Добавленная колонка отображается в списке всех колонн на доске
    When Пользователь TEST_USER_1 добавил новую колонну "Запись из теста" на доску "HelloWorld"
    Then Проверка, что пользователь TEST_USER_1 видит новую  колонну "Запись из теста" в списке колонн для доски "HelloWorld"



