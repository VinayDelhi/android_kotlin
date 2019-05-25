package com.example.lernkotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.lernkotlin.R
import com.example.lernkotlin.data.model.Student
import com.example.lernkotlin.ui.StudentListAdapter.StudentViewHolder
import com.example.lernkotlin.util.listner.OnRecyclerViewItemClickListner

class StudentListAdapter(
    private val clickListener: (String) -> Unit
): Adapter<StudentViewHolder>(){

    private var studentList: List<Student>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= StudentViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_student_view,parent,false),
    clickListener)

    override fun getItemCount() = studentList?.size?:0

    override fun onBindViewHolder(viewholder: StudentViewHolder, position: Int) {

        /*val list = studentList
        if(list != null){
            viewholder.onBind(list[position])
        }*/

        studentList?.let {
            viewholder.onBind(it[position])
        }

    }

    fun updateStudentList(list: List<Student>){

        studentList = list
        notifyDataSetChanged()
    }

    class StudentViewHolder(itemView: View, private val clickListener: (String) -> Unit):
            RecyclerView.ViewHolder(itemView){

        fun onBind(student: Student){

            val studentNameTv = itemView.findViewById<TextView>(R.id.studentName)
            studentNameTv.text = student.userName
            studentNameTv.setOnClickListener{
                clickListener(student.userName)
            }
        }
    }
}
