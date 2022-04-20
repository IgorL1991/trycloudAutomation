package com.trycloud.step_definitions;

import com.trycloud.pages.ContactsPage;
import com.trycloud.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class US13_ViewContactList_StepDefinitions {
    HomePage homePage = new HomePage();
    ContactsPage contactsPage = new ContactsPage();
    @When("the user clicks the contacts module")
    public void the_user_clicks_the_contacts_module() {
        homePage.contactsModule.click();
    }
    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list(List<String> expectedNames) {
        if(contactsPage.contactsList.isEmpty()){
            throw new RuntimeException("There no contacts at all ! PLease add contacts and retry !");
        }
        List<String> actualNames = new ArrayList<>();
        contactsPage.contactsList.forEach(p->actualNames.add(p.getText()));
        System.out.println("actualNames = " + actualNames);
        System.out.println("expectedNames = " + expectedNames);
        Assert.assertTrue(actualNames.containsAll(expectedNames));
    }
}
