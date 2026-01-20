package com.solid.srp

/*This violate Single Responsible Principle*/
class WithOutSRP {
    fun fetchData() { /*TODO do Api data fetch here*/
    }

    fun sendEmail() {/*TODO send Email functionality here*/
    }

    fun showToast() {/*TODO Show UI Toast here*/
    }
}

//With SRP(Single Responsibility Principle) One class should have only one reason to change
class ApiService {
    fun fetchData() { /*TODO do Api data fetch here*/
    }
}

class EmailService {
    fun sendEmail() {/*TODO send Email functionality here*/
    }
}

class ShowUi {
    fun showToast() {/*TODO Show UI Toast here*/
    }
}
