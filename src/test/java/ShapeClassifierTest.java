import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeClassifierTest {

    /**
     * This is an example test 
     */
    @Test
    public void testCorrectGuessForEquilateralTriangle() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Equilateral,Large,Yes,100,100,100";
        String output = classifier.evaluateGuess(input);
        assertEquals("Yes", output);
    }

    @Test
    public void testIncorrectShapeGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Rectangle,Small,No,3,3,3";
        String output = classifier.evaluateGuess(input);
        assertTrue(output.contains("No"));
        assertTrue(output.contains("Suggestion=Equilateral"));
    }

    @Test
    public void testIncorrectSizeGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Circle,Small,Yes,20,20";
        String output = classifier.evaluateGuess(input);
        assertTrue(output.contains("Wrong Size"));
    }

    @Test
    public void testIncorrectEvenOddGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Circle,Large,No,30,30";
        String output = classifier.evaluateGuess(input);
        assertTrue(output.contains("Wrong Even/Odd"));
    }

    @Test
    public void testMultipleIncorrectGuesses() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Square,Small,No,10,20,30,40";
        String output = classifier.evaluateGuess(input);
        assertTrue(output.contains("Wrong Size"));
        assertTrue(output.contains("Wrong Even/Odd"));
    }

    @Test
    public void testErrorOnThreeBadGuesses() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Rectangle,Large,Yes,3,3";
        classifier.evaluateGuess(input);
        classifier.evaluateGuess(input);
        String output = classifier.evaluateGuess(input);
        assertTrue(output.contains("ERROR: Bad guess limit Exceeded"));
    }

    @Test
    public void testEllipseClassification() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Ellipse,Large,Yes,50,30";
        String output = classifier.evaluateGuess(input);
        assertEquals("Yes", output);
    }

    @Test
    public void testRectangleClassification() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Rectangle,Small,No,10,20,10,20";
        String output = classifier.evaluateGuess(input);
        assertEquals("Yes", output);
    }

    @Test
    public void testSquareClassification() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Square,Large,Yes,50,50,50,50";
        String output = classifier.evaluateGuess(input);
        assertEquals("Yes", output);
    }

    @Test
    public void testLineClassification() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Line,Small,No,5";
        String output = classifier.evaluateGuess(input);
        assertEquals("Yes", output);
    }
}
