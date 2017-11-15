package ua.sumdu.j2se.lazzar.tasks;

public abstract class TaskList implements Iterable<Task> {
    protected int size = 0;

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract Task getTask(int index);

    public int size() {
        return this.size;
    }

    public TaskList incoming(int from, int to) {
        TaskList result;
        if (this.getClass().equals(ArrayTaskList.class)) {
            result = new ArrayTaskList();
        } else {
            result = new LinkedTaskList();
        }

        for (int i = 0; i <= size(); i++) {
            Task task = getTask(i);
            if (task.nextTimeAfter(from) > 0 && task.nextTimeAfter(from) < to) {
                result.add(task);
            }
        }
        return result;
    }
}
