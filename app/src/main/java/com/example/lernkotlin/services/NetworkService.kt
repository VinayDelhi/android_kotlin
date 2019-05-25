package com.example.lernkotlin.services

import com.example.lernkotlin.data.model.ApiStudent

class NetworkService{

    fun getTopperStudent() = ApiStudent("Sunil", "Kushwaha", 90)

    fun getStudentList(): List<ApiStudent> {

       /* val listOfStudent: List<ApiStudent> = listOf(

        ApiStudent("Alok", "Gupta", 90),
        ApiStudent("Ramesh", "Gupta", 90),
        ApiStudent("Ajay", "Kumar", 90),
        ApiStudent("Amit", "Shekhar", 90),
        ApiStudent("Vinay", "Aggarwal", 90),
        ApiStudent("Neha", "Sharma", 90)
      )*/

        //TODO above code can write as inline variable as:

        return listOf(

            ApiStudent("Alok", "Gupta", 90),
            ApiStudent("Ramesh", "Gupta", 90),
            ApiStudent("Ajay", "Kumar", 90),
            ApiStudent("Amit", "Shekhar", 90),
            ApiStudent("Vinay", "Aggarwal", 90),
            ApiStudent("Neha", "Sharma", 90)
        )

    }

    fun classWiseStudentList(): Map<String, List<ApiStudent>>{

        val classAStudents: List<ApiStudent> = listOf(

            ApiStudent("Amit", "Shekhar", 90),
            ApiStudent("Vinay", "Aggarwal", 90),
            ApiStudent("Neha", "Sharma", 90)
        )

        val classBStudents: List<ApiStudent> = listOf(
            ApiStudent("Alok", "Gupta", 90),
            ApiStudent("Ramesh", "Gupta", 90),
            ApiStudent("Ajay", "Kumar", 90)
        )

        val classWiseStudents: MutableMap<String, List<ApiStudent>> = mutableMapOf(

            "ClassA" to classAStudents,
            "ClassB" to classBStudents
        )

        //classWiseStudents.put("ClassC", classAStudents)

        return classWiseStudents

    }


}