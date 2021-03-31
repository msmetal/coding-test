package cote.algorithm.random;

import lombok.val;

import java.util.List;
import java.util.stream.Collectors;

public class Distributor {

    private final List<Candidate<String, Double>> candidates;

    public Distributor(List<Candidate<String, Integer>> target) {
        double totalWeight = target.stream().mapToDouble(Candidate::getWeight).sum();
        System.out.println("totalWeight : " + totalWeight);
        this.candidates = target.stream()
            .map(p -> new Candidate<>(p.getName(), p.getWeight() / totalWeight))
            .collect(Collectors.toList());
    }

    public String distribute() {
        final double pivot = Math.random();
        double acc = 0;
        for (val candidate : candidates) {
            acc += candidate.getWeight();
            if (pivot <= acc) {
                return candidate.getName();
            }
        }
        return null;
    }
}
