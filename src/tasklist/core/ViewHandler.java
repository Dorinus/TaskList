package tasklist.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tasklist.view.add.AddTaskController;
import tasklist.view.all.AllTaskController;
import tasklist.view.remove.RemoveTaskController;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private Scene addTaskViewScene;
  private Scene removeTaskViewScene;
  private Scene allTaskViewScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(Stage stage, ViewModelFactory viewModelFactory)
  {
    mainStage = stage;
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    openAllTaskView();
    mainStage.show();
  }

  public void openAllTaskView()
  {
    FXMLLoader loader = new FXMLLoader();
    if(allTaskViewScene == null) {
      Parent root = getRootByPath("../view/all/AlllTaskView.fxml", loader);
      AllTaskController controller= loader.getController();
      controller.init(viewModelFactory.getAllTaskVM(), this);
      allTaskViewScene = new Scene(root);
    }

    mainStage.setTitle("View tasks");
    mainStage.setScene(allTaskViewScene);

  }

  public void openAddTaskView()
  {
    FXMLLoader loader = new FXMLLoader();
    if(addTaskViewScene == null) {
      Parent root = getRootByPath("../view/add/AddTaskView.fxml", loader);
      AddTaskController controller= loader.getController();
      controller.init(viewModelFactory.getAddTaskVM(), this);
      addTaskViewScene = new Scene(root);
    }

    mainStage.setTitle("Add task");
    mainStage.setScene(addTaskViewScene);

  }

  public void openNextTaskView()
  {
    FXMLLoader loader = new FXMLLoader();
    if(removeTaskViewScene == null) {
      Parent root = getRootByPath("../view/remove/RemoveTaskView.fxml", loader);
      RemoveTaskController controller= loader.getController();
      controller.init(viewModelFactory.getRemoveTaskVM(), this);
      removeTaskViewScene = new Scene(root);
    }

    mainStage.setTitle("Next Task");
    mainStage.setScene(removeTaskViewScene);
  }

  private Parent getRootByPath(String path, FXMLLoader loader)
  {
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try
    {
      root = loader.load();

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

}
