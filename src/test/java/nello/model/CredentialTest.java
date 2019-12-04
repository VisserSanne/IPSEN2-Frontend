package nello.model;

import org.junit.Assert;
import org.junit.Test;

public class CredentialTest {
    Credential credential;

    public void setUp(){
        credential = new Credential("test@email.com", "password");
    }

    @Test
    public void getEmailTest(){
        setUp();
        Assert.assertEquals(credential.getEmail(),"test@email.com");
    }

    @Test
    public void getPassword(){
        setUp();
        Assert.assertEquals(credential.getPassword(),"password");
    }
}
