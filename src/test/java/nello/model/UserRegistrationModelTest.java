package nello.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRegistrationModelTest {

    private UserRegistrationModel model;

    @Before
    public void setUp() {
        this.model = new UserRegistrationModel();
    }

    @Test
    public void testClearMessages() {
        this.model.setError("Test");
        this.model.clearErrors();
        assertEquals(0, this.model.getErrorMessages().size());
    }

    @Test
    public void testRemoveError() {
        this.model.setError("Test");
        this.model.removeError("Test");
        assertEquals(0, this.model.getErrorMessages().size());
    }
}
