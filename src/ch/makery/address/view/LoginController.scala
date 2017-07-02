package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{TextField, PasswordField}



@sfxml
class LoginController (
    private val userIDField : TextField,
    private val passwordField: PasswordField
    ){
  
  var dialogStage : Stage = null
  var loginClicked = false
  
  
  //to check the login information
  def handleLogin (action: ActionEvent){
    print("Hello World")
    //if (userIDField.text == "admin" && passwordField.text == "abc123"){
      //print("Hello World")
    //}
  }
  
  //when cancel is clicked -> lead back to main page
  def handleCancel(action: ActionEvent){
    MainApp.showMainPage
  }
  
  
}//end of class