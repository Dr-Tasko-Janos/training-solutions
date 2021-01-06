package exam02.cv;

public class Skill {
    private String skillName;
    private int level;

    public Skill(String skillName, int level) {
        this.skillName = skillName;
        this.level = level;
    }

    public String getName() {
        return skillName;
    }

    public int getLevel() {
        return level;
    }
}
