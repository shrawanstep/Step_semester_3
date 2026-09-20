package session_seven_topics.class_problems;

public class Blender {
    private int speedLevel;

    public void setSpeedLevel(int speedLevel) {
        if (speedLevel >= 1 && speedLevel <= 10) {
            this.speedLevel = speedLevel;
        } else {
            this.speedLevel = 1;
        }
    }

    public int getSpeedLevel() {
        return speedLevel;
    }

    public String prepare() {
        return "Blender prepared at speed " + speedLevel + ".";
    }

    public String clean() {
        return "Blender cleaned successfully.";
    }
}
