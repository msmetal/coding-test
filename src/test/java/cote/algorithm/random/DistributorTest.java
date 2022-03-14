package cote.algorithm.random;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DistributorTest {

    @Test
    public void testRandom() {
        List<Candidate<String, Integer>> target = Arrays.asList(
            new Candidate<>("NICE", 10),
            new Candidate<>("KICC", 50),
            new Candidate<>("LGU+", 20),
            new Candidate<>("PAY", 20)
        );

        Distributor distributor = new Distributor(target);

        int count = 10000;
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String name = distributor.distribute();
            result.put(name, 1 + result.getOrDefault(name, 0));
        }

        for (Map.Entry<String, Integer> e : result.entrySet()) {
            System.out.printf("%s 확률 : %.2f\n", e.getKey(),
                (double) e.getValue() / (double) count * 100);
        }

    }

    public <E> E getWeightedRandom(Map<E, Double> weights) {
        E result = null;
        double bestValue = Double.MAX_VALUE;
        Random random = new Random();
        for (E element : weights.keySet()) {
            double value = -Math.log(random.nextDouble()) / weights.get(element);
//            System.out.println("value:" + value + ", bestValue:" + bestValue);
            if (value < bestValue) {
                bestValue = value;
                result = element;
            }
        }
        return result;
    }

    @Test
    public void test() {
        Map<String, Double> w = new HashMap<>();
        w.put("ball", 25D);
        w.put("strike", 70D);
        w.put("wild pitch", 5D);

        int count = 10000;
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String name = getWeightedRandom(w);
            result.put(name, 1 + result.getOrDefault(name, 0));
        }

        for (Map.Entry<String, Integer> e : result.entrySet()) {
            System.out.printf("%s 확률 : %.2f\n", e.getKey(),
                (double) e.getValue() / (double) count * 100);
        }

    }
}