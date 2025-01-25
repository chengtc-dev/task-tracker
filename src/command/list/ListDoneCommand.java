package command.list;

import tasks.Status;
import tasks.Tasks;

public class ListDoneCommand implements ListCommand {
    private final Tasks tasks;

    public ListDoneCommand(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute() {
        System.out.println(tasks.getTasksByStatus(Status.DONE));
    }
}
