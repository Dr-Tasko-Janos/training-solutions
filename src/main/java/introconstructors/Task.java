package introconstructors;

import java.time.LocalDateTime;

public class Task {

    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private int duration;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void startDateTime() {
        this.startDateTime = LocalDateTime.now();
    }

    public static void main(String[] args) {

        Task newTask = new Task("Meeting", "To discuss the details of the new project");

        newTask.startDateTime();
        newTask.setDuration(2);
        System.out.println("The title of the meeting: " + newTask.getTitle());
        System.out.println("Description of the meeting: " + newTask.getDescription());
        System.out.println("The duration of the meeting : " + newTask.getDuration() + " hour(s)");
        System.out.println("The date and time of the meeting in ISO-8601: " + newTask.getStartDateTime());
    }
}
