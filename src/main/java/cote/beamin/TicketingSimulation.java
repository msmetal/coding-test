package cote.beamin;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

public class TicketingSimulation {

    public Map<String, TicketingLog> ticketing(Ticket ticket, String[] logs) {
        Map<String, TicketingLog> maps = new LinkedHashMap<>();

        LocalTime lastRequestTime = LocalTime.of(0, 0, 0);
        for (String log : logs) {
            TicketingLog ticketingLog = new TicketingLog(log);
            if (invalidRequest(ticket, ticketingLog)) continue;

            if (ticketingLog.logType == LogType.LEAVE) {
                maps.remove(ticketingLog.userId);
                ticket.cancel();
            } else if (ticketingLog.logType == LogType.REQUEST) {
                if (maps.containsKey(ticketingLog.userId)) {
                    continue;
                }
                long afterSec = lastRequestTime.until(ticketingLog.logTime, ChronoUnit.SECONDS);
                if (afterSec > 60) {
                    maps.put(ticketingLog.userId, ticketingLog);
                    ticket.buy();
                    lastRequestTime = ticketingLog.logTime;
                }
            }
        }
        return maps;
    }

    private boolean invalidRequest(Ticket ticket, TicketingLog log) {
        if (!log.validLog) {
            return true;
        }
        if (ticket.getStartTime().isAfter(log.logTime) || ticket.getEndTime().isBefore(log.logTime)) {
            return true;
        }
        if (!log.userId.matches("^[a-z]*$")) {
            return true;
        }
        if (ticket.getSalesQty() <= 0) {
            return true;
        }
        return false;
    }
}

@Builder
@Getter
class Ticket {
    private long salesQty;
    private LocalTime startTime;
    private LocalTime endTime;

    public void buy() {
        salesQty--;
    }

    public void cancel() {
        salesQty++;
    }
}

@ToString
class TicketingLog {
    String userId;
    LogType logType;
    LocalTime logTime;
    @Getter
    boolean validLog = true;

    TicketingLog(String log) {
        try {
            String[] split = log.split(" ");
            this.userId = split[0];
            this.logType = LogType.getLogType(split[1]);
            String[] timeSplit = split[2].split(":");
            this.logTime = LocalTime.of(Integer.parseInt(timeSplit[0]), Integer.parseInt(timeSplit[1]), Integer.parseInt(timeSplit[2]));
        } catch (Exception e) {
            this.validLog = false;
        }
    }
}

enum LogType {
    REQUEST("request"),
    LEAVE("leave"),
    OTHER("other");

    @Getter
    private String type;

    LogType(String type) {
        this.type = type;
    }

    public static LogType getLogType(String type) {
        for (LogType logType : LogType.values()) {
            if (logType.getType().equals(type)) {
                return logType;
            }
        }
        return LogType.OTHER;
    }

}
