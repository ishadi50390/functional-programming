object LetterCountApp {
  
  // Function to count total letter occurrences using map and reduce
  def countLetterOccurrences(words: List[String]): Int = {
    // Map each word to its length
    val lengths = words.map(_.length)
    
    // Use reduce to sum up the lengths
    lengths.reduce(_ + _)
  }

  def main(args: Array[String]): Unit = {
    // Example list of words
    val words = List("apple", "banana", "cherry", "date")
    
    // Call the function to count letter occurrences
    val totalLetterCount = countLetterOccurrences(words)
    
    // Print the result
    println(s"Total count of letter occurrences: $totalLetterCount")
  }
}
