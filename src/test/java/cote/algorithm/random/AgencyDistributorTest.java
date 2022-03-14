package cote.algorithm.random;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class AgencyDistributorTest {

    @Test
    public void test100() {
        long result = 0;
        for (int i = 0; i < 100; i++) {
            result += test();
        }
        log.info("{}", result);
    }

    public long test() {
        List<AgencyDistributor.Agency> result = IntStream.range(0, 10000)
            .mapToObj(i -> distribution())
            .collect(Collectors.toList());

        long countAgencyA = result.stream().filter(a -> a.getName().equals("A")).count();
        long countAgencyB = result.stream().filter(a -> a.getName().equals("B")).count();
        long countAgencyC = result.stream().filter(a -> a.getName().equals("C")).count();
//        log.info("countAgencyA = {}, countAgencyB = {}, countAgencyC = {}", countAgencyA,
//            countAgencyB, countAgencyC);
        return Math.abs(5000 - countAgencyA);
    }

    @Test
    public void test2() {
        List<AgencyDistributor.Agency> result = IntStream.range(0, 10000)
            .mapToObj(i -> distribution())
            .collect(Collectors.toList());

        long countAgencyA = result.stream().filter(a -> a.getName().equals("A")).count();
        long countAgencyB = result.stream().filter(a -> a.getName().equals("B")).count();
        long countAgencyC = result.stream().filter(a -> a.getName().equals("C")).count();
        log.info("countAgencyA = {}, countAgencyB = {}, countAgencyC = {}", countAgencyA,
            countAgencyB, countAgencyC);
    }

    private AgencyDistributor.Agency distribution() {
        AgencyDistributor.Agency agencyA = new AgencyDistributor.Agency("A", 5);
        AgencyDistributor.Agency agencyB = new AgencyDistributor.Agency("B", 3);
        AgencyDistributor.Agency agencyC = new AgencyDistributor.Agency("C", 2);

        List<AgencyDistributor.Agency> agencies = Lists.newArrayList(agencyA, agencyB, agencyC);
        AgencyDistributor.Agency selectedAgency = AgencyDistributor.distribution(agencies);
//        log.info("{}", selectedAgency);
        return selectedAgency;
    }
}