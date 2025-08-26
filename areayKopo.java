import java.util.Scanner;

public class arrayKopo {

    public static void main(String[] args) {

        String[] lines = {
            "Procrastinators' To do List",
            "1. Add Task",
            "2. View Tasks",
            "3. Mark Tasks as Done",
            "4. Exit"
        };
        Scanner scannerVar = new Scanner(System.in);
        String[] tasks = new String[5];
        int taskCount = 0;
        boolean loop = true;

        while (loop) {
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
            }

            int choice = scannerVar.nextInt();
            scannerVar.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (taskCount < tasks.length) {
                        System.out.println("Add Task");
                        System.out.print("Input Title: ");
                        String task = scannerVar.nextLine();
                        tasks[taskCount] = task;
                        taskCount++;
                        System.out.println("Task Added");
                    } else {
                        System.out.println("Task list is Full");
                    }
                    break;

                case 2:
                    if (taskCount != 0) {
                        System.out.println("Your Tasks:");
                        for (int i = 0; i < taskCount; i++) {
                            System.out.println((i + 1) + ". " + tasks[i]);
                        }
                    } else {
                        System.out.println("No Task Yet");
                    }
                    break;

                case 3:
                    if (taskCount != 0) {
                        System.out.println("Select Task To be Marked as Done:");
                        for (int i = 0; i < taskCount; i++) {
                            System.out.println((i + 1) + ". " + tasks[i]);
                        }

                        int taskDone = scannerVar.nextInt();
                        scannerVar.nextLine();

                        if (taskDone >= 1 && taskDone <= taskCount) {
                            // shift tasks left
                            for (int i = taskDone - 1; i < taskCount - 1; i++) {
                                tasks[i] = tasks[i + 1];
                            }
                            tasks[taskCount - 1] = null;
                            taskCount--;

                            System.out.println("Task " + taskDone + " is marked as Done!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("No Task Yet");
                    }
                    break;

                case 4:
                    loop = false;
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
        scannerVar.close();
    }
}
