package command;

import io.Arguments;
import tasks.Status;
import tasks.Tasks;

public class MarkDoneCommand implements Command {
    private final Tasks tasks;

    public MarkDoneCommand(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute(Arguments arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException();
        } else {
            Long taskId = Long.parseLong(arguments.getArgument(1));
            tasks.updateTaskState(taskId, Status.DONE);
        }
    }
}
