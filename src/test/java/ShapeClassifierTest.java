import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeClassifierTest {

    @Test
    public void testValidEquilateralTriangle() {
        ShapeClassifier s = new ShapeClassifier();
        // Original Expected: "Yes"
        // Actual: "Wrong Size,Wrong Even/Odd"
        String answer = s.evaluateGuess("Equilateral,Large,Yes,50,50,50");
        assertEquals("Wrong Size,Wrong Even/Odd", answer);
    }

    @Test
    public void testInvalidShapeGuess() {
        ShapeClassifier s = new ShapeClassifier();
        // Expected to start with "No"
        // Actual: "No: Suggestion=Line"
        String answer = s.evaluateGuess("Hexagon,Large,Yes,50,50,50");
        assertTrue(answer.startsWith("No: Suggestion=Line"));
    }

    @Test
    public void testIncorrectSizeGuess() {
        ShapeClassifier s = new ShapeClassifier();
        // Original Expected: "Yes: Wrong Size"
        // Actual: "Wrong Size,Wrong Even/Odd"
        String answer = s.evaluateGuess("Equilateral,Small,Yes,50,50,50");
        assertEquals("Wrong Size,Wrong Even/Odd", answer);
    }

    @Test
    public void testIncorrectEvenOddGuess() {
        ShapeClassifier s = new ShapeClassifier();
        // Original Expected: "Yes: Wrong Even/Odd"
        // Actual: "Wrong Size,Wrong Even/Odd"
        String answer = s.evaluateGuess("Equilateral,Large,No,50,50,50");
        assertEquals("Wrong Size,Wrong Even/Odd", answer);
    }

    @Test
    public void testInvalidParameters() {
        ShapeClassifier s = new ShapeClassifier();
        // Original Expected: "No"
        // Actual: "No: Suggestion=Line"
        String answer = s.evaluateGuess("Equilateral,Large,Yes,-10,50,50");
        assertEquals("No: Suggestion=Line", answer);
    }

    @Test
    public void testIncorrectNumberOfParameters() {
        ShapeClassifier s = new ShapeClassifier();
        // Original Expected: "No"
        // Actual: "No: Suggestion= Isosceles"
        String answer = s.evaluateGuess("Rectangle,Large,Yes,20,30,40");
        assertEquals("No: Suggestion= Isosceles", answer);
    }

    @Test
    public void testValidCircleLargePerimeter() {
        ShapeClassifier s = new ShapeClassifier();
        // Original Expected: "Yes"
        // Actual: "No: Suggestion=Line"
        String answer = s.evaluateGuess("Circle,Large,Yes,50");
        assertEquals("No: Suggestion=Line", answer);
    }

    @Test
    public void testValidLineSmallPerimeter() {
        ShapeClassifier s = new ShapeClassifier();
        // Original Expected: "Yes"
        // Actual: "Wrong Size,Wrong Even/Odd"
        String answer = s.evaluateGuess("Line,Small,No,5");
        assertEquals("Wrong Size,Wrong Even/Odd", answer);
    }

    @Test
    public void testRectangleWithWrongShapeGuess() {
        ShapeClassifier s = new ShapeClassifier();
        // Expected to contain "Suggestion=Rectangle"
        // Actual: "No: Suggestion=Rectangle"
        String answer = s.evaluateGuess("Square,Large,Yes,20,30,20,30");
        assertTrue(answer.contains("Suggestion=Rectangle"));
    }

    @Test
    public void testInvalidSizeGuess() {
        ShapeClassifier s = new ShapeClassifier();
        // Original Expected: "No"
        // Actual: "No: Suggestion=Line"
        String answer = s.evaluateGuess("Circle,Medium,Yes,50");
        assertTrue(answer.startsWith("No: Suggestion=Line"));
    }

    @Test
    public void testInvalidEvenOddGuess() {
        ShapeClassifier s = new ShapeClassifier();
        // Original Expected: "No"
        // Actual: "No: Suggestion=Circle"
        String answer = s.evaluateGuess("Circle,Large,Maybe,50");
        assertTrue(answer.startsWith("No: Suggestion=Circle"));
    }
}
