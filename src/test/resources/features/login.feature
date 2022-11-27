Feature: Login user
  Background: Открыта главная страница сайта
    Given Открыть сайт "https://trello.com"

  Scenario Outline: Авторизация юзера
    When Нажать на кнопку Log In
    And Ввод в поле логин email
    And Нажать на кнопку продолжить
    And Ввод пароля
    And Нажать на кнопку Войти
    Then Проверка имени аккаунта

    Examples:
      | login      | pass |
      | ---------- | ---- |

