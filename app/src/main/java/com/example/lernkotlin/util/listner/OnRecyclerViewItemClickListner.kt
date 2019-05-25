package com.example.lernkotlin.util.listner

import com.example.lernkotlin.data.model.Student

interface OnRecyclerViewItemClickListner {

    fun onItemClick(student: Student)
}