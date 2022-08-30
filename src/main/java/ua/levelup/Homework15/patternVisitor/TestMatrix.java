package ua.levelup.Homework15.patternVisitor;

import ua.levelup.Homework15.DoubleGenerator;
import ua.levelup.Homework15.IntegerGenerator;
import ua.levelup.Homework15.Matrix;
import ua.levelup.Homework15.annotation.MatrixProperties;
import ua.levelup.Homework15.annotation.MatrixProperty;

import java.lang.reflect.Method;

public class TestMatrix {

    @MatrixProperty(type = IntegerGenerator.class, rows=3, column=3)
    @MatrixProperty(type = DoubleGenerator.class, rows=3, column=2)
    public <T extends Number> void testMatrix1(Matrix<T> matrix) {
        matrix.print();
    }

    public static void main(String[] args) {
        TestMatrix testMatrix = new TestMatrix();
        Method[] declaredMethods = testMatrix.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            MatrixProperties matrixProperties = method.getAnnotation(MatrixProperties.class);
            if (matrixProperties == null) {
                continue;
            }
            Visitor visitor=new MatrixVisitor(method, testMatrix);
            visitor.visit(matrixProperties);
        }
    }
}
