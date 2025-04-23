package ToDoListProject;

import java.sql.SQLException;
import java.util.Scanner;

public class ToDoListMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n<=== Task Planner ===>");
            System.out.println("1) Add Task");
            System.out.println("2) Read Task");
            System.out.println("3) Update Task");
            System.out.println("4) Delete Task");
            System.out.println("5) List All Tasks (Sorted by Deadline)");
            System.out.println("6) Mark Task as Completed");
            System.out.println("7) Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter task header: ");
                        String header = scanner.nextLine();
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter deadline (in days): ");
                        int deadlineInDays = scanner.nextInt();
                        scanner.nextLine();
                        DataAccessObject.addTask(header, description, deadlineInDays);
                        break;
                    case 2:
                        System.out.print("Enter task id to fetch: ");
                        int searchId = scanner.nextInt();
                        System.out.println("------------------------------------------");
                        DataAccessObject.readTask(searchId);
                        break;
                    case 3:
                        System.out.print("Enter task ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new task header: ");
                        String newHeader = scanner.nextLine();
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Enter new deadline (in days): ");
                        int newDeadline = scanner.nextInt();
                        scanner.nextLine();
                        DataAccessObject.updateTask(newHeader, newDescription, newDeadline, updateId);
                        break;
                    case 4:
                        System.out.print("Enter task ID to delete: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();
                        DataAccessObject.deleteTask(deleteId);
                        break;
                    case 5:
                        System.out.println("Tasks sorted by deadline:");
                        System.out.println("------------------------------------------");
                        DataAccessObject.printAllTasksSortedByDeadline();
                        break;
                    case 6:
                        System.out.print("Enter task ID to mark as completed: ");
                        int completeId = scanner.nextInt();
                        scanner.nextLine();
                        DataAccessObject.updateCompleteness(true, completeId);
                        break;
                    case 7:
                        running = false;
                        System.out.println("<=== Exiting... ===>");
                        break;
                    default:
                        System.out.println("\tInvalid choice, please try again");
                }
            } catch (SQLException e) {
                System.out.println("Error while performing the database operation: " + e.getMessage());
            }
        }
        scanner.close();
    }
}