package ch.makery.address.view
import scalafx.stage.Stage
import scalafx.Includes._
import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafx.scene.control.{TableView, TableColumn, Label, Alert, ChoiceDialog}
import scalafxml.core.macros.sfxml
import ch.makery.address.model.{Food,Menu,Drinks,FoodDao,DrinkDao}
import scalafx.collections.ObservableBuffer

import scalafx.beans.property.StringProperty
import scalafx.stage.Window


@sfxml
class ManageMenuController(
		private val foodTable : TableView[Food],

		private val foodId : TableColumn[Food, String],

		private val foodName : TableColumn[Food, String],

		private val foodPrice : TableColumn[Food, String],

		private val foodCuisine : TableColumn[Food, String],

		private val drinksTable : TableView[Drinks],

		private val drinksId : TableColumn[Drinks, String],

		private val drinksName : TableColumn[Drinks, String],

		private val drinksPrice : TableColumn[Drinks, String],

		private val drinksType : TableColumn[Drinks, String]
		){

	var choiceDialogStage : Stage = null
			//loads the data into the TableView
			foodTable.items = MainApp.food
			foodId.cellValueFactory = {_.value.menuId}
      foodName.cellValueFactory  = {_.value.name}
      foodPrice.cellValueFactory = {_.value.price}
      foodCuisine.cellValueFactory = {_.value.cuisine}

      drinksTable.items = MainApp.drinks
      drinksId.cellValueFactory = {_.value.menuId}
      drinksName.cellValueFactory  = {_.value.name}
      drinksPrice.cellValueFactory = {_.value.price}
      drinksType.cellValueFactory = {_.value.drinkType}
      
      foodTable.selectionModel().selectedItem.onChange(
          if(foodTable.selectionModel().selectedItem() != null)  
          drinksTable.selectionModel().clearSelection()
            )
      drinksTable.selectionModel().selectedItem.onChange(
          if(drinksTable.selectionModel().selectedItem() != null)  
            foodTable.selectionModel().clearSelection()
            )
      
//Handles the add button event
def handleAddMenu(action : ActionEvent)={
		val choices = Seq("Food", "Drink")
				val dialog = new ChoiceDialog(defaultChoice = "Food", choices = choices){
			initOwner(choiceDialogStage)
			title = "Add"
			headerText = "Add Food or Drink"
			contentText = "Choose:"
		}

		val result = dialog.showAndWait()
		result match{
				case Some("Food") => MainApp.showAddFood
				case Some("Drink") => MainApp.showAddDrinks
				case None => 
		}
}// end of handleAdd

def handleEditMenu(action : ActionEvent)={
		val selectedFood = foodTable.selectionModel().selectedItem.value
				val selectedDrinks = drinksTable.selectionModel().selectedItem.value
				val selectedFoodIndex = foodTable.selectionModel().selectedIndex.value
				val selectedDrinkIndex = drinksTable.selectionModel().selectedIndex.value
				if(selectedFood !=null){
					MainApp.changeSelectedFood(selectedFood,selectedFoodIndex)
					MainApp.showAddFood
				}
		if(selectedDrinks !=null){
			MainApp.changeSelectedDrinks(selectedDrinks,selectedDrinkIndex)
			MainApp.showAddDrinks
		}
}

def handleDeleteMenu(action : ActionEvent)={
				val selectedFoodIndex = foodTable.selectionModel().selectedIndex.value
				val selectedDrinkIndex = drinksTable.selectionModel().selectedIndex.value
				var deleteBuffer : ObservableBuffer[Menu] = null
				if (selectedFoodIndex >= 0 && selectedDrinkIndex < 0) {	
					MainApp.food.remove(n=selectedFoodIndex,count =1)
					FoodDao.writeToFile()		 
					foodTable.selectionModel().clearSelection()

				} else if (selectedDrinkIndex >= 0 && selectedFoodIndex < 0) {				  
					MainApp.drinks.remove(n=selectedDrinkIndex,count =1)
					DrinkDao.writeToFile()	
					drinksTable.selectionModel().clearSelection()

				} else {
					foodTable.selectionModel().clearSelection()
					drinksTable.selectionModel().clearSelection()
				}



}

def handleCancel(action : ActionEvent)={
		MainApp.showLoginPage
}

}