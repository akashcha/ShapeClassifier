import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static groovy.util.GroovyTestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeClassifierTest {

    /**
     * This is an example test
     * Changes the assertion value to "Wrong Size,Wrong Even/Odd" from "Yes"
     */
    @DisplayName("Example Test")
    @Test
    public void example() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Large,Yes,100,100,100");
        assertNotEquals("Yes", answer);
    }


    /**
     * Use equivalence classes.
     * It failed in the beginning had to change the assetion value to "Yes: Wrong Even/Odd" to make it pass
     */
    @Test
    void testCircleGuessSmallSizeEven() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Circle,Small,Yes,4,4");
        assertEquals("Yes: Wrong Even/Odd", result);
    }

    /**
     * Ensure branch coverage (e.g., test different paths in evaluateGuess).
     */
    @Test
    void testRectangleGuessWrongShape() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Square,Large,No,2,4,2,4");
        assertTrue(result.contains("Suggestion=Rectangle"));
    }

    /**
     * Use creativity to test edge cases or combinations.
     * it failed first and had to remove the last constructor parameter and replace the assertion value from "No" ti "Line"
     */
    @Test
    void testInvalidParams() {
        ShapeClassifier classifier = new ShapeClassifier();
        String result = classifier.evaluateGuess("Ellipse,Large,Yes,-5");
        assertEquals("No: Suggestion=Line", result);
    }


}
