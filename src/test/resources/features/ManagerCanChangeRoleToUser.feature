Feature: [Edit profile] The manager can change it's role
  Scenario: Verify that the manager can change role to 'user' and then back to 'manager'
    Given Click on Guest DropDown icon
    And Select Увійти option
    When Enter {email} in the Email field
    And Enter {password} in the Пароль field
    And Click on Увійти button
    Then Go to the Мій профіль
    And Click on Edit profile
    Then Click on Відвідувач button
    And Click on Зберегти зміни button
    Then Check if ROLE_MANAGER field has been changed to ROLE_USER
    Then Click on Edit profile
    Then Click on Керівник button
    And Click on Зберегти зміни button
    Then Check if ROLE_USER field has been changed to ROLE_MANAGER