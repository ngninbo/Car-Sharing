class CalculatorTest {
    void testAddition() {
        int expected = 5;
        int actual = new Calculator().add(1, 4);
        Assertions.assertEquals(expected, actual);
    }
}