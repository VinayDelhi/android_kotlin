package com.example.lernkotlin.mapper

import com.example.lernkotlin.data.model.ApiStudent
import com.example.lernkotlin.data.model.Student

object  StudentMapper{

    fun map(apiStudent: ApiStudent): Student{

        return Student(apiStudent.firstName + " " + apiStudent.lastName, apiStudent.averageMark)

    }
}