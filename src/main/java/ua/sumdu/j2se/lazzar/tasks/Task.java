package ua.sumdu.j2se.lazzar.tasks;

public class Task {
    private String title;
    private int time; //== startTime for repeatable tasks
    private int endTime;
    private int interval;
    private boolean active = false;
    private boolean repeated = false;

    public Task(String title, int time){
        if (title.equals("") || time <= 0)
            throw new IllegalArgumentException("Title and/or start time are wrong");
        this.title = title;
        this.time = time;
    }

    public Task(String title, int start, int end, int interval) {
        //TODO: make checks
        if (title.equals("") || time <= 0)
            throw new IllegalArgumentException("Title or start time are wrong");
        this.title = title;
        this.time = start;
        this.endTime = end;
        this.interval = interval;
    }

    public String getTitle() {
        return this.title;
    }
    /**for non-repeatable tasks*/
    public int getTime() {
        return this.time;
    }

    public void setTime(int time) throws Exception {
        if (time <=0) throw new Exception("Wrong time");
        this.repeated = false;
        this.time = time;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setTitle(String title) throws Exception {
        if (title == "" || title == null) throw new Exception("Title is incorrect");
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

    public void setTime(int start, int end, int interval) throws Exception {
        StringBuilder message = new StringBuilder().append("Invalid value(s):\r\n");
        if (start <= 0) message.append("StartTime\r\n");
        if (end <= 0 || end <= start) message.append("EndTime\r\n");
        if (interval <= 0) message.append("Interval\r\n");
        if (message.toString().length() > 21) throw new Exception(message.toString());

        this.time = start;
        this.endTime = end;
        this.interval = interval;
        this.repeated = true;
    }

    public boolean isRepeated(){
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
