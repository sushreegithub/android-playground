package com.solid.ocp

class PaymentService {
    fun pay(type: String) {
        when (type) {
            "CARD" -> println("Payment Through CARD")
            "UPI" -> println("Payment Through UPI")
        }
    }
}

/* In future if we need to add any type again we need to go for payment service pay
then we need to modify that class which is violate OCP, use Abstraction here
Note:By using above function you may get crash in run time if any one use type a COD*/

interface Payment {
    fun pay() {
    }
}

/*OCP(Open Close Principal) is responsible for open to extension but close for modification*/
class CardPaymentService() : Payment {
    override fun pay() {
        println("Payment Through CARD")
    }
}

class UPIPaymentService() : Payment {
    override fun pay() {
        println("Payment Through UPI")
    }
}

//new Class added
class CaseOnDelivery() {
    fun pay() {
        println("Payment Using COD")
    }
}
