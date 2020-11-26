package schoolrecords;

import java.util.ArrayList;
import java.util.List;


public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        double sum = 0.0;
        for (Mark item : marks) {
            sum += item.getMarkType().getValue();
        }
        double average = sum / marks.size();
        return Math.round((average * 100)) / 100.0;
    }

    public double calculateSubjectAverage(Subject subject) {
        double sum = 0.0;
        int counter = 0;
        for (Mark item : marks) {
            if (item.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sum += item.getMarkType().getValue();
                counter += 1;
            }
        }
        double subjectAverage = sum / counter;
        return Math.round((subjectAverage * 100)) / 100.0;
    }

    private boolean isEmpty(String name) {
        return (name.equals("") || name.trim().equals("")) ? true : false;
    }

    @Override
    public String toString() {
        String studentName = getName();
        for (int i = 0; i < marks.size(); i++) {
            studentName += " marks: " + marks.get(i).getSubject().getSubjectName()
                    + ": " + marks.get(i).getMarkType().getDescription() + "(" + marks.get(i).getMarkType().getValue() + ")";
        }
        return studentName;
    }

}
