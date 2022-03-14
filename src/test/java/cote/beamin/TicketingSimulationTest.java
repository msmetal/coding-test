package cote.beamin;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketingSimulationTest {

    @Test
    public void test() {
        String[] logs = {
                "jerry request 08:50:29",
                "woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:34:02",
                "cu request 09:40:02",
                "Kim request 09:48:02",
                "last request 10:00:02"
        };

        Ticket ticket = Ticket.builder()
                .startTime(LocalTime.of(9, 0, 0))
                .endTime(LocalTime.of(9, 59, 59))
                .salesQty(10000)
                .build();

        TicketingSimulation simulation = new TicketingSimulation();
        Map<String, TicketingLog> ticketingLogMap = simulation.ticketing(ticket, logs);
        List<String> ticketingUsers = ticketingLogMap.keySet().stream().sorted().collect(Collectors.toList());

        System.out.println(ticketingLogMap.toString());
        System.out.println(ticketingUsers.toString());
    }
}