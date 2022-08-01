Feature: [Registration] Error massages are shown for empty fields
  Scenario Outline:  verify that error messages are shown when user tries to register with empty fields on 'Реєстрація' page.
    Given Go to registration page
    Then Verify that <errorLastName> appear in last name field after fill <lastName> and clear
    And Verify that <errorFirstName> appear in first name field after fill <firstName> and clear
    And Verify that <errorEmail> appear in email field after fill <email> and clear
    And Verify that <errorPhone> appear in phone field after fill <validPhone> and clear
    And Verify that <errorPassword> appear in password field after fill <password> and clear
    And Verify that <errorConfirmPassword> appear in confirm password field after fill <confirmPassword> and clear





    Examples:
      | errorLastName    | lastName | errorFirstName |firstName |errorPhone             | validPhone    | errorEmail    | email       | errorPassword  | password | errorConfirmPassword | confirmPassword |
      | Введіть прізвище | Грім     | Введіть ім`я   |Павло     |Введіть номер телефону | 931234567     | Введіть email | grim@com.ua | Введіть пароль | 12345678 | Підтвердіть пароль   | 12345678        |
