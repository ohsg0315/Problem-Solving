import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private class Ticket {
        String stationName;
        int t;

        public Ticket(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }

    private class Record {
        int theNumberOfPassanger;
        int totalTime;

        public Record(int theNumberOfPassanger, int totalTime) {
            this.theNumberOfPassanger = theNumberOfPassanger;
            this.totalTime = totalTime;
        }
    }

    private Map<Integer, Ticket> ticketMap;
    private Map<String, HashMap<String, Record>> recordMap;

    public UndergroundSystem() {
        this.ticketMap = new HashMap<>();
        recordMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        ticketMap.put(id, new Ticket(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Ticket ticket = ticketMap.get(id);
        HashMap<String, Record> endStationMap = recordMap.getOrDefault(ticket.stationName, new HashMap<>());
        Record record = endStationMap.getOrDefault(stationName, new Record(0, 0));

        record.theNumberOfPassanger++;
        record.totalTime += t - ticket.t;

        endStationMap.put(stationName, record);
        recordMap.put(ticket.stationName, endStationMap);
    }

    public double getAverageTime(String startStation, String endStation) {
        HashMap<String, Record> endStationMap = recordMap.get(startStation);
        Record record = endStationMap.get(endStation);

        return (double) record.totalTime / record.theNumberOfPassanger;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */