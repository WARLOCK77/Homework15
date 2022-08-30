package ua.levelup.Homework15.patternVisitor;

import ua.levelup.Homework15.annotation.MatrixProperties;
import ua.levelup.Homework15.annotation.MatrixProperty;

public interface Visitor {
    void visit(MatrixProperties matrixProperties);
    void visit(MatrixProperty matrixProperty);
}
