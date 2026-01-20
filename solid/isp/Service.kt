package com.solid.isp

interface Service {
    fun cardsApprovedEmail() {}
    fun upiApprovedEmail() {}
    fun allAccountData() {}
}

class CheckService : Service {
    override fun allAccountData() {}

    override fun upiApprovedEmail() {}

    override fun cardsApprovedEmail() {
        println("Card word done here")
    }
}
/*Check Service is a class for Card module so the other method are unused
but still there in class checkService, Violates ISP(Interface Segregation Principle)*/


//With ISP
interface CardService {
    fun cardsApprovedEmail() {}
}

interface UpiService {
    fun upiApprovedEmail() {}
}

interface AccountService {
    fun allAccountData() {}
}

class CardsBehaviourCheck() : CardService {
    override fun cardsApprovedEmail() {
        println("Card word done here")
    }
}
//file will be clean with out unnecessary code
