package fer.oop.rekapitulacija_2.zad2;

import java.util.function.Predicate;

public class QuadrantPredicate implements Predicate<Pair<? extends Number>> {
    private final boolean first, second, third, fourth;
    private boolean passed;

    public QuadrantPredicate(boolean first, boolean second, boolean third, boolean fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.passed = false;
    }

    @Override
    public boolean test(Pair<? extends Number> pair) {
        if (first && pair.getX().doubleValue() > 0 && pair.getY().doubleValue() > 0) passed = true;
        if (second && pair.getX().doubleValue() < 0 && pair.getY().doubleValue() > 0) passed = true;
        if (third && pair.getX().doubleValue() < 0 && pair.getY().doubleValue() < 0) passed = true;
        if (fourth && pair.getX().doubleValue() > 0 && pair.getY().doubleValue() < 0) passed = true;
        return passed;
    }

    @Override
    public String toString() {
        return "Take points from quadrants 1-4? (" + first + ", " + second + ", " + third + ", " + fourth + ")";
    }
}
