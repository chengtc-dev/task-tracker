package tasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.JsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tasks {
    private static final String TASKS_FILE_NAME = "tasks.json";

    private final List<Task> tasks;

    public Tasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Tasks() {
        File tasksFile = new File(TASKS_FILE_NAME);

        try {
            if (tasksFile.createNewFile()) {
                tasks = new ArrayList<>();
            } else {
                tasks = JsonUtil.readFromFile(TASKS_FILE_NAME, new TypeReference<>() {});
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTask(Task task) {
        long id = tasks.isEmpty() ? 1L : tasks.get(tasks.size() - 1).getId() + 1;
        task.setId(id);
        tasks.add(task);
        save();
    }

    public void updateTask(Long id, Task task) {
        int index = findIndexById(id);
        if (index != -1) {
            task.setId(id);
            task.setUpdateAt(new Date());
            tasks.set(index, task);
            save();
        }
    }

    public void deleteTask(Long id) {
        int index = findIndexById(id);
        if (index != -1) {
            tasks.remove(index);
            save();
        }
    }

    public void updateTaskState(Long id, Status status) {
        int index = findIndexById(id);
        if (index != -1) {
            Task task = tasks.get(index);
            task.setStatus(status);
            task.setUpdateAt(new Date());
            save();
        }
    }

    public Tasks getTasksByStatus(Status status) {
        List<Task> tasks = new ArrayList<>();
        for (Task task : this.tasks)
            if (task.getStatus() == status)
                tasks.add(task);

        return new Tasks(tasks);
    }

    private int findIndexById(Long id) {
        for (int i = 0; i < tasks.size(); i++)
            if (tasks.get(i).getId().longValue() == id)
                return i;

        return -1;
    }

    private void save() {
        try {
            JsonUtil.writeToFile(tasks, TASKS_FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        try {
            return JsonUtil.toJson(tasks);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
