package exam02.cv;

import java.util.ArrayList;
import java.util.List;




public class Cv {
    private String name;
    private List<Skill> skills = new ArrayList<>();


    public Cv(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<Skill> getSkills(){
        return skills;
    }

    public void addSkills(List<Skill> skills) {
        for (Skill item : skills) {
            this.skills.add(new Skill(item.getName(),item.getLevel()));
        }
    }



    public Cv(String name, String skillName, int level) {
        this(name);
        skills.add(new Skill(skillName, level));
    }

    public String findSkillLevelByName(String skillName) {
        String returnString = "";
        for (Skill item : skills) {
            if (item.getName().equals(skillName)) {
                return skillName + "(" + item.getLevel() + ")";
            }
        }
        return null;
    }

    class SkillNotFoundException extends Exception{

    }

}