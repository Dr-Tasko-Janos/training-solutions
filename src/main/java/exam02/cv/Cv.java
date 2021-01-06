package exam02.cv;

import java.util.ArrayList;
import java.util.List;


public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();


    //Constructor:
    public Cv(String name) {
        this.name = name;
    }


    //Setters:
    public void addSkills(String... complexName) {

        List<Skill> newSkills = new ArrayList<>();

        for (int i = 0; i < complexName.length; i++) {
            String basic = complexName[i];

            String name = basic.substring(0, basic.indexOf("(") - 1);
            System.out.println(name);

            String level = basic.substring(basic.indexOf(")") - 1, basic.indexOf(")"));
            int levelX = Integer.parseInt(level);
            System.out.println(levelX);
            newSkills.add(new Skill(name, levelX));
        }
        addSkills(newSkills);
    }


    public void addSkills(List<Skill> skills) {
        for (Skill item : skills) {
            this.skills.add(new Skill(item.getName(), item.getLevel()));
        }
    }


    //Getters:
    public String getName() {
        return name;
    }


    public List<Skill> getSkills() {
        return skills;
    }


    public Cv(String name, String skillName, int level) {
        this(name);
        skills.add(new Skill(skillName, level));
    }


    //Other methods
    public int findSkillLevelByName(String skillName) {
        int levelValue = 0;
        for (Skill item : skills) {
            if (item.getName().equals(skillName)) {
                levelValue = item.getLevel();
                return levelValue;
            }
        }
        throw new RuntimeException("Item not found");
    }


    //Custom exception:
    class SkillNotFoundException extends Exception {
    }

   /* public static void main(String[] args) {
        Cv cv = new Cv("János");
        cv.addSkills("C# (2)", "Java (13)", "Python (5)");
        System.out.println(cv.findSkillLevelByName("Java"));
    }*/
}