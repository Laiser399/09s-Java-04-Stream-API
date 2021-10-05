package org.mai.iris;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws IOException {
        App a = new App();
        a.test();
    }

    public void test() throws IOException {

        List<Iris> irisList = null; //load data from file iris.data
        IrisDataSetHelper helper = new IrisDataSetHelper(irisList);

        //get average sepal width
        Double avgSepalLength = null;
        System.out.println(avgSepalLength);

        //get average petal square - petal width multiplied on petal length
        Double avgPetalLength = null;
        System.out.println(avgPetalLength);

        //get average petal square for flowers with sepal width > 4
        Double avgPetalSquare = null;
        System.out.println(avgPetalSquare);

        //get flowers grouped by Petal size (Petal.SMALL, etc.)
        Map groupsByPetalSize = null;
        System.out.println(groupsByPetalSize);

        //get max sepal width for flowers grouped by species
        Map maxSepalWidthForGroupsBySpecies = null;
        System.out.println(maxSepalWidthForGroupsBySpecies);
    }

}

