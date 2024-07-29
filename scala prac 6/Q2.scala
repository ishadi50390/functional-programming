import scala.io.StdIn.readLine
import scala.util.Try

object Student{

  //  Validate user input
  def validateInput(name: String, marks: String, totalMarks: String): (Boolean, Option[String]) = {
    if (name.trim.isEmpty) {
      return (false, Some("Name cannot be empty"))
    }
    val marksInt = Try(marks.toInt).getOrElse(-1)
    val totalMarksInt = Try(totalMarks.toInt).getOrElse(-1)
    if (marksInt < 0 || totalMarksInt < 0) {
      return (false, Some("Marks must be positive integers"))
    }
    if (marksInt > totalMarksInt) {
      return (false, Some("Marks cannot exceed total possible marks"))
    }
    (true, None)
  }

  // Get student information and calculate percentage and grade
  def getStudentInfo(name: String, marks: Int, totalMarks: Int): (String, Int, Int, Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _            => 'D'
    }
    (name, marks, totalMarks, percentage, grade)
  }

  //  Print student record
  def printStudentRecord(studentRecord: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = studentRecord
    println(s"Name: $name")
    println(s"Marks: $marks/$totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  // Get student info with retry for valid input
  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var valid = false
    var studentRecord: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'D')
    while (!valid) {
      println("Enter student name:")
      val name = readLine()
      println("Enter marks obtained:")
      val marks = readLine()
      println("Enter total possible marks:")
      val totalMarks = readLine()
      validateInput(name, marks, totalMarks) match {
  case (true, _) =>
    val marksInt = marks.toInt
    val totalMarksInt = totalMarks.toInt
    studentRecord = getStudentInfo(name, marksInt, totalMarksInt)
    valid = true
  case (false, Some(errorMessage)) =>
    println(s"Invalid input: $errorMessage")
  case (false, None) =>
    println("Invalid input with no error message")
}

    }
    studentRecord
  }

  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }
}
