package ua.sumdu.j2se.lazzar.tasks;

public class ArrayTaskList {

    private static Task[] TASKSLIST;
    private static int SIZE = 0;

    void add(Task task) {
        if(size() == 0) {
            TASKSLIST = new Task[] { task };
            SIZE++;
        } else {
            Task[] newList = new Task[size() + 1];
            for (int i = 0; i < TASKSLIST.length; i++) {
                newList[i] = TASKSLIST[i];
            }
            newList[size()] = task;
            TASKSLIST = newList;
            SIZE++;
        }
    }

    boolean remove(Task task) {
        Integer indexForRemove = null;
        for (int i = 0; i < TASKSLIST.length; i++) {
            if(task.equals(TASKSLIST[i])) {
                indexForRemove = i;
                break;
            }
        }
        if(indexForRemove == null) return false;

        Task[] newList = new Task[size() - 1];
        for (int i = 0; i < TASKSLIST.length; i++) {

        }
        TASKSLIST = newList;
        SIZE--;
        return true;
    }

    Task getTask(int index) {
        return TASKSLIST[index];
    }

    int size() {
        return this.size();
    }
}
