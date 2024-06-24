object TakeHomeSal extends App {
  
  
  val normalHourRate = 250
  val otHourRate = 85
  val normalHoursPerWeek = 40
  val otHoursPerWeek = 30
  val taxRate = 0.12  
  
  
  val normalHoursWorked = 40  
  val otHoursWorked = 30     
  
  
  val income1 = (normalHoursWorked * normalHourRate) + (otHoursWorked * otHourRate)
  
  val taxAmount = income1 * taxRate
  
  val takeHomeSalary = income1 - taxAmount
  
  println(s"Earnings before tax: Rs. $income1")
  println(s"Tax amount (12%): Rs. $taxAmount")
  println(s"Take-home salary: Rs. $takeHomeSalary")
}
