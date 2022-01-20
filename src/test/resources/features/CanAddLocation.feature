Feature: Verify that a 'Керівник' can add a location of a club

  Scenario Outline: This test case verifies that a 'Керівник' can add a location of a club that doesn't refer to any center after filling in mandatory fields with valid data.

    Given Log in as an Керівник
    Then Go to the Мій профіль
    Then Click the Додати гурток button
    And Enter valid data into the Назва field of Основна інформація tab <validClubName>
    And Check off at least one check-box from Категорія group box
    And Enter valid data into the Вік дитини field ageFrom = <ageFrom> ageTo = <ageTo>
    Then Click the Наступний крок button
    Then Click the Додати локацію link on the Контакти tab
    And Check if Додати локацію pop up is displayed
    Then Enter valid data into the Назва field of Додати локацію pop-up <validLocationName>
    And Check if Data in the Назва field is accepted by input with <addLocationPopUpIds> at 0 index
    Then Choose a Kyiv city from the Місто drop-down list
    And Check if The Kyiv city accepted from the drop-down list by when choosing it in dropdown with <addLocationPopUpIds> at 1 index

    Then Choose Akademmistechko from the Метро/Місцевість drop-down list
    And Check if The Akademmistechko from the Метро/Місцевість accepted from drop-down list with <addLocationPopUpIds> at 2 index

    Then Choose a Desnianskyi district from the Район міста drop-down list
    And Check if The Desnianskyi district from the Район accepted from drop-down list with <addLocationPopUpIds> at 3 index

    Then Enter valid <validAddress> into the Адреса field
    And Check if Data in the Адреса field is accepted by input with <addLocationPopUpIds> at 4 index


    Examples:
      | validClubName | ageFrom | ageTo | validLocationName | addLocationPopUpIds                                              |validAddress|
      | ValidName2    | 2       | 18    | ValidLocationName | name,cityName,stationName,districtName,address,coordinates,phone |ValidAddress|


