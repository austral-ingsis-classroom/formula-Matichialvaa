package edu.austral.ingsis.math.functions;

import edu.austral.ingsis.math.operations.AbsoluteValueOperation;
import edu.austral.ingsis.math.operations.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleOperationFunction implements Function {
  Function function1;
  Function function2;
  Operation operation;

  public SimpleOperationFunction(Function function1, Function function2, Operation operation) {
    this.function1 = function1;
    this.function2 = function2;
    this.operation = operation;
  }

  @Override
  public Number evaluate() {

    return operation.resolve(function1.evaluate(), function2.evaluate());
  }

  @Override
  public Number evaluate(Map<String, Number> variableValues) {
    if (function2 != null) {
      return operation.resolve(
          function1.evaluate(variableValues), function2.evaluate(variableValues));
    } else {
      return operation.resolve(function1.evaluate(variableValues), 0);
    }
  }

  @Override
  public String getRepresentation() {

    if (operation instanceof AbsoluteValueOperation) {
      return "|" + function1.getRepresentation() + "|";
    } else {
      String function1Representation = function1.getRepresentation();
      if (function1 instanceof SimpleOperationFunction
          && !(((SimpleOperationFunction) function1).operation instanceof AbsoluteValueOperation)) {
        function1Representation = "(" + function1Representation + ")";
      }
      return function1Representation
          + " "
          + operation.getRepresentation()
          + " "
          + function2.getRepresentation();
    }
  }

  @Override
  public List<String> getVariables() {
    List<String> variables = new ArrayList<>();
    if (function1 != null) {
      variables.addAll(function1.getVariables());
    }
    if (function2 != null) {
      variables.addAll(function2.getVariables());
    }
    return variables;
  }
}
