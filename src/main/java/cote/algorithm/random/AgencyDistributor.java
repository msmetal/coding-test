package cote.algorithm.random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class AgencyDistributor {

    public static Agency distribution(List<Agency> agencies) {
        int sum = agencies.stream().mapToInt(Agency::getRate).sum();
        agencies.sort(Comparator.comparing(Agency::getRate));
        double pivot = randomPivot(sum);
        double acc = 0;
        for (Agency agency : agencies) {
            acc += agency.getRate();
            if (pivot <= acc) {
                return agency;
            }
        }
        return agencies.get(0);
    }

    public static double randomPivot(int bound) {
        return ThreadLocalRandom.current().nextDouble(1, bound + 1);
    }

//    public static double randomPivot() {
//        return Math.random();
//    }

    @ToString
    @Getter
    @AllArgsConstructor
    static class Agency {
        private String name;
        private int rate;
    }
}
