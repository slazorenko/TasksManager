package ua.sumdu.j2se.lazzar.tasks;

public class Task {
    private String title;
    private int time; //== startTime for repeatable tasks
    private int endTime;
    private int interval;
    private boolean active = false;
    private boolean repeated = false;

    public Task(String title, int time){
        this.title = title;
        this.time = time;
    }

    public Task(String title, int start, int end, int interval) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    /**for non-repeatable tasks*/
    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.repeated = false;
        this.time = time;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**for repeatable tasks*/
    int getStartTime() {
        return this.time;
    }

    int getEndTime() {
        if (isRepeated()) {
            return this.endTime;
        } else return this.time;
    }

    int getRepeatInterval() {
        if (isRepeated()) {
            return this.interval;
        } else return 0;
    }

    void setTime(int start, int end, int interval) {
        this.time = start;
        this.endTime = end;
        this.interval = interval;
        this.repeated = true;
    }

    boolean isRepeated(){
        return this.repeated;
    }

    int nextTimeAfter(int current) {
        if (!isActive() || !isRepeated()) return -1;
        if (current <= this.time) return -1;

        int intervalsPassed = (current - this.time) % this.interval;
        return (intervalsPassed + 1) * interval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (time != task.time) return false;
        if (endTime != task.endTime) return false;
        if (interval != task.interval) return false;
        if (active != task.active) return false;
        if (repeated != task.repeated) return false;
        return title != null ? title.equals(task.title) : task.title == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + time;
        result = 31 * result + endTime;
        result = 31 * result + interval;
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (repeated ? 1 : 0);
        return result;
    }
}
