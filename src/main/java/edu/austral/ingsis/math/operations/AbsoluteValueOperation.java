package edu.austral.ingsis.math.operations;

public class AbsoluteValueOperation implements Operation {
  @Override
  public Double resolve(Number a, Number b) {
    return Math.abs(a.doubleValue());
  }

  @Override
  public String getRepresentation() {
    return "|";
  }
}
