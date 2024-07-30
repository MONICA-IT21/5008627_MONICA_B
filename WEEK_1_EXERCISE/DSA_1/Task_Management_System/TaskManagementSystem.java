package DSA_1.Task_Management_System;

public class TaskManagementSystem {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManagementSystem() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();

        Task t1 = new Task(1, "Design Database", "Pending");
        Task t2 = new Task(2, "Develop API", "In Progress");
        Task t3 = new Task(3, "Create Frontend", "Pending");

        system.addTask(t1);
        system.addTask(t2);
        system.addTask(t3);

        System.out.println("All Tasks:");
        system.traverseTasks();

        System.out.println("\nSearch for task with ID 2:");
        System.out.println(system.searchTask(2));

        System.out.println("\nDeleting task with ID 1:");
        system.deleteTask(1);

        System.out.println("\nAll Tasks after deletion:");
        system.traverseTasks();
    }
}
