package exam02;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name, String skillName, int level) {
        this.name = name;
        skills.add(new Skill(skillName, level));
    }

    public String findSkillLevelByName(String skillName) {
        String returnString = "";
        for (Skill item : skills) {
            if (item.getSkillName().equals(skillName)) {
                returnString = skillName + "(" + item.getLevel() + ")";
            }
        }
        return returnString;
    }
}
