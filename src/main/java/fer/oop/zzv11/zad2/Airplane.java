package fer.oop.zzv11.zad2;

import fer.oop.zzv10.Pair;

import java.util.LinkedList;
import java.util.List;

public class Airplane {
    private String name;
    private int currentSpeed;
    private List<Cargo> cargo;
    private String from, to;

    public Airplane(String name) {
        this.name = name;
        this.currentSpeed = 0;
        this.cargo = new LinkedList<>();
    }

    private void addCargo(Cargo cargo) {
        this.cargo.add(cargo);
    }

    private void increaseSpeed(int increment) {
        currentSpeed += increment;
    }

    private int getOverallCargoWeight() {
        int sum = 0;
        for (Cargo cargo : this.cargo) {
            sum += cargo.weight;
        }
        return sum;
    }

    private void flyAround(Pair<Double, Double>... airportsCoord) {
        final class Distance {
            private double distance;

            public Distance(Pair<Double, Double> first, Pair<Double, Double> second) {
                double dLat = Math.toRadians(second.getFirst()) - Math.toRadians(first.getFirst());
                double dLon = Math.toRadians(second.getSecond()) - Math.toRadians(first.getSecond());

                // convert to radians
                double lat1 = Math.toRadians(first.getFirst());
                double lat2 = Math.toRadians(second.getFirst());

                // apply formulae
                double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
                ;
                double rad = 6371;
                double c = 2 * Math.asin(Math.sqrt(a));
                this.distance = c * rad;
            }

            public double getDistance() {
                return distance;
            }
        }
        double distance = 0.;
        for (int i = 0; i < airportsCoord.length - 1; i++) {
            distance += new Distance(airportsCoord[i], airportsCoord[i + 1]).getDistance();
        }
        System.out.printf("We have approx %.2f km to our end destination.\n", distance);
    }

    public class Captain {
        private String name;

        public Captain(String name) {
            this.name = name;
        }

        public void sayWelcomeAndPilot(String from, String to) {
            Airplane.this.from = from;
            Airplane.this.to = to;
            for (Cargo cargo : cargo) {
                cargo.checkCargo();
            }
            increaseSpeed(200);
            System.out.printf("This is your captain %s speaking.\n", name);
            System.out.printf("The %s plane on flight from %s to %s is loaded with %d kg.\n", Airplane.this.name, from, to, getOverallCargoWeight());
            System.out.printf("Enjoy your flight. Currently, out speed is %d\n", currentSpeed);
            flyAround(new Pair<>(45.217, 14.570), new Pair<>(45.503, 12.351));
        }
    }

    public static class Cargo {
        private String type;
        private int weight;

        public Cargo(String type, int weight) {
            this.type = type;
            this.weight = weight;
        }

        private void checkCargo() {
            System.out.printf("%s, %d kg, checked.\n", type, weight);
        }
    }

    public static void main(String[] args) {
        Airplane airplane = new Airplane("Croatia Airlines");
        Airplane.Captain captain = airplane.new Captain("Sully");
        Airplane.Cargo mail = new Airplane.Cargo("mail", 50);
        airplane.addCargo(mail);
        airplane.addCargo(new Airplane.Cargo("luggage", 500));
        captain.sayWelcomeAndPilot("Rijeka", "Venice");
    }
}
