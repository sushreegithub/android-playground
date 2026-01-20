package com.solid.lsp

open class Bird {
    open fun fly(category:String){
        println("$category Can Fly!")
    }
}

class Penguin():Bird(){
    override fun fly(category: String) {
        throw Exception("Can't fly")
    }
}

//With LSP(Don't force a child class to Use parent class function always)
open class Birds

interface Flyable{
    fun fly(){
        println("Bird can Fly")
    }
}

class Crow():Bird(), Flyable{
    override fun fly() {
        println("Crow can Fly")
    }
}
class Penguins: Bird(){

}
