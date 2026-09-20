package session_seven_topics.class_problems;

public abstract class Toy {
    private static int nextToyId = 1000;
    private final String toyId;
    private final String name;

    protected Toy(String name) {
        this.name = name;
        this.toyId = "TOY-" + ++nextToyId;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }

    protected String getName() {
        return name;
    }
}
