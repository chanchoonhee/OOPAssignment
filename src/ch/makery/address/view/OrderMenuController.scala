package ch.makery.address.view

import ch.makery.address.MainApp

import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{Label,TableColumn, TextInputDialog, TableView}
import ch.makery.address.model.Food
import ch.makery.address.model.Drinks

@sfxml
class OrderMenuController(
    private val foodTable : TableView[Food],
    private val foodId : TableColumn[Food, String],
    private val foodName : TableColumn[Food, String],
    private val foodPrice : TableColumn[Food, String],
    private val drinksTable : TableView[Drinks],
    private val drinksId : TableColumn[Drinks, String],
    private val drinksName : TableColumn[Drinks, String],
    private val drinksPrice : TableColumn[Drinks, String],
    )
    {
  
  foodTable.items = MainApp.food
  foodId.cellValueFactory = {_.value.menuId}
  foodName.cellValueFactory  = {_.value.name}
  foodPrice.cellValueFactory = {_.value.price}

  drinksTable.items = MainApp.drinks
  drinksId.cellValueFactory = {_.value.menuId}
  drinksName.cellValueFactory  = {_.value.name}
  drinksPrice.cellValueFactory = {_.value.price}
  
  def handleBack (action: ActionEvent){
    MainApp.showMainPage
  }
  
  //alert box to add the quantity
  def handleAdd (action : ActionEvent){ 
  }
  
  
  def handleDelete (action : ActionEvent){
  }
  
  
  def handleConfirm (action: ActionEvent){
  }
  
}//end of class
