package tasklist.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskModelManager implements TaskModel
{
  private List<Task> taskList;
  private PropertyChangeSupport support;

  public TaskModelManager()
  {
    this.taskList = new ArrayList<>();
    this.support = new PropertyChangeSupport(this);
  }

  private String calcTimeStamp(){
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date now = new Date();
    return simpleDateFormat.format(now);
  }

  @Override public void addTask(String owner, String desc)
  {
    Task task = new Task(owner, desc, calcTimeStamp());
    taskList.add(task);
    support.firePropertyChange("TaskAdded", null, task );
  }

  @Override public Task getTask()
  {
    Task removedTask = taskList.remove(0);
    support.firePropertyChange("TaskRemoved", null, removedTask);
    return removedTask;
  }

  @Override public void addPropretyChangeListener(PropertyChangeListener listener)
  {
      support.addPropertyChangeListener(listener);
  }

  @Override public void addPropretyChangeListener(String eventName, PropertyChangeListener listener)
  {
    if(eventName.equals("")) {
      addPropretyChangeListener(listener);
    }
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void removePropretyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void removePropretyChangeListener(String eventName, PropertyChangeListener listener)
  {
    if(eventName.equals("")) {
      support.removePropertyChangeListener(listener);
    }
    support.removePropertyChangeListener(eventName,listener);
  }
}
