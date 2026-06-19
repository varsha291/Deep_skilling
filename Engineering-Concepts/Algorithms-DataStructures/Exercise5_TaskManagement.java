public class Exercise5_TaskManagement {
    static class Task {
        int taskId;
        String taskName;
        String status;
        Task next;

        Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        @Override
        public String toString() {
            return taskId + " - " + taskName + " - " + status;
        }
    }

    private Task head;

    public void addTask(Task task) {
        if (head == null) {
            head = task;
            return;
        }

        Task current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = task;
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }
        if (head.taskId == taskId) {
            head = head.next;
            return true;
        }

        Task current = head;
        while (current.next != null && current.next.taskId != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        return true;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Exercise5_TaskManagement manager = new Exercise5_TaskManagement();
        manager.addTask(new Task(1, "Prepare report", "Pending"));
        manager.addTask(new Task(2, "Review code", "In Progress"));
        manager.addTask(new Task(3, "Submit assignment", "Done"));

        System.out.println("Tasks:");
        manager.traverseTasks();
        System.out.println("Search ID 2: " + manager.searchTask(2));
        System.out.println("Delete ID 1: " + manager.deleteTask(1));
        manager.traverseTasks();

        System.out.println("\nComplexity:");
        System.out.println("Add at end, search, traverse, and delete by id are O(n). Add at head can be O(1).");
    }
}
