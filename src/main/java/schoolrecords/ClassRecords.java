package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        if (isEmpty(className)) {
            throw new IllegalArgumentException("Class name must not be empty!");
        }
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {

        if (isEmpty(className)) {
            throw new NullPointerException("Classname should have a value!");
        }
        return className;
    }


    private boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }


    public String listStudentNames() {
        String nameList = "";
        for (int i = 0; i < students.size(); i++) {
            nameList += ((i < students.size()) ? (students.get(i).getName() + ", ") : (students.get(i).getName()));
        }
        return nameList;
    }

    public boolean addStudent(Student student) {
        for (Student item : students) {
            if (item.getName().equals(student.getName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean removeStudent(Student student) {
        boolean flag = false;

        if (student == null) {
            throw new NullPointerException("Student most be provided!");
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().toLowerCase().equals(student.getName().toLowerCase())) {
                flag = true;
                students.remove(students.get(i));
            }
            return flag;
        }


        for (Student item : students) {
            if (item.getName().toLowerCase().equals(student.getName().toLowerCase())) {
                flag = true;
                students.remove(item);
                break;
            }
        }
        return flag;
    }

    public List<StudyResultByName> listStudyResult() {
        if (students.isEmpty()) {
            throw new IllegalStateException("There is no student in the list!");
        }
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student item : students) {
            studyResultByNames.add(new StudyResultByName(item.calculateAverage(), item.getName()));
        }
        return studyResultByNames;
    }

    public double calculateClassAverage() {
        double sum = 0.0;
        int counter = 0;
        double average = 0.0;

        if (students.isEmpty()) {
            throw new ArithmeticException("There is no student in list so calculation will not carry on!!");
        }

        for (Student student : students) {
            if (student.calculateAverage() > 0) {
                sum += student.calculateAverage();
                counter += 1;
            } else {
                throw new ArithmeticException("The list is empty, no marks have been registered till now!");
            }
        }
        average = sum / counter;

        return Math.round((average) * 100) / 100.0;
    }


    public double calculateClassAverageBySubject(Subject subject) {
        double sum = 0.0;
        int counter = 0;
        double average = 0.0;

        for (Student item : students) {
            if (item.calculateSubjectAverage(subject) > 0) {
                sum += item.calculateSubjectAverage(subject);
                counter += 1;
            }
        }

        average = sum / counter;

        return Math.round((average) * 100) / 100.0;
    }

    public Student repetition() {
        if (students.size() == 0) {
            throw new IllegalStateException("At the moment, there is no student in the lis!");
        }
        return students.get(rnd.nextInt(students.size()));
    }

    public Student findStudentByName(String name) {

        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student must have a name!");
        }

        if (students.size() == 0) {
            throw new IllegalStateException("There is no student in the database!");
        }

        Student student = null;
        for (Student item : students) {
            if (name.toLowerCase().equals(item.getName().toLowerCase())) {
                student = item;
                break;
            }
        }
        return student;
    }

}


