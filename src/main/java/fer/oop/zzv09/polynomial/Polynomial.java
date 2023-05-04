package fer.oop.zzv09.polynomial;

import java.util.*;

public class Polynomial {
    private List<Integer> coefficients, exponents;

    public Polynomial(List<Integer> coefficients, List<Integer> exponents) {
        this.coefficients = coefficients;
        this.exponents = exponents;
    }

    public Polynomial(int... args) {
        this.coefficients = new ArrayList<>();
        this.exponents = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0) {
                coefficients.add(args[i]);
            } else {
                exponents.add(args[i]);
            }
        }
        for (int i = 0; i < exponents.size(); i++) {
            for (int j = i; j < exponents.size(); j++) {
                if (exponents.get(i) < exponents.get(j)) {
                    Collections.swap(exponents, i, j);
                    Collections.swap(coefficients, i, j);
                }
            }
        }
    }

    public List<Integer> getCoefficients() {
        return coefficients;
    }

    public List<Integer> getExponents() {
        return exponents;
    }

    public Polynomial plus(Polynomial other) {
        List<Integer> newCoefficients = new ArrayList<>(this.getCoefficients());
        Set<Integer> newExponentsSet = new LinkedHashSet<>(this.getExponents());
        for (Integer i : other.getExponents()) {
            int index = other.getExponents().indexOf(i);
            if (newExponentsSet.add(i)) {
                newCoefficients.add(other.getCoefficients().get(index));
            } else {
                List<Integer> temp = new ArrayList<>(newExponentsSet);
                int indexT = temp.indexOf(i);
                newCoefficients.set(indexT, newCoefficients.get(indexT) + other.getCoefficients().get(index));
            }
        }
        List<Integer> newExponents = new ArrayList<>(newExponentsSet);
        for (int i = 0; i < newExponents.size(); i++) {
            for (int j = i; j < newExponents.size(); j++) {
                if (newExponents.get(i) < newExponents.get(j)) {
                    Collections.swap(newExponents, i, j);
                    Collections.swap(newCoefficients, i, j);
                }
            }
        }
        return new Polynomial(newCoefficients, newExponents);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coefficients.size(); i++) {
            int c = coefficients.get(i);
            int e = exponents.get(i);
            if (c < 0) {
                sb.append(c);
            } else if (c > 0 && c != 1) {
                if (i == 0) sb.append(c);
                else sb.append("+" + c);
            } else if (c != 0 && i != 0) sb.append('+');
            if (c != 0 && e != 0) {
                sb.append('x');
                if (e != 1) {
                    sb.append("^" + e);
                }
            }
        }
        return sb.toString();
    }
}
