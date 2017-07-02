package ch.makery.address.view


import ch.makery.address.MainApp
import scalafx.scene.control.{TextField, TableColumn, Label, Alert}
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._

import scalafx.event.ActionEvent

@sfxml
class AddMenuController{
//	choiceBox.getItems().add("Food","Drinks");
//  	private val      ID  : TextField,
//    private val    Name  : TextField,
//    private val   Price  : TextField,
//    private val Cuisine  : TextField,
//	){
//  var         AddMenuStage : Stage  = null
//  private var _menu     : Menu = null
//  var         okClicked            = false
//
//  def Menu = _menu
//  def Menu_=(x : Menu) {
//        _menu = x
//
//        ID.text = _menu.ID.value
//        Name.text = _menu.Name.value
//        Price.text = _menu.Price.toString
//        Cuisine.text = _menu.Cuisine.value.value
//  }
//
//  def handleOk(action :ActionEvent){
//
//     if (isInputValid()) {
//    _menu.ID       <== ID.text
//	_menu.Name     <== Name.text
//	_menu.Price    <== Price.text
//	_menu.Cuisine  <== Cuisine.text
//       
//        okClicked = true;
//        AddMenuStage.close()
//    }
//  }
//   def handleCancel(action :ActionEvent) {
//        AddMenuStage.close();
//  }
//  def nullChecking (x : String) = x == null || x.length == 0
//
//  def isInputValid() : Boolean = {
//    var errorMessage = ""
//
//    if (nullChecking(ID.text.value))
//      errorMessage += "No valid ID!\n"
//    if (nullChecking(Name.text.value))
//      errorMessage += "No valid name!\n"
//    if (nullChecking(Price.text.toString))
//      errorMessage += "No valid price!\n"
//    if (nullChecking(Cuisine.text.value))
//      errorMessage += "No valid Cuisine!\n"
//    }
//    if (errorMessage.length() == 0) {
//        return true;
//    } else {
//        // Show the error message.
//        val alert = new Alert(Alert.AlertType.Error){
//          initOwner(dialogStage)
//          title = "Invalid Fields"
//          headerText = "Please correct invalid fields"
//          contentText = errorMessage
//        }.showAndWait()
//
//        return false;
//    }
//   }
}