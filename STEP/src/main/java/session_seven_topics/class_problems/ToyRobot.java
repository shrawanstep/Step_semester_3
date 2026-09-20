package session_seven_topics.class_problems;

public class ToyRobot extends Toy {
    public ToyRobot(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return getName() + ": Beep boop!";
    }
}
