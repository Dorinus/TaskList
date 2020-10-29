package tasklist.view.remove;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tasklist.core.ViewHandler;

public class RemoveTaskController
{
  @FXML private Label descTextField;
  @FXML private Label ownerTextField;
  @FXML private Label dateTextField;
  private RemoveTaskVM viewModel;
  private ViewHandler viewHandler;


  public void init(RemoveTaskVM vm, ViewHandler vh){
    viewHandler = vh;
    viewModel = vm;

    descTextField.textProperty().bind(viewModel.descriptionProperty());
    ownerTextField.textProperty().bind(viewModel.creatorProperty());
    dateTextField.textProperty().bind(viewModel.dateProperty());

  }

  @FXML private void onGetTaskButton(ActionEvent actionEvent)
  {
    viewModel.getNextTask();
  }

  @FXML private void onBackButton(ActionEvent actionEvent)
  {
    viewModel.clear();
    viewHandler.openAllTaskView();
  }
}
