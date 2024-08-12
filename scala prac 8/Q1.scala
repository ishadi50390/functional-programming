object CaesarCipher {
  
  // Function to encrypt
  def encryptCaesar(plaintext: String, shift: Int): String = {
    plaintext.map { char =>
      if (char.isLetter) {
        val shiftBase = if (char.isUpper) 'A' else 'a'
        ((char - shiftBase + shift) % 26 + shiftBase).toChar
      } else {
        char
      }
    }
  }

  // Function to decrypt
  def decryptCaesar(ciphertext: String, shift: Int): String = {
    ciphertext.map { char =>
      if (char.isLetter) {
        val shiftBase = if (char.isUpper) 'A' else 'a'
        ((char - shiftBase - shift + 26) % 26 + shiftBase).toChar
      } else {
        char
      }
    }
  }
}

object Cipher {
  
  // General function 
  def caesarCipher(data: String, shift: Int, mode: String = "encrypt"): String = {
    mode.toLowerCase match {
      case "encrypt" => CaesarCipher.encryptCaesar(data, shift)
      case "decrypt" => CaesarCipher.decryptCaesar(data, shift)
    }
  }
}

object Main extends App {
  
  val plaintext = "Ishadi"
  val shift = 3

  // Encrypt the plaintext
  val encryptedMessage = Cipher.caesarCipher(plaintext, shift, "encrypt")
  println(s"Encrypted: $encryptedMessage")

  // Decrypt the  encrypted message 
  val decryptedMessage = Cipher.caesarCipher(encryptedMessage, shift, "decrypt")
  println(s"Decrypted: $decryptedMessage")
}
