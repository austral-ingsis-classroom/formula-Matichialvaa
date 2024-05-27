package edu.austral.ingsis.math.functions;

import java.util.List;
import java.util.Map;

public class Variable implements Function {
  String variable;

  public Variable(String variable) {
    this.variable = variable;
  }

  @Override
  public Number evaluate() {
    throw new RuntimeException("No es posible evaluar sin valor asociado");
  }

  @Override
  public Number evaluate(Map<String, Number> variableValues) {
    return variableValues.get(variable);
  }

  @Override
  public String getRepresentation() {
    return variable;
  }

  @Override
  public List<String> getVariables() {
    return List.of(variable);
  }
}
