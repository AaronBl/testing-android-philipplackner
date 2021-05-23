package com.fintecimal.testandroidphilipplackner

object RegistrationUtils {

    private val existingUser = listOf<String>("Peter","Carl")

     /*Cases
     - the input is not valid if..
     - the username or password is empty
     - the username is used
     - the confirmed password is not the same  tha the password
     - the password contains less that 2 digits
      */
     fun validateRegistrationInput(
         username : String,
         password : String,
         confirmedPaswword : String) : Boolean{
         return true


     }
}