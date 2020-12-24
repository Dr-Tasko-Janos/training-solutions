package week07d04;

import java.time.LocalDate;

public class Lab {

    private String title;
    private boolean completed;
    private LocalDate completedAt;

    public Lab(String title) {
        this.title = title;
        completed = false;
    }

    public Lab(String title, int year, int month, int day) {
        this(title);
        this.completedAt = LocalDate.of(year, month, day);
        completed = true;
    }

    public void complete(int year, int month, int day) {
        this.completedAt = LocalDate.of(year, month, day);
        completed = true;
    }

    public void complete() {
        completedAt = LocalDate.now();
        completed = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getCompletedAt() {
        return completedAt;
    }

    @Override
    public String toString() {

        return "Title: " + getTitle() + ", is finished: " + isCompleted() + ", at: " + ((getCompletedAt() == null) ? "Not finished yet" : getCompletedAt());
    }


    public static void main(String[] args) {

        //First test:
        System.out.println("First test - give every parameter when create instance of Lab:");

        Lab lab1 = new Lab("Introduction to Java", 2020, 12, 01);
        System.out.println(lab1);


        //Second test:
        System.out.println("\nSecond test - Only give the title when create the instance of Lab - later set the date of completion: ");

        Lab lab = new Lab("Java Basics");
        System.out.println(lab);

        lab.complete(2020, 12, 25);
        System.out.println(lab);


        //Third test:
        System.out.println("\nThird test - Only give the title when create the instance of Lab - Later use the method called \"complete()\" to initialize every arguments : ");

        Lab lab3 = new Lab("Java methods");
        System.out.println(lab3);
        lab3.complete();
        System.out.println(lab3);
    }
}
