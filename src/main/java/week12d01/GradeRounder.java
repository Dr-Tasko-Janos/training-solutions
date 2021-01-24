package week12d01;

import java.util.Arrays;

public class GradeRounder {

    public int[] roundGrades(int[] grades) {
        int[] gradesForReturn = new int[grades.length];

        System.arraycopy(grades, 0, gradesForReturn, 0, grades.length);

        for (int i = 0; i < gradesForReturn.length; i++) {
            if (gradesForReturn[i] > 40 && 5 - gradesForReturn[i] % 5 < 3) {
                gradesForReturn[i] = gradesForReturn[i] + (5 - gradesForReturn[i] % 5);
            }
        }
        return gradesForReturn;
    }

    public static void main(String[] args) {

        int[] grades = {1, 23, 34, 39, 41, 44, 84, 95, 96, 97, 98, 99};

        GradeRounder gradeRounder = new GradeRounder();
        System.out.println(Arrays.toString(gradeRounder.roundGrades(grades)));
    }
}
