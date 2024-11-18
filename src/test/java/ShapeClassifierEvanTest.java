import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShapeClassifierEvanTest {

    /**
     * This is an example test 
     */
    @DisplayName("Example Test")
    @Test
    public void example() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Large,Yes,100,100,100");
        assertNotEquals("Yes", answer);
    }

    @Test
    public void testCase1_AllGuessesCorrect() {
        ShapeClassifier sc = new ShapeClassifier();
        String input = "Square,Large,Yes,100,100,100,100";
        String expectedOutput = "Yes";
        String actualOutput = sc.evaluateGuess(input);
        assertEquals(expectedOutput, actualOutput, "Test Case 1 Failed");
    }

    @Test
    public void testCase2_IncorrectSizeGuess() {
        ShapeClassifier sc = new ShapeClassifier();
        String input = "Circle,Small,Yes,50,50";
        String expectedOutput = "Yes: Wrong Size";
        String actualOutput = sc.evaluateGuess(input);
        assertEquals(expectedOutput, actualOutput, "Test Case 2 Failed");
    }

    @Test
    public void testCase3_IncorrectEvenOddGuess() {
        ShapeClassifier sc = new ShapeClassifier();
        String input = "Line,Small,No,5";
        String expectedOutput = "Yes: Wrong Even/Odd";
        String actualOutput = sc.evaluateGuess(input);
        assertEquals(expectedOutput, actualOutput, "Test Case 3 Failed");
    }

    @Test
    public void testCase4_IncorrectShapeGuessWithSuggestion() {
        ShapeClassifier sc = new ShapeClassifier();
        String input = "Ellipse,Large,Yes,100,100";
        String expectedOutput = "No: Suggestion=Circle";
        String actualOutput = sc.evaluateGuess(input);
        assertEquals(expectedOutput, actualOutput, "Test Case 4 Failed");
    }

    @Test
    public void testCase5_CompletelyInvalidInputs() {
        ShapeClassifier sc = new ShapeClassifier();
        String input = "Hexagon,Medium,Maybe,10,10,10,10,10,10";
        String expectedOutput = "No";
        String actualOutput = sc.evaluateGuess(input);
        assertEquals(expectedOutput, actualOutput, "Test Case 5 Failed");
    }

    // Boundary Value Analysis Test Cases

    @Test
    public void testCase6_PerimeterEquals10_BoundaryForSmallSize() {
        ShapeClassifier sc = new ShapeClassifier();
        String input = "Equilateral,Small,Yes,3,3,4";
        String expectedOutput = "Yes: Wrong Size";
        String actualOutput = sc.evaluateGuess(input);
        assertEquals(expectedOutput, actualOutput, "Test Case 6 Failed");
    }

    @Test
    public void testCase7_PerimeterIs9_MaxSmallSize() {
        ShapeClassifier sc = new ShapeClassifier();
        String input = "Equilateral,Small,No,3,3,3";
        String expectedOutput = "Yes";
        String actualOutput = sc.evaluateGuess(input);
        assertEquals(expectedOutput, actualOutput, "Test Case 7 Failed");
    }

}
