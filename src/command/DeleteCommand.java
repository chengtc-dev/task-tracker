package command;

import io.Arguments;
import tasks.Tasks;

public class DeleteCommand implements Command {
    private final Tasks tasks;

    public DeleteCommand(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute(Arguments arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException();
        } else {
            long taskId = Long.parseLong(arguments.getArgument(1));
            tasks.deleteTask(taskId);
        }
    }
}
