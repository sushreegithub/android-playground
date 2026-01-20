package com.solid.dip

class LoginRepository(){
   suspend fun fetchApiCall(){
        //api fetch here
        //set data
    }
}
class LoginViewModel {
    private val repo = LoginRepository()
}
/*Higher level class depend on lower level class and this two are tightly coupled so
* testing, maintaining will be very hard and we are not able to do mock that repo
* it violates the DIP because LoginViewModel is dependent on concrete class LoginRepository But

* * As per DIP(Dependency Inversion Principle) Both should depend on abstraction */

interface LogOutRepo{
    suspend fun doLogOut(): Result<String>
}

class LogOutViewModel(private val repo:LogOutRepo){
    suspend fun doWork(){
        repo.doLogOut()
    }
}
