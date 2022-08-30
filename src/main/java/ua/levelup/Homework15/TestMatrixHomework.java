package ua.levelup.Homework15;

import ua.levelup.Homework15.annotation.MatrixProperties;
import ua.levelup.Homework15.annotation.MatrixProperty;

import java.lang.reflect.Method;

public class TestMatrixHomework {


    @MatrixProperty(type = IntegerGenerator.class, rows=3, column=3)
    @MatrixProperty(type = DoubleGenerator.class, rows=3, column=2)
    public <T extends Number> void testMatrix1(Generator<T> generator, int rows, int columns) {
        Matrix<T> matrix = new Matrix<>(generator,rows,columns);
        matrix.print();
    }


    public static void main(String[] args) {
        TestMatrixHomework testMatrixHomework = new TestMatrixHomework();
        testMatrix(testMatrixHomework);
    }

    public static void testMatrix(Object object) {
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            MatrixProperties matrixProperties = method.getAnnotation(MatrixProperties.class);
            if (matrixProperties == null) {
                continue;
            }
            for (MatrixProperty matrixProperty : matrixProperties.value()){
                try {
                    Generator<?> generator=matrixProperty.type().getDeclaredConstructor().newInstance();
                    method.invoke(object, generator, matrixProperty.rows(), matrixProperty.column());
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}