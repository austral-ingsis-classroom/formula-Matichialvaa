package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.functions.Constant;
import edu.austral.ingsis.math.functions.SimpleOperationFunction;
import edu.austral.ingsis.math.functions.Variable;
import edu.austral.ingsis.math.operations.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Constant constant1 = new Constant(1);
    Variable variable = new Variable("x");
    SimpleOperationFunction simpleOperationFunction =
        new SimpleOperationFunction(constant1, variable, new SumOperation());

    Map<String, Number> variableValues = new HashMap<>();
    variableValues.put("x", 3);

    final Double result = simpleOperationFunction.evaluate(variableValues).doubleValue();
    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Constant constant12 = new Constant(12);
    Variable variableDiv = new Variable("div");
    SimpleOperationFunction simpleOperationFunction =
        new SimpleOperationFunction(constant12, variableDiv, new DivOperation());

    Map<String, Number> variableValues = new HashMap<>();
    variableValues.put("div", 4);

    final Double result = simpleOperationFunction.evaluate(variableValues).doubleValue();
    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Constant constant9 = new Constant(9);
    Variable variableX = new Variable("x");
    SimpleOperationFunction divideOperation =
        new SimpleOperationFunction(constant9, variableX, new DivOperation());
    Variable variableY = new Variable("y");
    SimpleOperationFunction multiplyOperation =
        new SimpleOperationFunction(divideOperation, variableY, new MultiplyOperation());

    Map<String, Number> variableValues = new HashMap<>();
    variableValues.put("x", 3);
    variableValues.put("y", 4);

    final Double result = multiplyOperation.evaluate(variableValues).doubleValue();
    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Constant constant27 = new Constant(27);
    Variable variableA = new Variable("a");
    SimpleOperationFunction divideOperation =
        new SimpleOperationFunction(constant27, variableA, new DivOperation());
    Variable variableB = new Variable("b");
    SimpleOperationFunction powerOperation =
        new SimpleOperationFunction(divideOperation, variableB, new PowerOperation());

    Map<String, Number> variableValues = new HashMap<>();
    variableValues.put("a", 9);
    variableValues.put("b", 3);

    final Double result = powerOperation.evaluate(variableValues).doubleValue();
    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Variable variableZ = new Variable("z");
    Constant constant = new Constant(0.5);
    SimpleOperationFunction powerOperation =
        new SimpleOperationFunction(variableZ, constant, new PowerOperation());

    Map<String, Number> variableValues = new HashMap<>();
    variableValues.put("z", 36);

    final Double result = powerOperation.evaluate(variableValues).doubleValue();
    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Variable variableValue = new Variable("value");
    SimpleOperationFunction absoluteValueOperation =
        new SimpleOperationFunction(variableValue, null, new AbsoluteValueOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(absoluteValueOperation, constant8, new SubtractOperation());

    Map<String, Number> variableValues = new HashMap<>();
    variableValues.put("value", 8);

    final Double result = subtractOperation.evaluate(variableValues).doubleValue();
    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Variable variableValue = new Variable("value");
    SimpleOperationFunction absoluteValueOperation =
        new SimpleOperationFunction(variableValue, null, new AbsoluteValueOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(absoluteValueOperation, constant8, new SubtractOperation());

    Map<String, Number> variableValues = new HashMap<>();
    variableValues.put("value", 8);

    final Double result = subtractOperation.evaluate(variableValues).doubleValue();
    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Constant constant5 = new Constant(5);
    Variable variableI = new Variable("i");
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(constant5, variableI, new SubtractOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction multiplyOperation =
        new SimpleOperationFunction(subtractOperation, constant8, new MultiplyOperation());

    Map<String, Number> variableValues = new HashMap<>();
    variableValues.put("i", 2);

    final Double result = multiplyOperation.evaluate(variableValues).doubleValue();
    assertThat(result, equalTo(24d));
  }
}
