package tasklist.view.all;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tasklist.core.ViewHandler;
import tasklist.model.Task;

public class AllTaskController
{

  @FXML private TableView<Task> tableView;
  @FXML private TableColumn<String , Task> creatorColumn;
  @FXML private TableColumn<String , Task> descColumn;
  @FXML private TableColumn<String , Task> dateColumn;
  private ViewHandler viewHandler;

  public void init( AllTaskVM vm, ViewHandler viewHandler){
    this.viewHandler = viewHandler;

    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("owner"));
    descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
    tableView.setItems(vm.getTasks());


  }



  @FXML private void onAddButton(ActionEvent actionEvent)
  {
    viewHandler.openAddTaskView();
  }

  @FXML private void onNextTask(ActionEvent actionEvent)
  {
    viewHandler.openNextTaskView();
  }
}
