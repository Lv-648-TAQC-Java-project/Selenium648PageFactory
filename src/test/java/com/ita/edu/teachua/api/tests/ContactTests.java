package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.ContactClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.contact.ContactModel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class ContactTests extends AuthorizedAsAdminApiTestRunner{
    @Test
    public void createChangeAndDeleteContact() throws IOException {
        ContactClient contactClient = new ContactClient(authorization.getToken());
        Response addContactResponse = contactClient.addNewContact();
        ContactModel contactModel = addContactResponse.then().log().all().extract().as(ContactModel.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(contactModel.getName(), "Телефон1");

        Response changeContactResponse = contactClient.changeContact(contactModel.getId());
        ContactModel changedContact = changeContactResponse.then().log().all().extract().as(ContactModel.class);
        softAssert.assertEquals(changedContact.getName(), "Телефон2");
        softAssert.assertEquals(changedContact.getUrlLogo(), "/static/images/contacts/phone.svg");
        softAssert.assertAll();

        Response delete = contactClient.deleteContact(contactModel.getId());
        Assert.assertEquals(delete.getStatusCode(), 200);
    }

    @Test
    public void getContact() throws IOException {
        Specifications.setResponseSpecification(200);
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        SoftAssert softAssert = new SoftAssert();
        ContactClient contactClient = new ContactClient(authorization.getToken());
        Response get = contactClient.getContact(2);
        ContactModel contactModel = get.then().log().all()
                .extract().as(ContactModel.class);
        Assert.assertEquals(get.getStatusCode(), 200);
        softAssert.assertEquals(contactModel.getName(), "Facebook");
        softAssert.assertEquals(contactModel.getUrlLogo(), "/static/images/contacts/facebook.svg");
        softAssert.assertAll();
    }

    @Test
    public void getContacts() throws IOException {
        Specifications.setResponseSpecification(200);
        ContactClient contactClient = new ContactClient(authorization.getToken());
        Response response = contactClient.getContacts();
        List<ContactModel> contactModelList = response
                .then().log().all()
                .extract().body().jsonPath().getList(".", ContactModel.class);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
