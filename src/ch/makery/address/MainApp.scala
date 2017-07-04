package ch.makery.address
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{NoDependencyResolver, FXMLLoader}
import javafx.{scene => jfxs}
import scalafx.collections.{ObservableBuffer}
import ch.makery.address.model.{Food,Drinks,DrinkDao,FoodDao, Menu}
import scalafx.stage.{Stage, Modality}
import ch.makery.address.view.{PrintReceiptDialogController}
import ch.makery.address.view.AddFoodController


object MainApp extends JFXApp {

	var drinks = new ObservableBuffer[Drinks]()
	var food = new ObservableBuffer[Food]()
  var order = new ObservableBuffer[Menu]() 
  
	
			DrinkDao.readFromCsv()
			FoodDao.readFromCsv()
			// transform path of RootLayout.fxml to URI for resource location.
			val rootResource = getClass.getResource("view/RootLayout.fxml")
			// initialize the loader object.
			val loader = new FXMLLoader(rootResource, NoDependencyResolver)
			// Load root layout from fxml file.
			loader.load();
	    var selectedFood : Food = null
	    var selectedDrinks : Drinks = null
	    var fIndex:Int= -1
	    var dIndex:Int = -1

			// retrieve the root component BorderPane from the FXML 
			val roots = loader.getRoot[jfxs.layout.BorderPane]


					// initialize stage
					stage = new PrimaryStage {
				title = "Restaurant POS System" 
						scene = new Scene {
					root = roots    

				}
			}

			// actions for display Main page window 
			def showMainPage() = {
					val resource = getClass.getResource("view/MainPage.fxml")
							val loader = new FXMLLoader(resource, NoDependencyResolver)
							loader.load();
					val roots = loader.getRoot[jfxs.layout.AnchorPane]
							this.roots.setCenter(roots)
						
			} 

			//shows the manage menu page
			def showManageMenuPage() = {
					val resource = getClass.getResource("view/ManageMenu.fxml")
							val loader = new FXMLLoader(resource, NoDependencyResolver)
							loader.load();
					val roots = loader.getRoot[jfxs.layout.AnchorPane]
							this.roots.setCenter(roots)
							
				
			}

		
			//shows the manage menu page
			def showLoginPage() = {
			val resource = getClass.getResource("view/Login.fxml")
			val loader = new FXMLLoader(resource, NoDependencyResolver)
			loader.load();
			val roots = loader.getRoot[jfxs.layout.AnchorPane]
			this.roots.setCenter(roots)
			}

			//shows the order menu
			def showOrderMenu() = {
			val resource = getClass.getResource("view/OrderMenu.fxml")
			val loader = new FXMLLoader(resource, NoDependencyResolver)
			loader.load();
			val roots = loader.getRoot[jfxs.layout.AnchorPane]
			this.roots.setCenter(roots)
			}

			def showAddFood() = {
					val resource = getClass.getResource("view/AddFood.fxml")
					val loader = new FXMLLoader(resource, NoDependencyResolver)
					loader.load();
					val roots = loader.getRoot[jfxs.layout.AnchorPane]
							this.roots.setCenter(roots)
			}

			def showAddDrinks() = {
					val resource = getClass.getResource("view/AddDrink.fxml")
					val loader = new FXMLLoader(resource, NoDependencyResolver)
					loader.load();
					val roots = loader.getRoot[jfxs.layout.AnchorPane]
							this.roots.setCenter(roots)
			}

			//to fix - doesn't work yet
			def showPrintReceipt()={
			  val resource = getClass.getResourceAsStream("view/PrintReceiptDialog.fxml")
			  val loader = new FXMLLoader(null, NoDependencyResolver)
        loader.load(resource);
        val roots2 = loader.getRoot[jfxs.Parent]
        val control = loader.getController[PrintReceiptDialogController#Controller]
        val dialog = new Stage(){
          initModality(Modality.APPLICATION_MODAL) //to tell the program it is meant to pop up
          initOwner(stage)
          scene = new Scene{
            root = roots2
          }
        }
        control.receiptStage = dialog
        dialog.showAndWait()
        control.okClicked
  			}


			def changeSelectedFood(foodObject : Food,foodIndex:Int){
				selectedFood = foodObject
				fIndex = foodIndex
						println(selectedFood + " Ok")
			}

			def changeSelectedDrinks(drinksObject : Drinks,drinkIndex:Int){
				selectedDrinks = drinksObject
				dIndex = drinkIndex
						println(selectedDrinks + " Ok")
			}
//      def alert(mTitle:String,message:String) = {new Alert(Alert.AlertType.Error){
//        initOwner(dialogStage)
//        title = mTitle
//        headerText = "Error"
//        contentText = "Only a manager can Login"
//      }.showAndWait()
//      }
			//   call to display MainPage when app start
			showMainPage()

}
