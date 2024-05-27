package edu.austral.ingsis.math.operations;

public class PowerOperation implements Operation {
  @Override
  public Double resolve(Number a, Number b) {
    return Math.pow(a.doubleValue(), b.doubleValue());
  }

  @Override
  public String getRepresentation() {
    return "^";
  }
}
