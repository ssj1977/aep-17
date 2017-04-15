package edu.berkeley.aep;

// Understand the probability of
public class Chance implements Bestable<Chance> {
    private final double probability;
    public Chance (double probability){
        this.probability = probability;
    }
    public Chance not(){ return new Chance (1d-this.probability); }

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof Chance)) return false;
        return Double.compare(probability, ((Chance) other).probability)==0;
    }

    @Override
    public int hashCode() {
        //long longBits = Double.doubleToLongBits(probability);
        //return (int) (longBits ^ (longBits >>> 32));
        //OR
        return Double.hashCode(probability);
    }

    @Override
    public boolean betterThan(Chance other) {
        return probability > other.probability;
    }


    static public Chance andStatic(Chance chance1, Chance chance2){
        return new Chance (chance1.probability * chance2.probability);
    }

    public Chance and(Chance other) {
        return new Chance (this.probability * other.probability);
    }


    public Chance or(Chance other) {
        //By De Morgan's Law : P (A||B) = !(!P(A) && !P(B))
        //return this.not().and(other.not()).not();
        return Chance.andStatic(this.not(), other.not()).not();
        // P ( A || B) = P(A) + P(B) - (P(A) * P(B))
        //return new Chance (this.probability + other.probability - (this.probability * other.probability));
    }
}
