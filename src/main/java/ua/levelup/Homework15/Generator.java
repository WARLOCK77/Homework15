package ua.levelup.Homework15;

public interface Generator<T extends Number>{
    T getNextRand();
    Class<T> getType();
}
