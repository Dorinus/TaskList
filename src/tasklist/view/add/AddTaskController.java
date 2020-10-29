package tasklist.view.add;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tasklist.core.ViewHandler;

public class AddTaskController
{
  @FXML private TextField creatorTextField;
  @FXML private  TextField descTextField;
  private ViewHandler viewHandler;
  private AddTaskVM viewModel;

  public void init(AddTaskVM vm , ViewHandler vh){
    viewHandler = vh;
    viewModel = vm;

    creatorTextField.textProperty().bindBidirectional(vm.creatorProperty());
    descTextField.textProperty().bindBidirectional(vm.descriptionProperty());
  }




  @FXML private  void onAddButton(ActionEvent actionEvent)
  {
    viewModel.addTask();
    viewModel.clear();
  }

  @FXML private  void onBackButton(ActionEvent actionEvent)
  {
    viewModel.clear();
    viewHandler.openAllTaskView();
  }
}
