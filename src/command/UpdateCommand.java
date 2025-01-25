package command;

import io.Arguments;
import tasks.Task;
import tasks.Tasks;

public class UpdateCommand implements Command {
    private final Tasks tasks;

    public UpdateCommand(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute(Arguments arguments) {
        if (arguments.size() < 3) {
            throw new IllegalArgumentException();
        } else {
            Long taskId = Long.parseLong(arguments.getArgument(1));
            tasks.updateTask(taskId, new Task(arguments.getArgument(2)));
        }
    }
}
