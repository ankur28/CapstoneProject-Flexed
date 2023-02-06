package com.example.flexed_capstone

import android.media.Image


class WorkoutModel(

    private var id:Int,
    private var name:String,
    private var pic :Int,
    private var isFinished:Boolean,
    private var isChecked:Boolean

)
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
    fun getisFinished():Boolean{
        return isFinished
    }
    fun updateisFinished(isFinished: Boolean){
        this.isFinished=isFinished
    }
    fun getisChecked():Boolean{
        return isChecked
    }
    fun updateisChecked(isChecked: Boolean){
        this.isChecked=isChecked
    }

}