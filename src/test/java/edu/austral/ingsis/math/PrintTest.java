package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.functions.Constant;
import edu.austral.ingsis.math.functions.SimpleOperationFunction;
import edu.austral.ingsis.math.functions.Variable;
import edu.austral.ingsis.math.operations.*;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    Constant constant1 = new Constant(1);
    Constant constant2 = new Constant(6);
    SimpleOperationFunction simpleOperationFunction =
        new SimpleOperationFunction(constant1, constant2, new SumOperation());
    assertThat(simpleOperationFunction.getRepresentation(), equalTo("1 + 6"));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    Constant constant12 = new Constant(12);
    Constant constant2 = new Constant(2);
    SimpleOperationFunction simpleOperationFunction =
        new SimpleOperationFunction(constant12, constant2, new DivOperation());

    final String expected = "12 / 2";
    final String result = simpleOperationFunction.getRepresentation();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    Constant constant9 = new Constant(9);
    Constant constant2 = new Constant(2);
    SimpleOperationFunction divideOperation =
        new SimpleOperationFunction(constant9, constant2, new DivOperation());
    Constant constant3 = new Constant(3);
    SimpleOperationFunction multiplyOperation =
        new SimpleOperationFunction(divideOperation, constant3, new MultiplyOperation());

    final String expected = "(9 / 2) * 3";
    final String result = multiplyOperation.getRepresentation();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    Constant constant27 = new Constant(27);
    Constant constant6 = new Constant(6);
    SimpleOperationFunction divideOperation =
        new SimpleOperationFunction(constant27, constant6, new DivOperation());
    Constant constant2 = new Constant(2);
    SimpleOperationFunction powerOperation =
        new SimpleOperationFunction(divideOperation, constant2, new PowerOperation());

    final String expected = "(27 / 6) ^ 2";
    final String result = powerOperation.getRepresentation();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    Variable variableValue = new Variable("value");
    SimpleOperationFunction absoluteValueOperation =
        new SimpleOperationFunction(variableValue, new Constant(0), new AbsoluteValueOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(absoluteValueOperation, constant8, new SubtractOperation());

    final String expected = "|value| - 8";
    final String result = subtractOperation.getRepresentation();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    Variable variableValue = new Variable("value");
    SimpleOperationFunction absoluteValueOperation =
        new SimpleOperationFunction(variableValue, new Constant(0), new AbsoluteValueOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(absoluteValueOperation, constant8, new SubtractOperation());

    final String expected = "|value| - 8";
    final String result = subtractOperation.getRepresentation();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    Constant constant5 = new Constant(5);
    Variable variableI = new Variable("i");
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(constant5, variableI, new SubtractOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction multiplyOperation =
        new SimpleOperationFunction(subtractOperation, constant8, new MultiplyOperation());

    final String expected = "(5 - i) * 8";
    final String result = multiplyOperation.getRepresentation();

    assertThat(result, equalTo(expected));
  }
}
