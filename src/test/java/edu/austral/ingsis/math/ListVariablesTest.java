package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.functions.Constant;
import edu.austral.ingsis.math.functions.Function;
import edu.austral.ingsis.math.functions.SimpleOperationFunction;
import edu.austral.ingsis.math.functions.Variable;
import edu.austral.ingsis.math.operations.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Constant constant = new Constant(1);
    Constant constant2 = new Constant(6);
    SimpleOperationFunction simpleOperationFunction =
        new SimpleOperationFunction(constant, constant2, new SumOperation());
    final List<String> result = simpleOperationFunction.getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Constant constant = new Constant(12);
    Variable variable = new Variable("div");
    SimpleOperationFunction simpleOperationFunction =
        new SimpleOperationFunction(constant, variable, new DivOperation());
    final List<String> result = simpleOperationFunction.getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function const9 = new Constant(9);
    Function variableX = new Variable("x");
    Function divide = new SimpleOperationFunction(const9, variableX, new DivOperation());
    Function variableY = new Variable("y");
    Function function = new SimpleOperationFunction(divide, variableY, new MultiplyOperation());

    List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Constant constant = new Constant(27);
    Variable variableA = new Variable("a");
    SimpleOperationFunction divideOperation =
        new SimpleOperationFunction(constant, variableA, new DivOperation());
    Variable variableB = new Variable("b");
    SimpleOperationFunction powerOperation =
        new SimpleOperationFunction(divideOperation, variableB, new PowerOperation());

    final List<String> result = powerOperation.getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Variable variableZ = new Variable("z");
    Constant constantHalf = new Constant(0.5);
    SimpleOperationFunction powerOperation =
        new SimpleOperationFunction(variableZ, constantHalf, new PowerOperation());

    final List<String> result = powerOperation.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Variable variableValue = new Variable("value");
    SimpleOperationFunction absoluteValueOperation =
        new SimpleOperationFunction(variableValue, null, new AbsoluteValueOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(absoluteValueOperation, constant8, new SubtractOperation());

    final List<String> result = subtractOperation.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Variable variableValue = new Variable("value");
    SimpleOperationFunction absoluteValueOperation =
        new SimpleOperationFunction(variableValue, null, new AbsoluteValueOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(absoluteValueOperation, constant8, new SubtractOperation());

    final List<String> result = subtractOperation.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Constant constant5 = new Constant(5);
    Variable variableI = new Variable("i");
    SimpleOperationFunction subtractOperation =
        new SimpleOperationFunction(constant5, variableI, new SubtractOperation());
    Constant constant8 = new Constant(8);
    SimpleOperationFunction multiplyOperation =
        new SimpleOperationFunction(subtractOperation, constant8, new MultiplyOperation());

    final List<String> result = multiplyOperation.getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
