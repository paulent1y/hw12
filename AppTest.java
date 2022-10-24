package by.paulent1y;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
        System.out.println("1");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        System.out.println("2");
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        System.out.println("3");
        assertTrue(true);
    }
    public void test2() {
        System.out.println(4);
        assertTrue(false);
    }
}
