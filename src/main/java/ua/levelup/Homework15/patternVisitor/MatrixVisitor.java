package ua.levelup.Homework15.patternVisitor;

import ua.levelup.Homework15.Generator;
import ua.levelup.Homework15.Matrix;
import ua.levelup.Homework15.annotation.MatrixProperties;
import ua.levelup.Homework15.annotation.MatrixProperty;

import java.lang.reflect.Method;

public class MatrixVisitor implements Visitor{

    private final Method method;
    private final Object object;

    public MatrixVisitor(Method method, Object object) {
        this.method=method;
        this.object=object;
    }

    @Override
    public void visit(MatrixProperties matrixProperties) {
        for (MatrixProperty matrixProperty : matrixProperties.value()){
            visit(matrixProperty);
        }
    }

    @Override
    public void visit(MatrixProperty matrixProperty) {
        try {
            Generator<?> generator = matrixProperty.type().getDeclaredConstructor().newInstance();
            method.invoke(object, new Matrix<>(generator, matrixProperty.rows(), matrixProperty.column()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
