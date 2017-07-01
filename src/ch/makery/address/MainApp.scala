package ch.makery.address
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{NoDependencyResolver, FXMLLoader}
import javafx.{scene => jfxs}
import scalafx.collections.{ObservableBuffer}
import ch.makery.address.model.Food
import ch.makery.address.model.Drinks

object MainApp extends JFXApp {
  
  val foodData = new ObservableBuffer[Food]()
    foodData += new Food(1,"Chicken Burger",8.90,"Western")
    foodData += new Food(2,"Steam Fish",30.90,"Chinese")
    foodData += new Food(3,"Biscuit",0.99,"Western")
  val drinksData = new ObservableBuffer[Drinks]()
    drinksData += new Drinks(1,"Orange Juice", 4, "TT")
    drinksData += new Drinks(1,"Watermelon Juice", 6, "GG")
    drinksData += new Drinks(1,"Guava Juice", 5, "DD")
  // transform path of RootLayout.fxml to URI for resource location.
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  // initialize the loader object.
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  // Load root layout from fxml file.
  loader.load();
  // retrieve the root component BorderPane from the FXML 
  val roots = loader.getRoot[jfxs.layout.BorderPane]
  // initialize stage
  stage = new PrimaryStage {
    title = "AddressApp"
    scene = new Scene {
      root = roots
    }
  }
  // actions for display person overview window 
  def showMainPage() = {
    val resource = getClass.getResource("view/ManageMenu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  } 
  // call to display PersonOverview when app start
  showMainPage()
}
