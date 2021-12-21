package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CenterClient;
import com.ita.edu.teachua.api.models.center.center_response.CenterRoot;
import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import com.ita.edu.teachua.ui.pages.profile_page.CentersItemComponent;
import com.ita.edu.teachua.ui.pages.profile_page.ProfilePage;
import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.Throw;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class AddCenterTest extends AuthorizedAsAdminApiTestRunner{

    @Test(description = "TUA-261")
    public void createCenter() throws IOException {
        Specifications.setResponseSpecification(200);
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response response = centerClient.addNewCenter();
        CenterRoot centerRoot = response.then().log().all()
                .extract().as(CenterRoot.class);

        Assert.assertEquals(centerRoot.getName(), "API_testing5 ");
        Assert.assertEquals(centerRoot.getUserId(), 1);

        HeaderPage header = new HeaderPage(driver);
         ProfilePage profilePage = header
                .authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickOnMyClubsDropdown()
                .clickOnCentersButton();
        for(CentersItemComponent center: profilePage.getCenters()){
            if(center.getCenterTitle().getText().contains("API_testing")){
                System.out.println("Center has been created");
            }
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Response response1 = centerClient.deleteNewCenter(centerRoot.getId());
        Assert.assertEquals(response1.getStatusCode(), 200);
    }
}
