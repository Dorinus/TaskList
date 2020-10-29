package tasklist.view.add;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tasklist.model.TaskModel;

public class AddTaskVM
{
  private StringProperty creator, description;
  private TaskModel model;


  public AddTaskVM(TaskModel model)
  {
    this.model = model;
    creator = new SimpleStringProperty();
    description = new SimpleStringProperty();
  }

  public void clear(){
    creator.setValue("");
    description.setValue("");
  }

  public void addTask(){
    model.addTask(creator.getValue(), description.getValue());
  }


  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }
}
