package command.list;

import tasks.Status;
import tasks.Tasks;

public class ListTodoCommand implements ListCommand {
    private final Tasks tasks;

    public ListTodoCommand(Tasks tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute() {
        System.out.println(tasks.getTasksByStatus(Status.TODO));
    }
}
