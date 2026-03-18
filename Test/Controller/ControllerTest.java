package Controller;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

    @Before
    public void setup() {
        Controller.getInstance().reset();
    }
}
