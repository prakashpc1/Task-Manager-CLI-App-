import java.util.*;

public class TaskManager {
    private Map<String, Task> tasks;
    private Scanner scanner;

    public TaskManager() {
        this.tasks = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
        System.out.println("✅ Task added successfully.");
    }

    public void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks found.");
            return;
        }
        for (Task task : tasks.values()) {
            System.out.println(task);
        }
    }

    public void viewCompletedTasks() {
        List<Task> completed = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.isCompleted()) completed.add(task);
        }
        printTaskList(completed, "Completed Tasks");
    }

    public void viewPendingTasks() {
        List<Task> pending = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (!task.isCompleted()) pending.add(task);
        }
        printTaskList(pending, "Pending Tasks");
    }

    private void printTaskList(List<Task> list, String heading) {
        if (list.isEmpty()) {
            System.out.println("📭 No tasks found in " + heading.toLowerCase() + ".");
            return;
        }
        System.out.println("=== " + heading + " ===");
        for (Task task : list) {
            System.out.println(task);
        }
    }

    public void markTaskAsComplete(String id) {
        Task task = tasks.get(id);
        if (task != null) {
            task.markComplete();
            System.out.println("✅ Task marked as completed.");
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    public void deleteTask(String id) {
        if (tasks.remove(id) != null) {
            System.out.println("🗑️ Task deleted successfully.");
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    public void startMenu() {
        while (true) {
            System.out.println("\n===== Task Manager Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. View Completed Tasks");
            System.out.println("4. View Pending Tasks");
            System.out.println("5. Mark Task as Complete");
            System.out.println("6. Delete Task");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    viewAllTasks();
                    break;
                case 3:
                    viewCompletedTasks();
                    break;
                case 4:
                    viewPendingTasks();
                    break;
                case 5:
                    System.out.print("Enter Task ID to mark complete: ");
                    String compId = scanner.nextLine();
                    markTaskAsComplete(compId);
                    break;
                case 6:
                    System.out.print("Enter Task ID to delete: ");
                    String delId = scanner.nextLine();
                    deleteTask(delId);
                    break;
                case 7:
                    System.out.println("👋 Exiting Task Manager. Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }

    private void addNewTask() {
        System.out.print("Enter Task ID: ");
        String id = scanner.nextLine();

        if (tasks.containsKey(id)) {
            System.out.println("❌ A task with this ID already exists.");
            return;
        }

        System.out.print("Enter Task Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Task Description: ");
        String desc = scanner.nextLine();

        addTask(new Task(id, title, desc));
    }
}
