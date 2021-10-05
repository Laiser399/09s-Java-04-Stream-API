package org.mai.iris;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) throws IOException {
        App a = new App();
        a.test();
    }

    public void test() throws IOException {
        //load data from file iris.data
        var irisList = Files.lines(Paths.get("iris.data"))
                .map(Iris::parse)
                .collect(Collectors.toList());
        IrisDataSetHelper helper = new IrisDataSetHelper(irisList);

        //get average sepal length
        var avgSepalLength = helper.getAverage(Iris::getSepalLength);
        System.out.println("Average sepal length: " + avgSepalLength);
        System.out.println();

        //filtered by petal length
        var withLongPetal = helper.filter(x -> x.getPetalLength() > 6.5);
        System.out.println("Irises with petal length more than 6.5");
        withLongPetal.forEach(x -> System.out.println("\t" + x));
        System.out.println();

        //get average petal square - petal width multiplied on petal length
        var avgPetalSquare = helper.getAverage(x -> x.getPetalWidth() * x.getPetalLength());
        System.out.println("Average petal square: " + avgPetalSquare);
        System.out.println();

        //get average petal square for flowers with sepal width > 4
        var avgPetalSquareFiltered = helper.getAverageWithFilter(
                x -> x.getSepalWidth() > 4,
                x -> x.getPetalWidth() * x.getPetalLength());
        System.out.println("Average petal square with sepal width more than 4: " + avgPetalSquareFiltered);
        System.out.println();

        //get flowers grouped by Petal size (Petal.SMALL, etc.)
        var groupsByPetalSize = helper.groupBy(Iris::classifyByPetalSize);
        groupsByPetalSize.forEach((key, value) -> {
            System.out.println(key);
            var count = value.size();
            var limitCount = 4;
            value.stream()
                    .limit(limitCount)
                    .forEach(y -> System.out.println("\t" + y));
            if (count > limitCount) {
                System.out.println("\t..." + (count - limitCount) + " more");
            }
        });
        System.out.println();

        //get max sepal width for flowers grouped by species
        var maxSepalWidthForGroupsBySpecies = helper.maxFromGroupedBy(
                Iris::getSpecies, Iris::getSepalWidth);
        maxSepalWidthForGroupsBySpecies.forEach((species, iris) -> {
            System.out.println(species);
            System.out.println("\t" + iris);
        });
    }

}

