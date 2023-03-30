package fer.oop.rekapitulacija.zad1;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    private static int gcd(int numerator, int denominator) {
        return (denominator == 0) ? numerator : gcd(denominator, numerator % denominator);
    }

    public Fraction invert() {
        return new Fraction(this.denominator, this.numerator);
    }

    public Fraction negate() {
        return new Fraction(-this.numerator, this.denominator);
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator / gcd(newNumerator, newDenominator), newDenominator / gcd(newNumerator, newDenominator));
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator / gcd(newNumerator, newDenominator), newDenominator / gcd(newNumerator, newDenominator));
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator / gcd(newNumerator, newDenominator), newDenominator / gcd(newNumerator, newDenominator));
    }

    public Fraction divide(Fraction other) {
        return multiply(new Fraction(other.denominator, other.numerator));
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        if (denominator < 0 || numerator < 0) {
            return "-" + Math.abs(numerator) + "/" + Math.abs(denominator);
        }
        return numerator + "/" + denominator;
    }
}
