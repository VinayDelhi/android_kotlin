package com.example.lernkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lernkotlin.R
import com.example.lernkotlin.data.model.ApiStudent
import com.example.lernkotlin.data.model.Student
import com.example.lernkotlin.services.NetworkService
import com.example.lernkotlin.util.NetworkUtil
import com.example.lernkotlin.util.listner.OnRecyclerViewItemClickListner

class MainActivity2 : AppCompatActivity(), OnRecyclerViewItemClickListner {

    companion object {

        val TAG = "MainActivity"
    }

    // UI Attributr
    private lateinit var topperStudentBtn: Button
    private lateinit var studentListBtn: Button
    private lateinit var topperStudentTv: TextView
    private lateinit var studentGradeBtn: Button
    private lateinit var studentListRv: RecyclerView


   // Object

    private lateinit var studentListAdapter: StudentListAdapter
    private lateinit var mainViewModel: MainViewModel
    private  var topperStudent: Student? = null


    // lambda function can assign to a variable, can pass to a method and
    // constructor.
    private val lamdaFunction: (String)-> Unit = {

        print(it)
    }

    private val lamdaFunction1: (String)-> Unit = {value ->

        print(value)
    }

    // implement onclick listner with lamda function
    private val clickListner: (String)-> Unit = {userName ->

        Toast.makeText(this, userName, Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setupRecyclerView()
    }
    private fun init(){

        mainViewModel = MainViewModel(NetworkService())
        topperStudentBtn = findViewById<Button>(R.id.activity_main_topperStudentBtn)
        topperStudentTv = findViewById(R.id.activity_main_TopperStudentTv)
        studentGradeBtn = findViewById(R.id.activity_main_StudentGradeBtn)
        studentListBtn = findViewById(R.id.activity_main_StudentListBtn)

        // Lambda function as parameter in onClickMethod()
        topperStudentBtn.setOnClickListener{view ->

            topperStudent = mainViewModel.getTopperStudent(this@MainActivity2)
            topperStudentTv.text = topperStudent?.userName

        }

        // Lambda function as parameter in onClickMethod()
        studentGradeBtn.setOnClickListener{view ->

            val grade = mainViewModel.getGradeOfStudent(topperStudent!!.averageMark)
            Toast.makeText(this@MainActivity2, grade, Toast.LENGTH_LONG).show()
        }


        studentListBtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                val studentList = mainViewModel.getStudentList(this@MainActivity2)

                studentListAdapter.updateStudentList(studentList)
            }

        })

    }


    private fun setupRecyclerView(){
        // Java

        /*RecyclerView cardsLV = (RecyclerView) findViewById(R.id.ObinoID_NotificationScreen_CardsList);

        cardsLV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));*/

        studentListRv = findViewById(R.id.activity_main_StudentRv)

        // Adapter

        studentListAdapter = StudentListAdapter(clickListner)

        studentListRv.adapter = studentListAdapter

        studentListRv.layoutManager = LinearLayoutManager(this)

    }

    override fun onItemClick(student: Student) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        Toast.makeText(this@MainActivity2, student.userName, Toast.LENGTH_LONG).show()
    }

}

