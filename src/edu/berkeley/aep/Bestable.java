package edu.berkeley.aep;

//Understand if the given type is bestable
public interface Bestable<T> {
    boolean betterThan(T other);
}