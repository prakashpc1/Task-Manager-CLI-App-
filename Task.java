public class Task {
    private String id;
    private String title;
    private String description;
    private boolean completed;

    public Task(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markComplete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " - " + (completed ? "✓ Completed" : "✗ Pending");
    }
}
