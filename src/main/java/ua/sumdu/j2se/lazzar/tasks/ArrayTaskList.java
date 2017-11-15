package ua.sumdu.j2se.lazzar.tasks;

public class ArrayTaskList extends TaskList{

    private Task[] TASKSLIST;
    private int delta = 10;

    public void add(Task task) {
        if(size() == 0) {
            TASKSLIST = new Task[delta];
            TASKSLIST[0] = task;
            size++;
        } else {
            if (TASKSLIST.length == size()) {
                Task[] newList = new Task[size() + delta];
                System.arraycopy(TASKSLIST, 0, newList, 0, size());
                TASKSLIST = newList;
            }
            TASKSLIST[size() + 1] = task;
            size++;
        }
    }

    public boolean remove(Task task) {
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
        size--;
        return true;
    }

    public Task getTask(int index) {
        return TASKSLIST[index];
    }
}
