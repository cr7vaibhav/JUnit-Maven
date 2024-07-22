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

## Create the Grader Class

Create a `Grader` class in `src/main/java`:

```java
public class Grader {
    
    public char determineLetterGrade(int numberGrade) {
        if (numberGrade < 0) {
            throw new IllegalArgumentException("Number grade cannot be negative");
        } else if (numberGrade < 60) {
            return 'F';
        } else if (numberGrade < 70) {
            return 'D';
        } else if (numberGrade < 80) {
            return 'C';
        } else if (numberGrade < 90) {
            return 'B';
        } else {
            return 'A';
        }
    }
}
```

## Create Unit Test for the Grader Class

In `src/test/java`, create a test class for `Grader`:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraderTest {

    @Test
    void fiftyNineShouldReturnF() {
        var grader = new Grader();
        assertEquals('F', grader.determineLetterGrade(59));
    }

    @Test
    void sixtyNineShouldReturnD() {
        var grader = new Grader();
        assertEquals('D', grader.determineLetterGrade(69));
    }

    @Test
    void seventyNineShouldReturnC() {
        var grader = new Grader();
        assertEquals('C', grader.determineLetterGrade(79));
    }

    @Test
    void eightyNineShouldReturnB() {
        var grader = new Grader();
        assertEquals('B', grader.determineLetterGrade(89));
    }

    @Test
    void ninetyShouldReturnA() {
        var grader = new Grader();
        assertEquals('A', grader.determineLetterGrade(90));
    }

    @Test
    void negativeOneShouldReturnIllegalArgumentException() {
        var grader = new Grader();
        assertThrows(IllegalArgumentException.class,
                () -> grader.determineLetterGrade(-1));
    }
}
```

### Running Tests with Coverage

Run the tests with coverage to see how much of your code is being tested. For example, right-click the play button and select "Run test with coverage":

![Run Test with Coverage](https://prod-files-secure.s3.us-west-2.amazonaws.com/b82f9a48-cfed-47d2-b9b0-9d52a734b8bd/90d19d33-da69-4926-a158-7f66238fe3fd/Untitled.png)

This will show you the coverage report:

![Coverage Report](https://prod-files-secure.s3.us-west-2.amazonaws.com/b82f9a48-cfed-47d2-b9b0-9d52a734b8bd/93d3baec-4a3d-482c-b1fd-37e6975083a1/Untitled.png)

### Edge Cases

Cover edge cases in your tests. For example, if you accidentally write `else if (numberGrade < 81)` instead of `else if (numberGrade < 80)`, some tests might still pass:

```java
public char determineLetterGrade(int numberGrade) {
    if (numberGrade < 0) {
        throw new IllegalArgumentException("Number grade cannot be negative");
    } else if (numberGrade < 60) {
        return 'F';
    } else if (numberGrade < 70) {
        return 'D';
    } else if (numberGrade < 80) {
        return 'C';
    } else if (numberGrade < 81) { // Mistake
        return 'B';
    } else {
        return 'A';
    }
}
```

To catch this mistake, add a test for 80:

```java
@Test
void eightyShouldReturnB() {
    var grader = new Grader();
    assertEquals('B', grader.determineLetterGrade(80));
}
```

### Handling Exceptions

If a code throws an exception, it will automatically fail your unit test. Use `assertThrows()` to test exception cases:

```java
@Test
void negativeOneShouldReturnIllegalArgumentException() {
    var grader = new Grader();
    assertThrows(IllegalArgumentException.class,
            () -> grader.determineLetterGrade(-1));
}
```

## Reasons to Write Unit Tests

1. **Ensure Code Correctness**: Unit tests help ensure your code is working as expected.
2. **Confidence in Refactoring**: With comprehensive unit tests, you can refactor your code confidently, knowing that any issues will be caught by the tests.

---

