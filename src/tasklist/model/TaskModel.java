package tasklist.model;

public interface TaskModel extends PropretyChangeSubject
{
  void addTask(String owner, String desc);
  Task getTask();
}
