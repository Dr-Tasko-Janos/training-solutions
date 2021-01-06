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

            String name = basic.trim().substring(0, getSkills().indexOf("("));

            String level = basic.substring(basic.indexOf(")") - 1);
            int levelX = Integer.parseInt(level);

            newSkills.add(new Skill(name, levelX));
        }
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
    public String findSkillLevelByName(String skillName) {
        String returnString = "";
        for (Skill item : skills) {
            if (item.getName().equals(skillName)) {
                return skillName + "(" + item.getLevel() + ")";
            }
        }
        return null;
    }


    //Custom exception:
    class SkillNotFoundException extends Exception {
    }
}