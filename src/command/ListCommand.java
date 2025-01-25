package command;

import command.list.ListCommands;
import io.Arguments;
import tasks.Tasks;

public class ListCommand implements Command {
    private final Tasks tasks;
    private final ListCommands listCommands;

    public ListCommand(Tasks tasks) {
        this.tasks = tasks;
        this.listCommands = new ListCommands(tasks);
    }

    @Override
    public void execute(Arguments arguments) {
        if (arguments.size() < 2) {
            System.out.println(tasks);
            return;
        }

        command.list.ListCommand command = listCommands.getCommand(arguments.getArgument(1));

        if (command == null) {
            System.out.println("command not found: " + arguments.getArgument(1));
        } else {
            command.execute();
        }
    }
}
