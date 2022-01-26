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

    Then Enter valid <coordinates> into the Координати field
    And Check if Data in the Координати field is accepted by input with <addLocationPopUpIds> at 5 index

    Then Enter valid <validPhone> into the Номер телефону field
    And Check if Data in the Номер телефону field is accepted by input with <addLocationPopUpIds> at 6 index
    And Click on Додати button

    Then Enter valid data <validPhone> into the Контакти group box 1st field
    And Check if Data in the Контакти group box 1st field is accepted by input with <addClubPopUpComponentIds> at 0 index

    Examples:
      | validClubName | ageFrom | ageTo | validLocationName | addLocationPopUpIds                                              | validAddress | coordinates                            | validPhone | addClubPopUpComponentIds                                                                                                     |
      | ValidName2    | 2       | 18    | ValidLocationName | name,cityName,stationName,districtName,address,coordinates,phone | ValidAddress | 49.829104498711104, 24.005058710351314 | 0966666666 | basic_contactТелефон,basic_contactFacebook,basic_contactWhatsApp,basic_contactПошта,basic_contactSkype,basic_contactContact |

  Scenario Outline: This test case verifies that a 'Керівник' can add location to the list of locations after filling in all mandatory and all optional fields with valid data
    Given Log in as an Керівник
    And Go to the 'Додати центр'
    When Click on '+Додати локацію' button
    And Fill 'Назва' field with correct value <validLocationName>
    And Select Київ from the city dropdown list
    And Select Академмістечко from the dropdown list
    And Select Деснянський from the dropdown list
    And Fill in 'Адреса' field with <validAddress>
    And Fill in 'Координати' field with <validCoordinates>
    And Fill in 'Номер телефону' field with <validPhoneNumber>
    And Click on 'Додати' button
    Then Location <validLocationName> is in the list of locations
    Examples:
      | validLocationName | validAddress | validCoordinates | validPhoneNumber |
      | ValidLocationName | ValidAddress | 49.829104498711104, 24.005058710351314 | 0976855546 |
