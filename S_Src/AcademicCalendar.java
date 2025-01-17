import java.util.ArrayList;

public class AcademicCalendar {
    private ArrayList<Event> events;

    public AcademicCalendar() {
        events = new ArrayList<>();
    }

    public void addEvent(String name, String date) {
        events.add(new Event(name, date));
    }

    public void displayEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found in the academic calendar.");
        } else {
            System.out.println("\n=== Academic Calendar ===");
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    // Event inner class
    static class Event {
        private String name;
        private String date;

        public Event(String name, String date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Event: " + name + ", Date: " + date;
        }
    }
}