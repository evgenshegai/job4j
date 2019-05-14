package ru.job4j.collections.lambda;

/**
 * class LambdaFunction
 * @author EvgeniiShegay
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaFunction {

    public List<Double> diapozon(int start, int end, Function<Integer, Double> func) {

        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.apply(i));
       }
       return result;
    }
}
