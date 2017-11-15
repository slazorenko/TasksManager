package ua.sumdu.j2se.lazzar.tasks;

public class LinkedTaskList extends TaskList{

    private Container lastAdded;
    private Container firstContainer;

    public LinkedTaskList () {
        lastAdded = null;
        firstContainer = null;
    }

    private class Container {
        private Task element;
        private Container next;
        private Container prev;

        private Container(Task element) {
            if (element == null) {
                throw new IllegalArgumentException("ERROR: Task is null");
            }
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    public void add (Task task) throws IllegalArgumentException{
        if (task == null) {
            throw new IllegalArgumentException("ERROR: Task is null");
        }

        Container container = new Container(task);

        if (firstContainer == null) {//значит это у нас первый элемент
            firstContainer = container;
        }
        if (lastAdded != null) {
            lastAdded.next = container;
            container.prev = lastAdded;
        }

        lastAdded = container;
        size++;
    }

    public boolean remove (Task task) throws NullPointerException{
        if (firstContainer == null) {
            throw new NullPointerException("ERROR: The list is empty. Nothing to remove");
        }

        Container currentContainer = firstContainer;

        if (currentContainer.next == null){//если первый элемент является и последним
            if (currentContainer.element == task) {//подходит - удаляем
                firstContainer = null;
                lastAdded = null;
                size = 0;
            }
            return true;
        }

        /*когда currentContainer станет null цикл прервется*/
        while (currentContainer != null) {
            /*таск подходит и он последний. Убираем на него ссылку*/
            if (currentContainer.element == task && currentContainer.next == null) {
                currentContainer.prev.next = null;
                size--;
                return true;
            }
            /*таск подходит и он не последний*/
            if (currentContainer.element == task) {
                currentContainer.prev.next = currentContainer.next;
                currentContainer.next.prev = currentContainer.prev;
                size--;
                return true;
            }
            currentContainer = currentContainer.next;
        }
        return false;
    }

    public Task getTask (int index) throws IllegalArgumentException, NullPointerException {
        if (index >= size) {
            throw new IllegalArgumentException("Index bigger than size");
        }
        if (firstContainer == null) {
            throw new NullPointerException("ERROR: The list is empty");
        }

        Container scanningContainer = firstContainer;

        for(int i = 0; i <= index; i++) {
            if (i == index) {
                return scanningContainer.element;
            }
            scanningContainer = scanningContainer.next;
        }
        return null;
    }
}
