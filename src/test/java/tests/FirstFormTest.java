package tests;

import org.junit.jupiter.api.*;


public class FirstFormTest {

    int result;

    @BeforeAll
    static void beforeAll(){
        System.out.println("\n###  beforeAll()\n");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("###  beforeEach()");
        result = getResult();
    }

    @Test
    void firstTest() {
        System.out.println("###     firstTest()");
        Assertions.assertTrue(result > 2);

    }

    @Test
    void secondTest(){
        System.out.println("###     secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest(){
        System.out.println("###     thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    @AfterEach
     void afterEach(){
        System.out.println("###  afterEach()\n");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("###  afterAll()\n");
    }

    private int getResult() {
        return 3;
    }
}
