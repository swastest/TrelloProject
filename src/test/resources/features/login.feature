Feature: Login user
  Background: Открыта главная страница сайта
    Given Открыта главная страница сайта "https://trello.com"

  Scenario Outline: Авторизация юзера
    When Нажать на кнопку Log In
    And Ввод в поле логин "nid.swastest@gmail.com"
    And Нажать на кнопку продолжить
    And Ввод пароля юзера "nid.swastest@gmail.com"
    And Нажать на кнопку Войти
    Then Проверка имени аккаунта "nid.swastest@gmail.com"

    Examples:
      | login      | pass |
      | ---------- | ---- |

