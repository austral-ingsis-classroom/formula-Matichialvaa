package edu.austral.ingsis.math.operations;

public class SubtractOperation implements Operation {
  @Override
  public Double resolve(Number a, Number b) {
    return a.doubleValue() - b.doubleValue();
  }

  @Override
  public String getRepresentation() {
    return "-";
  }
}
