import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeClassifierTestClaude {

    @ParameterizedTest
    @CsvSource({
            // Valid Cases
            "'Line,Small,Yes,1', 'Yes'", 
            "'Circle,Small,Yes,5,5', 'Yes'", 
            "'Equilateral,Small,Yes,3,3,3', 'Yes'", 
            "'Rectangle,Large,No,20,20,20,20', 'Yes'", 
            "'Square,Large,Yes,50,50,50,50', 'Yes'", 
            "'Isosceles,Large,No,10,10,5', 'Yes'", 
            "'Scalene,Large,Yes,10,11,12', 'Yes'", 

            // Invalid Cases
            "'Ellipse,Small,No,6,7', 'Wrong Even/Odd'", 
            "'Rectangle,Large,Yes,-1,-1,-1,-1', 'No'", 
            "'Polygon,Small,Yes,5,5,5', 'No: Suggestion=Triangle'", 
            "'Circle,Medium,Yes,10', 'No'", 
            "'Ellipse,Small,Maybe,4,3', 'No'"
    })
    void testEvaluateGuess(String input, String expectedOutput) {
        ShapeClassifier classifier = new ShapeClassifier();
        assertEquals(expectedOutput, classifier.evaluateGuess(input));
    }
}