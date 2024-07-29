object InventorySystem {

  type Product = (String, Int, Double)

  def main(args: Array[String]): Unit = {
    val inventory1: Map[Int, Product] = Map(
      101 -> ("Pens", 10, 15.0),
      102 -> ("Pencils", 5, 25.0),
      103 -> ("Erasers", 20, 10.0)
    )

    val inventory2: Map[Int, Product] = Map(
      102 -> ("Pencils", 8, 30.0),
      104 -> ("Rulers", 15, 20.0)
    )

    // Product names from inventory1
    val Names = inventory1.values.map(_._1)
    println("Product Names (Inventory1): " + Names.mkString(", "))

    // Calculate the total value of all products in inventory1
    val totalValue = inventory1.values.map { case (_, quantity, price) => quantity * price }.sum
    println(s"Total Value of Inventory1: Rs.${totalValue}")

    //  Check if inventory1 is empty
    val isInventory1Empty = inventory1.isEmpty
    println(s"Is Inventory1 empty? $isInventory1Empty")

    //  Merge inventory1 and inventory2
    val mergedInventory = mergeInventories(inventory1, inventory2)
    println("Merged Inventory: " + mergedInventory)

    // Check Products
    val productId = 102
    printProductDetails(inventory1, productId)
  }

  // Method to merge 
  def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
    inventory1 ++ inventory2.map {
      case (id, (name, quantity, price)) =>
        id -> inventory1.get(id).map {
          case (name1, quantity1, price1) =>
            (name, quantity + quantity1, math.max(price, price1))
        }.getOrElse((name, quantity, price))
    }
  }

  // Print product details
  def printProductDetails(inventory: Map[Int, Product], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some((name, quantity, price)) =>
        println(s"Product ID: $productId, Name: $name, Quantity: $quantity, Price: $$${price}")
      case None =>
        println(s"Product with ID $productId does not exist in the inventory.")
    }
  }
}
