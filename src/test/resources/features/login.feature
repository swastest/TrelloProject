Feature: Login user

  Background: Открыта главная страница сайта
    Given Открыта главная страница сайта "https://trello.com"

  Scenario Outline: Авторизация юзера
    When Нажать на кнопку Log In
    When Ввод в поле логин <login>
    When Нажать на кнопку продолжить
    When Ввод пароля юзера <login>
    When Нажать на кнопку Войти
    Then Проверка имени аккаунта <login>

    Examples:
      | login                    |
      | "nid.swastest@gmail.com" |

