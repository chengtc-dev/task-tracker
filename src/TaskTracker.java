import command.Command;
import command.Commands;
import io.Arguments;
import tasks.Tasks;

import java.util.*;

public class TaskTracker {
    private final Commands commands;
    private final Scanner scanner;

    public TaskTracker() {
        this.commands = new Commands(new Tasks());
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        TaskTracker tracker = new TaskTracker();

        while (true) {
            System.out.print("task-cli ");
            String input = tracker.scanner.nextLine();
            Arguments arguments = new Arguments();
            arguments.parseInput(input.trim());

            if (arguments.isEmpty())
                continue;

            Command command = tracker.commands.getCommand(arguments.getArgument(0));

            if (command == null) {
                System.out.println("command not found: " + arguments.getArgument(0));
                continue;
            }

            try {
                command.execute(arguments);
            } catch (NumberFormatException e) {
                System.out.println("error: parse task ID fail");
            } catch (IllegalArgumentException e) {
                System.out.println("error: missing task ID or new description");
            } catch (Exception e) {
                System.out.println("error: unexpected error occurred");
            }
        }
    }
}