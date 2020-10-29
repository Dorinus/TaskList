package tasklist.core;

import tasklist.view.add.AddTaskVM;
import tasklist.view.all.AllTaskVM;
import tasklist.view.remove.RemoveTaskVM;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private AllTaskVM allTaskVM;
  private AddTaskVM addTaskVM;
  private RemoveTaskVM removeTaskVM;


  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public AddTaskVM getAddTaskVM()
  {
    if(addTaskVM == null) addTaskVM = new AddTaskVM(modelFactory.getTaskModel());
    return addTaskVM;
  }

  public AllTaskVM getAllTaskVM()
  {
    if(allTaskVM== null) allTaskVM = new AllTaskVM(modelFactory.getTaskModel());
    return allTaskVM;
  }

  public RemoveTaskVM getRemoveTaskVM()
  {
    if(removeTaskVM == null) removeTaskVM = new RemoveTaskVM(modelFactory.getTaskModel());
    return removeTaskVM;
  }
}
