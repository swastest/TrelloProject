Feature: Доски авторизованного пользователя
  Background: Открыта главная страница сайта
    Given Открыть сайт "https://trello.com"


  Scenario Outline: Проверка главной страницы Boards
    When Нажать на кнопку Log In
    And Ввод в поле логин email
    And Нажать на кнопку продолжить
    And Ввод пароля
    And Нажать на кнопку Войти
    Then Проверка основного экрана досок <text1>, <text2>
    Examples:
      | text1                       | text2                           |
      | "ВАШИ РАБОЧИЕ ПРОСТРАНСТВА" | "ГОСТЕВЫЕ РАБОЧИЕ ПРОСТРАНСТВА" |

  Scenario: Проверка названия колонки
    When Нажать на кнопку Log In
    And Ввод в поле логин email
    And Нажать на кнопку продолжить
    And Ввод пароля
    And Нажать на кнопку Войти
    And Нажать на кнопку перехода на доску
    And Проверка имени первой колонки

  Scenario: Добавление новой записи в колонку
    When Нажать на кнопку Log In
    And Ввод в поле логин email
    And Нажать на кнопку продолжить
    And Ввод пароля
    And Нажать на кнопку Войти
    And Нажать на кнопку перехода на доску
    And Нажать на кнопку добавить карточку
    And Ввод текста в новую карточку "ПривеТ"
    And Подтвердить добавление новой записи
    Then Проверка что текст "ПривеТ" отображается в колонке

  Scenario: Добавление новой записи в колонку через стрим
    When Авторизация
    And Нажать на кнопку перехода на доску
    And Нажать на кнопку добавить карточку, в колонке "В процессе"
    And Ввести текст "Абракадабра", в карточку колонки "В процессе"
    And Подтвердить добавление новой записи в колонке "В процессе"
    Then Проверить, что добавленный текст "Абракадабра", содержится в колонке "В процессе"