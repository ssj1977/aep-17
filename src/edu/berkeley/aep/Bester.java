package edu.berkeley.aep;
//Understand how to find the best value
public class Bester<T extends Bestable<T>> {
    private final T[] quantities;

    public Bester(T... quantities) {
        this.quantities = quantities;
    }

    public T best() {
        T best = quantities[0];
        for (T candidate : quantities) {
            if (candidate.betterThan(best)) {
                best = candidate;
            }
        }
        return best;
    }
}