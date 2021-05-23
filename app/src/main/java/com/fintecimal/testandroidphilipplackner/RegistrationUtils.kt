package com.fintecimal.testandroidphilipplackner

object RegistrationUtils {

    private val existingUsers = listOf<String>("Peter","Carl")

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
         confirmedPassword : String) : Boolean{
         if(username.isEmpty() || password.isEmpty()) {
             return false
         }
         if(username in existingUsers) {
             return false
         }
         if(password != confirmedPassword) {
             return false
         }
         if(password.count { it.isDigit() } < 2) {
             return false
         }
         return true

     }
}