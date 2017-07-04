package ch.makery.address.view

import ch.makery.address.MainApp
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{TextField, TableColumn, TableView, Label, Alert}
import ch.makery.address.model.{Food, Drinks, Menu}
import scala.util.control.Exception

@sfxml
class PrintReceiptDialogController (
    private val receiptTable : TableView[Menu],
    private val receiptName : TableColumn[Menu, String],
    private val receiptPrice: TableColumn[Menu, String],
    private val receiptID: TableColumn[Menu,String],
    private val totalLabel: Label,
    private val paidField : TextField,
    private val balanceField: TextField
    )
    {
  receiptTable.items = MainApp.order
  receiptID.cellValueFactory = {_.value.menuId}
  receiptName.cellValueFactory = {_.value.name}
  receiptPrice.cellValueFactory = {_.value.price}
  
  var paid : Double = 0.00
  var sum : Double = 0.00
  for (items <- MainApp.order){
      sum += items.price.value.toDouble
    }
    totalLabel.text = (f"$sum%.2f")
    
  //to check this command line
  var dialogStage : Stage = null
  var receiptStage : Stage  = null
  var okClicked = false
  
  def handlePrint(action : ActionEvent){ 
      if (paid <= 0){
        MainApp.alert("Invalid Amount","Please Enter Correct Amount And Press Enter","Amount Paid Must Be Higher Than Total")
      }else
      {
      okClicked = true
      receiptStage.close()
      MainApp.order.clear()
      }
    }
    
  def handleCancel(action : ActionEvent){
    receiptStage.close()
  }
  
  def countBalance(action : ActionEvent){
    try
    {
      paid = paidField.text.value.toDouble
    }catch {
    case e: Exception => MainApp.alert("Invalid Entry","Please Enter Numbers Only","Only inputs from 0-9 and '.' is acceptable")
    paid = 0.00
    }
    
    if (paid < sum && paid != 0){
      MainApp.alert("Invalid Amount","Please Enter Correct Amount","Amount Paid Must Be Higher Than Total")
    } else if (paid >= sum){
    var balance = paid - sum
    balanceField.text = (f"$balance%.2f")
    }
  }
    
    
}