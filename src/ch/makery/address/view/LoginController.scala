package ch.makery.address.view
import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{TextField, PasswordField, Alert}

@sfxml
class LoginController (
    private val userIDField : TextField,
    private val passwordField: PasswordField
    ){
  
  var dialogStage : Stage = null
  var loginClicked = false
  
  
  //to check the login information
  def handleLogin (action: ActionEvent){
    if(!userIDField.text.value.equals(null) && !passwordField.text.value.equals(null)){
    if (userIDField.text.value.equals("admin") && passwordField.text.value.equals("abc123")){
      MainApp.showManageMenuPage()
    } else //error message if wrong input
    {
     val alert = new Alert(Alert.AlertType.Error){
        initOwner(dialogStage)
        title = "Invalid user ID or Password!"
        headerText = "Please try again"
        contentText = "Only a manager can Login"
      }.showAndWait()
    
    }
  } //end of if checking
      }//end of method 
  
  
  //when cancel is clicked -> lead back to main page
  def handleCancel(action: ActionEvent){
   MainApp.showMainPage()
  }
  
  
}//end of class