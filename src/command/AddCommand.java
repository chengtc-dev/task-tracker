package command;

import io.Arguments;
import tasks.Task;
import tasks.Tasks;

public class AddCommand implements Command {
    private final Tasks tasks;

    public AddCommand(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute(Arguments arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException();
        } else {
            tasks.addTask(new Task(arguments.getArgument(1)));
        }
    }
}
