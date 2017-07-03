package ch.makery.address.view
import ch.makery.address.MainApp
import scalafx.scene.control.{TextField, TableColumn, Label, Alert}
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import ch.makery.address.model.{Food,FoodDao}
import scalafx.collections.ObservableBuffer

import scalafx.event.ActionEvent

@sfxml
class AddFoodController (
		private val foodIDField : TextField,
		private val    foodNameField  : TextField,
		private val   foodPriceField  : TextField,
		private val cuisineField  : TextField
		){
  var mode : String = "Add"
	var AddFoodStage : Stage  = null
	private var food     : Food = null
	var         okClicked            = false
	//checks whether is edit mode and sets it.
	if(MainApp.selectedFood != null){
				print(MainApp.selectedFood)
				foodIDField.text = MainApp.selectedFood.menuId.value
				foodIDField.disable = true
				foodNameField.text = MainApp.selectedFood.name.value
				foodPriceField.text = MainApp.selectedFood.price.value
				cuisineField.text = MainApp.selectedFood.cuisine.value
				cuisineField.disable = true
				mode = "Edit"
			}

	
def handleOk(action :ActionEvent){
 
	mode match{
	case "Add" => {
	  if (isInputValid()) {

		food= new Food(foodIDField.text.value ,foodNameField.text.value ,foodPriceField.text.value.toDouble,cuisineField.text.value)
				MainApp.food+= food
				FoodDao.writeToFile()
				okClicked = true
				MainApp.showManageMenuPage


	}
	}
	
	case "Edit" =>
	  
	}

	
}
def handleCancel(action :ActionEvent) {
	MainApp.selectedFood = null
			MainApp.selectedDrinks = null
			MainApp.showManageMenuPage
 
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
							if (nullChecking(cuisineField.text.value))
								errorMessage += "No valid cuisine!\n"
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



