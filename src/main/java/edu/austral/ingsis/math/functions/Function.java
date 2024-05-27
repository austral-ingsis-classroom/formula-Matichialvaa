package edu.austral.ingsis.math.functions;

import java.util.List;
import java.util.Map;

public interface Function {
  Number evaluate();

  Number evaluate(Map<String, Number> variableValues);

  String getRepresentation();

  List<String> getVariables();
}
