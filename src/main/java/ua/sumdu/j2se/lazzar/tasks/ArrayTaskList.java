package ua.sumdu.j2se.lazzar.tasks;

public class ArrayTaskList {

    private static Task[] TASKSLIST;

    void add(Task task) {
        if(size() == 0) {
            TASKSLIST = new Task[] { task };
        } else {
            Task[] newList = new Task[size() + 1];
            System.arraycopy(TASKSLIST, 0, newList, 0, size());
            newList[size()] = task;
            TASKSLIST = newList;
        }
    }

    boolean remove(Task task) {
        Integer indexForRemove = null;
        //getting index for remove
        for (int i = 0; i < size(); i++) {
            if(task.equals(TASKSLIST[i])) {
                indexForRemove = i;
                break;
            }
        }
        //if equal task not found
        if(indexForRemove == null) return false;
        //removing index
        Task[] newList = new Task[size() - 1];
        System.arraycopy(TASKSLIST, 0, newList, 0, indexForRemove);
        System.arraycopy(TASKSLIST, indexForRemove+1, newList, indexForRemove, newList.length - indexForRemove);
        TASKSLIST = newList;
        return true;
    }

    Task getTask(int index) {
        return TASKSLIST[index];
    }

    private int size() {
        return TASKSLIST.length;
    }
}
