package com.example.lernkotlin.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.lernkotlin.data.model.ApiStudent
import com.example.lernkotlin.data.model.Student
import com.example.lernkotlin.mapper.StudentMapper
import com.example.lernkotlin.services.NetworkService
import com.example.lernkotlin.util.NetworkUtil

class MainViewModel(private val networkService: NetworkService): ViewModel(){

    fun getTopperStudent(context: Context) : Student? {

        val isNetworkConnected = NetworkUtil.isInternetConnected(context)

        return if(isNetworkConnected){
            val apiStudent = networkService.getTopperStudent()
            StudentMapper.map(apiStudent)
        }else{
            null
        }
    }


    fun getGradeOfStudent(averageMark : Int) : String{

        return  when(averageMark){
            100 -> "A+"
            in 95..99 ->  "A"
            in 90..94 ->  "B"
            else ->   "c"
        }
    }


    fun getStudentList(context: Context): List<Student> {

        val isNetworkConnected = NetworkUtil.isInternetConnected(context)

        // define immutable list.

        val studentList: MutableList<Student> = mutableListOf()

        if(isNetworkConnected){
            val apiStudentList = networkService.getStudentList()

            for(apiStudent: ApiStudent in apiStudentList){

                studentList.add(Student(apiStudent.firstName + " " + apiStudent.lastName, apiStudent.averageMark))
            }
        }

        return studentList
    }

}