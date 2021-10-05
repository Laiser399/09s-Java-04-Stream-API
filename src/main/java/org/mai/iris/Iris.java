package org.mai.iris;

/**
 * Created by Asus on 10/7/2018.
 */
public class Iris {
    //длина чашелистника
    private final double sepalLength;

    //ширина чашелистника
    private final double sepalWidth;

    //длина лепестка
    private final double petalLength;

    //ширина лепестка
    private final double petalWidth;

    //вид
    private final String species;

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String species) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public String getSpecies() {
        return species;
    }

    static Iris parse(String line) {
        String[] parts = line.split(",");
        return new Iris(
                Double.parseDouble(parts[0]),
                Double.parseDouble(parts[1]),
                Double.parseDouble(parts[2]),
                Double.parseDouble(parts[3]),
                parts[4]
        );
    }

    @Override
    public String toString() {
        return "Iris{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                ", species='" + species + '\'' +
                '}';
    }

    public static PetalSize classifyByPetalSize(Iris iris) {
        double petalSquare = iris.getPetalLength() * iris.getPetalWidth();
        if (petalSquare < 2.0) {
            return PetalSize.SMALL;
        }
        if (petalSquare < 5.0) {
            return PetalSize.MEDIUM;
        }
        return PetalSize.LARGE;
    }
}
