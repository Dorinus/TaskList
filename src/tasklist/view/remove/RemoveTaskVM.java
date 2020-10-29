package tasklist.view.remove;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tasklist.model.Task;
import tasklist.model.TaskModel;

public class RemoveTaskVM
{
  private TaskModel model;
  private StringProperty description,  creator, date;

  public RemoveTaskVM(TaskModel model)
  {
    this.model = model;
    description = new SimpleStringProperty();
    creator = new SimpleStringProperty();
    date = new SimpleStringProperty();
  }



  public StringProperty descriptionProperty()
  {
    return description;
  }


  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty dateProperty()
  {
    return date;
  }

  public void getNextTask()
  {
    Task task = model.getTask();
 //   if(task != null){
      description.setValue(task.getDescription());
      creator.setValue(task.getOwner());
      date.setValue(task.getTimeCreated());
      model.getTask();

 //   }
  }

  void clear() {
    description.setValue("");
    creator.setValue("");
    date.setValue("");
  }
}
