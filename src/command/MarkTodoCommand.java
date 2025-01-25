package command;

import io.Arguments;
import tasks.Status;
import tasks.Tasks;

public class MarkTodoCommand implements Command {
    private final Tasks tasks;

    public MarkTodoCommand(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute(Arguments arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException();
        } else {
            long taskId = Long.parseLong(arguments.getArgument(1));
            tasks.updateTaskState(taskId, Status.TODO);
        }
    }
}
