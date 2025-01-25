package command.list;

import tasks.Status;
import tasks.Tasks;

public class ListInProgressCommand implements ListCommand {
    private final Tasks tasks;

    public ListInProgressCommand(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute() {
        System.out.println(tasks.getTasksByStatus(Status.IN_PROGRESS));
    }
}
