package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{TextField, TableColumn, TableView, Label, Alert}
import ch.makery.address.model.{Food, Drinks, Menu}

@sfxml
class PrintReceiptDialogController (
    private val receiptTable : TableView[Menu],
    private val receiptName : TableColumn[Menu, String],
    private val receiptPrice: TableColumn[Menu, String],
    private val receiptID: TableColumn[Menu,String],
    private val totalLabel: Label
    )
    {
  receiptTable.items = MainApp.order
  receiptID.cellValueFactory = {_.value.menuId}
  receiptName.cellValueFactory = {_.value.menuId}
  receiptPrice.cellValueFactory = {_.value.menuId}
  
  var sum : Double = 0.00
  for (items <- MainApp.order){
      sum += items.price.value.toDouble
    }
    
    totalLabel.text = "555"
    
  //to check this command line
  var receiptStage : Stage  = null
  
  
  def handlePrint(action : ActionEvent){ 
    }
    
  def handleCancel(action : ActionEvent){
  }
    
    
}