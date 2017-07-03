package ch.makery.address.view

import ch.makery.address.MainApp

import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{Label,TableColumn, TextInputDialog, TableView}
import ch.makery.address.model.{Food, Drinks, Menu}



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
    private val orderTable : TableView[Menu],
    private val orderName : TableColumn[Menu, String],
    private val orderPrice: TableColumn[Menu, String]
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
  
  
  def handleAdd (action : ActionEvent){ 
    val selected = foodTable.selectionModel().selectedItem.value
    MainApp.order += selected.asInstanceOf[Menu]
    orderTable.items = MainApp.order
    //store the selected into the the order table
    displayOrder()
    
  }
  
  
  def handleDelete (action : ActionEvent){
    val selected = orderTable.selectionModel().selectedItem.value
    orderTable.items().remove(selected)
  }
  
  def handleClear (action : ActionEvent) {
    print("\nHello World")
    MainApp.order.clear()
    displayOrder()
  }
  
  
  def handleConfirm (action: ActionEvent){
    print("\nHello World")
    //print()
    //doesnt work yet. Need to show the receipt
    MainApp.showPrintReceipt
  }
  
  
  //method for displaying order
  def displayOrder() {
    for(items <- MainApp.order){
      print("\n"+items.name)
      orderName.cellValueFactory = {_.value.name}
      orderPrice.cellValueFactory= {_.value.price}
    }
  }
  
}//end of class
