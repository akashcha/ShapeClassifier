import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeClassifierTest {

    @ParameterizedTest
    @CsvSource({
            // Valid Cases
            "'Line,Small,Yes,10', 'Yes'", // Test ID 1
            "'Circle,Small,Yes,5,5', 'Yes'", // Test ID 2
            "'Equilateral,Small,Yes,3,3,3', 'Yes'", // Test ID 4
            "'Rectangle,Large,Yes,20,20,20,20', 'Yes'", // Test ID 5
            "'Square,Large,No,4095,4095,4095,4095', 'Yes'", // Test ID 6

            // Invalid Cases
            "'Ellipse,Small,No,6,7', 'Wrong Even/Odd'", // Test ID 3
            "'Rectangle,Large,Yes,-1,-1,-1,-1', 'No'", // Test ID 7
            "'Polygon,Small,Yes,5,5,5', 'No: Suggestion=Not A Triangle'", // Test ID 8
            "'Circle,Medium,Yes,10', 'No'", // Test ID 9
            "'Ellipse,Small,Maybe,4,3', 'No'" // Test ID 10
    })
    void testEvaluateGuess(String input, String expectedOutput) {
        ShapeClassifier classifier = new ShapeClassifier();
        assertEquals(expectedOutput, classifier.evaluateGuess(input));
    }
}
