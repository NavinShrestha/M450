# JUnit 5 Features: Zusammenfassung und Anwendungsfälle

JUnit 5 ist das aktuelle Framework für Unit-Tests in Java und bietet eine Vielzahl von Features, um Tests effizient zu schreiben und zu organisieren. Hier sind die gängigsten JUnit 5 Features mit Anwendungsbeispielen:

## 1. @Test Annotation
Die `@Test`-Annotation kennzeichnet eine Methode als Testmethode. JUnit erkennt und führt alle Methoden mit dieser Annotation während des Testlaufs aus.

### Anwendungsfall:

@Test
void add() {
    assertEquals(5, Calculator.add(2, 3), "Addition of 2 and 3 should be 5");
}
```

## 2. Assertions
JUnit bietet mehrere Assertions, um zu überprüfen, ob das tatsächliche Verhalten mit dem erwarteten Verhalten übereinstimmt.

### Anwendungsfälle:
- **`assertEquals(expected, actual)`**: Überprüft, ob zwei Werte gleich sind.
- **`assertThrows(exceptionClass, executable)`**: Erwartet, dass eine bestimmte Exception geworfen wird.

```java
@Test
void subtract() {
    assertEquals(1, Calculator.subtract(3, 2), "Subtraction of 3 and 2 should be 1");
}

@Test
void divide() {
    assertThrows(ArithmeticException.class, () -> Calculator.divide(6, 0), "Division by 0 should throw ArithmeticException");
}
```

## 3. @BeforeEach und @AfterEach
- `@BeforeEach`: Wird vor jeder Testmethode ausgeführt, um z.B. Testdaten vorzubereiten.
- `@AfterEach`: Wird nach jeder Testmethode ausgeführt, um z.B. Ressourcen freizugeben.

### Anwendungsfall:
```java
@BeforeEach
void setup() {
    calculator = new Calculator();
}

@AfterEach
void teardown() {
    calculator = null; // Freigeben von Ressourcen
}
```

## 4. @BeforeAll und @AfterAll
- `@BeforeAll`: Wird einmal vor allen Tests in der Klasse ausgeführt (nützlich für einmalige Setup-Aufgaben).
- `@AfterAll`: Wird einmal nach allen Tests ausgeführt (nützlich für Aufräumarbeiten nach Tests).

### Anwendungsfall:
```java
@BeforeAll
static void init() {
    System.out.println("Einmaliger Setup vor allen Tests");
}

@AfterAll
static void cleanup() {
    System.out.println("Aufräumen nach allen Tests");
}
```

## 5. Testausführung mit `assertAll`
Mit `assertAll` können mehrere Assertions in einer Methode gruppiert werden. Dies ermöglicht es, alle Assertions in einer Gruppe auszuführen, auch wenn eine fehlschlägt.

### Anwendungsfall:
```java
@Test
void performOperation() {
    assertAll(
        () -> assertEquals(5, Calculator.performOperation(2, 3, '+')),
        () -> assertEquals(1, Calculator.performOperation(3, 2, '-')),
        () -> assertEquals(6, Calculator.performOperation(2, 3, '*')),
        () -> assertEquals(2, Calculator.performOperation(6, 3, '/'))
    );
}
```

## 6. Exception Handling: `assertThrows`
Mit `assertThrows` können Ausnahmen getestet werden, indem erwartet wird, dass eine bestimmte Exception geworfen wird.

### Anwendungsfall:
```java
@Test
void testDivisionByZero() {
    assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
}
```

## 7. @Disabled Annotation
Mit der `@Disabled`-Annotation können einzelne Tests oder ganze Testklassen vorübergehend deaktiviert werden.

### Anwendungsfall:
```java
@Disabled("Feature in Entwicklung")
@Test
void testNewFeature() {
    // Testcode
}
```

## 8. Parametrisierte Tests
JUnit 5 bietet die Möglichkeit, Tests mit verschiedenen Eingabewerten zu parametrisieren.

### Anwendungsfall mit `@ParameterizedTest` und `@ValueSource`:
```java
@ParameterizedTest
@ValueSource(ints = { 1, 2, 3, 4, 5 })
void testIsPositive(int number) {
    assertTrue(number > 0);
}
```

## 9. Zeitlimit für Tests: `assertTimeout`
Mit `assertTimeout` kann sichergestellt werden, dass Tests innerhalb eines bestimmten Zeitrahmens abgeschlossen werden.

### Anwendungsfall:
```java
@Test
void testWithTimeout() {
    assertTimeout(Duration.ofMillis(100), () -> {
        // Code der innerhalb von 100 ms ausgeführt werden muss
    });
}
```

## 10. Nested Tests
Mit der `@Nested`-Annotation können Tests innerhalb von Tests strukturiert werden. Dies ist nützlich, um Tests logisch zu gruppieren.

### Anwendungsfall:
```java
@Nested
class AdditionTests {
    @Test
    void testPositiveNumbers() {
        assertEquals(5, Calculator.add(2, 3));
    }
    
    @Test
    void testNegativeNumbers() {
        assertEquals(-5, Calculator.add(-2, -3));
    }
}
```

## Referenz
Für detailliertere Informationen und eine komplette Referenz besuchen Sie [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/).
```

### Erklärung:
- **@Test Annotation** markiert Testmethoden.
- **Assertions** wie `assertEquals`, `assertThrows` prüfen das Verhalten des Codes.
- **@BeforeEach / @AfterEach** dienen der Vorbereitung und Nachbearbeitung jedes Tests.
- **@BeforeAll / @AfterAll** führen einmalige Setup- und Aufräumaufgaben vor bzw. nach allen Tests durch.
- **assertAll** erlaubt Gruppierung mehrerer Assertions.
- **@Disabled** deaktiviert vorübergehend Tests.
- **Parametrisierte Tests** ermöglichen das Testen mit verschiedenen Eingabewerten.
- **Zeitlimits** helfen bei Performance-Tests.

Diese Zusammenfassung deckt die wichtigsten Funktionen von JUnit 5 ab, die für Unit-Tests in Java genutzt werden können.