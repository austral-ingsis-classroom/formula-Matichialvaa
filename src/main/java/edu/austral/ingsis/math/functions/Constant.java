package edu.austral.ingsis.math.functions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Constant implements Function {
  Number value;

  public Constant(Number i) {
    this.value = i;
  }

  @Override
  public Number evaluate() {
    return value;
  }

  @Override
  public Number evaluate(Map<String, Number> variableValues) {
    return value;
  }

  @Override
  public String getRepresentation() {
    return value.toString();
  }

  @Override
  public List<String> getVariables() {
    return Collections.emptyList();
  }
}
