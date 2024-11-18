import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
public class ShapeClassifierTest {

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
    public void testLineSmallEven() {
        ShapeClassifier sc = new ShapeClassifier();
        String result = sc.evaluateGuess("Line,Small,Yes,5");
        assertEquals("Yes", result);
    }

    @Test
    public void testRectangleLargeOdd() {
        ShapeClassifier sc = new ShapeClassifier();
        String result = sc.evaluateGuess("Rectangle,Large,No,100,100,100,100");
        assertEquals("Yes", result);
    }

    @Test
    public void testInvalidShape() {
        ShapeClassifier sc = new ShapeClassifier();
        String result = sc.evaluateGuess("Hexagon,Large,Yes,10,10,10,10,10,10");
        assertTrue(result.startsWith("No"));
    }

    @Test
    public void testWrongSizeGuess() {
        ShapeClassifier sc = new ShapeClassifier();
        String result = sc.evaluateGuess("Circle,Medium,Yes,50,50");
        assertEquals("No: Wrong Size", result);
    }

    @Test
    public void testSquareMisclassified() {
        ShapeClassifier sc = new ShapeClassifier();
        String result = sc.evaluateGuess("Square,Small,Yes,3,3,3,3");
        assertEquals("No: Suggestion=Rectangle", result);
    }




}
