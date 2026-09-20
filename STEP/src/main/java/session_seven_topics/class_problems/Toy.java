package session_seven_topics.class_problems;

public abstract class Toy {
    private static int nextToyId = 1000;
    private final String toyId;
    private final String name;

    public Toy(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
        nextToyId++;
        this.toyId = "TOY-" + nextToyId;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }

    public String getName() {
        return name;
    }
}
