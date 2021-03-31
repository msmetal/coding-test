package cote.algorithm.random;

import lombok.Getter;

@Getter
public class Candidate<K, V> {
    private K name;
    private V weight;

    public Candidate(K name, V weight) {
        this.name = name;
        this.weight = weight;
    }
}
