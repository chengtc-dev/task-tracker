package command;

import io.Arguments;
import tasks.Status;
import tasks.Tasks;

public class MarkInProgressCommand implements Command {
    private final Tasks tasks;

    public MarkInProgressCommand(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute(Arguments arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException();
        } else {
            long taskId = Long.parseLong(arguments.getArgument(1));
            tasks.updateTaskState(taskId, Status.IN_PROGRESS);
        }
    }
}
