package lecture01;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for HelloWorld
 */
public class HelloWorldTest {


    @Test
    public void testHello() throws Exception {
        //Arrange
        HelloWorld app = new HelloWorld();

        //Act

        //Assert
        assertEquals("hello", app.hello());
    }
}