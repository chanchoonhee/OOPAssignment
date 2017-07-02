package ch.makery.address
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{NoDependencyResolver, FXMLLoader}
import javafx.{scene => jfxs}
import scalafx.collections.{ObservableBuffer}
import ch.makery.address.model.{Food,Drinks,DrinkDao,FoodDao}


object MainApp extends JFXApp {
  var drinks = ObservableBuffer[Drinks]()
    drinks += new Drinks(8,"Iced Lemon Tea", 5.00, "Cold")
    drinks += new Drinks(9,"Iced Tea", 2.00, "Cold")
  val food = new ObservableBuffer[Food]()
    food += new Food(1,"Chicken Burger",8.90,"Western")
    food += new Food(2,"Steam Fish",30.90,"Chinese")
    food += new Food(3,"Biscuit",0.99,"Western")


  // transform path of RootLayout.fxml to URI for resource location.
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  // initialize the loader object.
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  // Load root layout from fxml file.
  loader.load();

  // retrieve the root component BorderPane from the FXML 
  val roots = loader.getRoot[jfxs.layout.BorderPane]
     
  DrinkDao.writeToFile()
  FoodDao.writeToFile()
   DrinkDao.readFromCsv()
   FoodDao.readFromCsv()
 
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
  
  def showManageMenuPage() = {
    val resource = getClass.getResource("view/ManageMenu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
//   call to display MainPage when app start
  showMainPage()
  

  

  
}
