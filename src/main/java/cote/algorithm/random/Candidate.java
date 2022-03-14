package cote.algorithm.random;

import lombok.Getter;

@Getter
public class Candidate<E, V> {
    private E name;
    private V weight;

    public Candidate(E name, V weight) {
        this.name = name;
        this.weight = weight;
    }
}
