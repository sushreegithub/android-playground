package com.solid.lsp

open class BaseFragment {
    open fun showToolBar(){
        println("Show Toolbar")
    }
}

class FullScreenFragment():BaseFragment(){
    override fun showToolBar() {
        throw Exception("Toolbar")
    }
}
/*Here it behave like an error and LSP violates
* Liskov Substitution Principle says if a child class can't do parent class behaviour,
* don't force inheritance. Class should be replaced by parent with out breaking code */

//Using LSP
open class BaseFragments {

}
interface ToolBarService{
    fun showToolBar(){

    }
}

class FullScreenFragments():BaseFragments(){

}