package tasklist.view.all;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tasklist.model.Task;
import tasklist.model.TaskModel;
import tasklist.model.TaskModelManager;

import java.beans.PropertyChangeEvent;

public class AllTaskVM
{
  private ObservableList<Task> tasks;
  private TaskModel model;

  public AllTaskVM(TaskModel model)
  {
    this.model = new TaskModelManager();
    tasks = FXCollections.observableArrayList();

    model.addPropretyChangeListener("TaskAdded" , this::listModified);
    model.addPropretyChangeListener("TaskRemoved", evt -> tasks.remove((Task) evt.getNewValue()));
  }

  private void listModified(PropertyChangeEvent event)
  {
    tasks.add((Task) event.getNewValue());
  }

  public ObservableList<Task> getTasks()
  {
    return tasks;
  }
}
