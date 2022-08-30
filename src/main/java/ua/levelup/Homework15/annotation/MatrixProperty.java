package ua.levelup.Homework15.annotation;

import ua.levelup.Homework15.Generator;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MatrixProperties.class)
public @interface MatrixProperty {
    Class<? extends Generator<?>> type();
    int rows();
    int column();
}