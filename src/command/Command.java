package command;

import io.Arguments;

public interface Command {
    void execute(Arguments arguments) throws NumberFormatException;
}
