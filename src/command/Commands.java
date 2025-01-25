package command;

import tasks.Tasks;

import java.util.HashMap;
import java.util.Map;

public class Commands {
    Map<String, Command> commands = new HashMap<>();

    public Commands(Tasks tasks) {
        commands.put("add", new AddCommand(tasks));
        commands.put("update", new UpdateCommand(tasks));
        commands.put("delete", new DeleteCommand(tasks));
        commands.put("mark-todo", new MarkTodoCommand(tasks));
        commands.put("mark-in-progress", new MarkInProgressCommand(tasks));
        commands.put("mark-done", new MarkDoneCommand(tasks));
        commands.put("list", new ListCommand(tasks));
    }

    public Command getCommand(String command) {
        return commands.get(command);
    }
}
