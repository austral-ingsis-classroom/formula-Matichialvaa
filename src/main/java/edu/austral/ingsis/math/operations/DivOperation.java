package edu.austral.ingsis.math.operations;

public class DivOperation implements Operation {
  @Override
  public Double resolve(Number a, Number b) {
    if (b.doubleValue() == 0) throw new ArithmeticException("división por cero");
    return a.doubleValue() / b.doubleValue();
  }

  @Override
  public String getRepresentation() {
    return "/";
  }
}
