package command.list;

import tasks.Tasks;

import java.util.HashMap;
import java.util.Map;

public class ListCommands {
    Map<String, ListCommand> commands = new HashMap<>();

    public ListCommands(Tasks tasks) {
        commands.put("todo", new ListTodoCommand(tasks));
        commands.put("in-progress", new ListInProgressCommand(tasks));
        commands.put("done", new ListDoneCommand(tasks));
    }

    public ListCommand getCommand(String command) {
        return commands.get(command);
    }
}
