package ch.makery.address.view
import ch.makery.address.MainApp
import scalafx.scene.control.{TextField, TableColumn, Label, Alert}
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import ch.makery.address.model.{Food,Drinks}
import scalafx.collections.ObservableBuffer

import scalafx.event.ActionEvent

@sfxml
class AddFoodController (
    private val foodIDField : TextField,
    private val    foodNameField  : TextField,
    private val   foodPriceField  : TextField,
    private val cuisineField  : TextField
	){
  var         AddFoodStage : Stage  = null
  private var _food     : Food = null
  var         okClicked            = false

  def Food = _food
  def Food_=(x : Food) {
        _food = x
         
        foodIDField.text = _food.menuId.value
        foodNameField.text = _food.name.value
        foodPriceField.text = _food.price.toString
//      cuisineField.text = _food.cuisine.value
  }

  def handleOk(action :ActionEvent){

     if (isInputValid()) {
    _food.menuId       <== foodIDField.text
	_food.name    <== foodNameField.text
	_food.price    <== foodPriceField.text
//	_food.cuisine  <== cuisineField.text
       
        okClicked = true;
        AddFoodStage.close()
    }
  }
   def handleCancel(action :ActionEvent) {
        AddFoodStage.close();
  }
  def nullChecking (x : String) = x == null || x.length == 0

  def isInputValid() : Boolean = {
    var errorMessage = ""

    if (nullChecking(foodIDField.text.value))
      errorMessage += "No valid ID!\n"
    if (nullChecking(foodNameField.text.value))
      errorMessage += "No valid name!\n"
    if (nullChecking(foodPriceField.text.toString))
      errorMessage += "No valid price!\n"
//    if (nullChecking(cuisineField.text.value))
//      errorMessage += "No valid cuisine!\n"
      if (errorMessage.length() == 0) {
        return true;
    } else {
        // Show the error message.
        val alert = new Alert(Alert.AlertType.Error){
          initOwner(AddFoodStage)
          title = "Invalid Fields"
          headerText = "Please correct invalid fields"
          contentText = errorMessage
        }.showAndWait()

        return false;
    }
    }
    
   }


  
