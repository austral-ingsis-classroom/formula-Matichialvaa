package edu.austral.ingsis.math.operations;

public interface Operation {
  Number resolve(Number a, Number b);

  String getRepresentation();
}
