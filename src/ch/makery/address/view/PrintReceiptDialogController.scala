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
    private val totalLabel: Label,
    private val paidField : TextField,
    private val balanceField: TextField
    )
    {
  receiptTable.items = MainApp.order
  receiptID.cellValueFactory = {_.value.menuId}
  receiptName.cellValueFactory = {_.value.name}
  receiptPrice.cellValueFactory = {_.value.price}
  
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
      okClicked = true
      receiptStage.close()
    }
    
  def handleCancel(action : ActionEvent){
    receiptStage.close()
  }
  
  def countBalance(action : ActionEvent){
    var paid = paidField.text.value.toDouble
    
    if (paid < sum || paid == null){
      val alert = new Alert(Alert.AlertType.Error){
        initOwner(dialogStage)
        title = "Invalid Amount"
        headerText = "Please Enter Correct Amount"
        contentText = "Amount Paid Must Be Higher Than Total"
      }.showAndWait()
    } else 
    {
    var balance = paid - sum
    balanceField.text = (f"$balance%.2f")
    }
  }
    
    
}