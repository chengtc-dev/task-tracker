package io;

import java.util.ArrayList;
import java.util.List;

public class Arguments {
    private final List<String> arguments;

    public Arguments() {
        this.arguments = new ArrayList<>();
    }

    public Boolean isEmpty() {
        return arguments.isEmpty();
    }

    public String getArgument(int index) {
        return arguments.get(index);
    }

    public Integer size() {
        return arguments.size();
    }

    public void parseInput(String input) {
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (char c : input.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;

                if (!inQuotes) {
                    arguments.add(current.toString());
                    current.setLength(0);
                }
            } else if (Character.isWhitespace(c)) {
                if (inQuotes) {
                    current.append(c);
                } else if (!current.isEmpty()) {
                    arguments.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }

        if (!current.isEmpty()) {
            arguments.add(current.toString());
        }
    }
}
