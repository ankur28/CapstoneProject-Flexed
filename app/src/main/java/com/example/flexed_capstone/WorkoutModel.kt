package com.example.flexed_capstone


class WorkoutModel(

    private var id:Int,
    private var name:String,
    private var pic :Int,
    private var isFinished:Boolean,
    private var isChecked:Boolean

): java.io.Serializable
{
    fun getId(): Int{
        return id
    }
    fun updateId(id:Int){
        this.id=id
    }
    fun getName(): String{
        return name
    }
    fun updateName(name:String){
        this.name=name
    }
    fun getPic():Int{
        return pic
    }
    fun updatePic(pic:Int){
        this.pic =pic
    }
    fun getIsFinished():Boolean{
        return isFinished
    }
    fun updateIsFinished(isFinished: Boolean){
        this.isFinished=isFinished
    }
    fun getIsChecked():Boolean{
        return isChecked
    }
    fun updateIsChecked(isChecked: Boolean){
        this.isChecked=isChecked
    }
}