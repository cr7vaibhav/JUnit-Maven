# JUnit Testing with Maven


Used CodingWithJohn video on JUnit testing to learn to set up a Maven project, add JUnit dependency, and create unit tests.

## Create a Maven Project

Create a new Maven project. You can do this using your favorite IDE or from the command line.

## Add JUnit Dependency

In your `pom.xml` file, add the latest Maven dependency for JUnit:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.11.0-M2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Create the Calculator Class

Create a `SimpleCalculator` class in `src/main/java`:

```java
public class SimpleCalculator {
    public int add(int numberA, int numberB) {
        return numberA + numberB;
    }
}
```

## Create Unit Test for the Calculator Class

In `src/test/java`, create a test class for `SimpleCalculator`:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {

    @Test
    void twoPlusTwoShouldEqualFour() {
        SimpleCalculator sc = new SimpleCalculator(); 
        assertEquals(4, sc.add(2, 2)); 
    }
}
```

### Running the Tests

Run the tests by clicking on the play button next to the test method or the test class in your IDE.

If there are no mistakes, all tests should pass:

![image](https://github.com/user-attachments/assets/081a696a-7f00-4b06-b20d-4b3451099580)


### Example of a Failing Test

If your code is doing the wrong thing, such as subtracting instead of adding:

```java
public int add(int numberA, int numberB) {
    return numberA - numberB;
}
```

The test will fail:

![image](https://github.com/user-attachments/assets/c58ae4f4-a884-4ea2-b824-d68a8fe2523f)


## Importance of Multiple Unit Tests

Having only one unit test can be problematic. For example, if your method accidentally uses multiplication instead of addition:

```java
public int add(int numberA, int numberB) {
    return numberA * numberB;
}
```

A single test case, such as `2 * 2`, will still pass. Therefore, multiple unit tests are necessary to ensure comprehensive coverage:

```java
@Test
void twoPlusTwoShouldEqualFour() {
    SimpleCalculator sc = new SimpleCalculator();
    assertEquals(4, sc.add(2, 2));
}

@Test
void threePlusSevenShouldEqualTen() {
    SimpleCalculator sc = new SimpleCalculator();
    assertEquals(10, sc.add(3, 7));
}
```

Running all tests will help identify mistakes in your code:

![image](https://github.com/user-attachments/assets/64df8e1f-50cb-40aa-87b0-6d2c3fdd6336)


This helps you identify and fix issues, ensuring your code is functioning correctly.

## Other Assert Statements

JUnit provides various assert statements:

```java
 assertNotEquals(sc, sc); //passes if not equal, fails if equal
 assertTrue(sc.add(2,2)== 4);//passes if true, fails if false
 assertFalse(null);
 assertNull(sc);
 assertNotNull(sc);
```

---

By following this guide, you can set up unit tests for your Java applications using JUnit and Maven, ensuring your code is reliable and bug-free.
