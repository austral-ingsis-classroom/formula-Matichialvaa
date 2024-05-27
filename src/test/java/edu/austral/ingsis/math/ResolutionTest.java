package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.functions.Constant;
import edu.austral.ingsis.math.functions.SimpleOperationFunction;
import edu.austral.ingsis.math.operations.*;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Constant constant1 = new Constant(1);
    Constant constant6 = new Constant(6);
    SimpleOperationFunction simpleOperationFunction =
        new SimpleOperationFunction(constant1, constant6, new SumOperation());

    final Double result = simpleOperationFunction.evaluate().doubleValue();

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Constant constant12 = new Constant(12);
    Constant constant2 = new Constant(2);
    SimpleOperationFunction simpleOperationFunction =
        new SimpleOperationFunction(constant12, constant2, new DivOperation());

    final Double result = simpleOperationFunction.evaluate().doubleValue();

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Constant constant9 = new Constant(9);
    Constant constant2 = new Constant(2);
    SimpleOperationFunction divideOperation =
        new SimpleOperationFunction(constant9, constant2, new DivOperation());
    Constant constant3 = new Constant(3);
    SimpleOperationFunction multiplyOperation =
        new SimpleOperationFunction(divideOperation, constant3, new MultiplyOperation());

    final Double result = multiplyOperation.evaluate().doubleValue();

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Constant constant27 = new Constant(27);
    Constant constant6 = new Constant(6);
    SimpleOperationFunction divideOperation =
        new SimpleOperationFunction(constant27, constant6, new DivOperation());
    Constant constant2 = new Constant(2);
    SimpleOperationFunction powerOperation =
        new SimpleOperationFunction(divideOperation, constant2, new PowerOperation());

    final Double result = powerOperation.evaluate().doubleValue();

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Constant constant36 = new Constant(36);
    SimpleOperationFunction sqrtOperation =
        new SimpleOperationFunction(constant36, new Constant(0.5), new PowerOperation());

    final Double result = sqrtOperation.evaluate().doubleValue();

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Constant constant136 = new Constant(136);
    SimpleOperationFunction absoluteValueOperation =
        new SimpleOperationFunction(constant136, new Constant(0), new AbsoluteValueOperation());

    final Double result = absoluteValueOperation.evaluate().doubleValue();

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Constant constantNeg136 = new Constant(-136);
    SimpleOperationFunction absoluteValueOperation =
        new SimpleOperationFunction(constantNeg136, new Constant(0), new AbsoluteValueOperation());

    final Double result = absoluteValueOperation.evaluate().doubleValue();

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Constant constant5a = new Constant(5);
    Constant constant5b = new Constant(5);
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(constant5a, constant5b, new SubtractOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction multiplyOperation =
        new SimpleOperationFunction(subtractOperation, constant8, new MultiplyOperation());

    final Double result = multiplyOperation.evaluate().doubleValue();

    assertThat(result, equalTo(0d));
  }
}
