@UI
Feature: Login user

  Scenario Outline: Авторизация юзера
    When Нажать на кнопку Log In
    When Ввод в поле логин юзера TEST_USER_1
    When Нажать на кнопку продолжить
    When Ввод пароля юзера TEST_USER_1
    When Нажать на кнопку Войти
    Then Проверка имени аккаунта <login>

    Examples:
      | login                    |
      | "nid.swastest@gmail.com" |

