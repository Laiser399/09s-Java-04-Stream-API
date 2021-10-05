package org.mai.iris;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class IrisDataSetHelper {

    private List<Iris> dataSet;

    public IrisDataSetHelper(List<Iris> dataSet) {
        this.dataSet = dataSet;
    }

    public Double getAverage(ToDoubleFunction<Iris> func) {
        throw new RuntimeException();
    }

    public List<Iris> filter(Predicate<Iris> predicate) {
        throw new RuntimeException();
    }

    public Double getAverageWithFilter(Predicate<Iris> filter, ToDoubleFunction<Iris> mapFunction) {
        throw new RuntimeException();
    }

    public Map groupBy(Function groupFunction) {
        throw new RuntimeException();
    }

    public Map maxFromGroupedBy(Function groupFunction, ToDoubleFunction<Iris> obtainMaximisationValueFunction) {
        throw new RuntimeException();
    }
}
