package ch.makery.address.model
import java.io._
import scalafx.collections.{ObservableBuffer}
import ch.makery.address.MainApp
object DrinkDao extends App{

  val pWriter = new PrintWriter(new File("drinks.csv"))
  
  
  def writeToFile(){
    
     val bw = new BufferedWriter(new FileWriter("drinks.csv"))
     for(items <- MainApp.drinks){
     var values = (items.menuId+","+items.name+","+items.price+","+items.drinkType+" ")
     bw.write(s"$values \n")
     print(values)
  }
  bw.close()
    
  }
    

    def readFromCsv(){
     
      var id:Integer = 0
      var price:Double = 0.00
      val bufferedSource = io.Source.fromFile("drinks.csv")
      
      for(line <- bufferedSource.getLines){
      val cols = line.split(",").map(_.trim)
      id = cols(0).toInt
      price=cols(2).toDouble
      MainApp.drinks += new Drinks(id,cols(1),price,cols(3))
      
    } 
      bufferedSource.close
    }
  
}
