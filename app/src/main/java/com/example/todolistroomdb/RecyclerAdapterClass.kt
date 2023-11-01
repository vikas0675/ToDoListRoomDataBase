package com.example.todolistroomdb

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistroomdb.databinding.TaskRowResourceBinding

class RecyclerAdapterClass (val myContext: Context, val arrDataVal : ArrayList<NoteTableModelClass>):
    RecyclerView.Adapter<RecyclerAdapterClass.ViewHolderClass>() {


    class ViewHolderClass (val bindingClass: TaskRowResourceBinding) : RecyclerView.ViewHolder(bindingClass.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        return ViewHolderClass(TaskRowResourceBinding.inflate(LayoutInflater.from(myContext), parent, false))
    }


    override fun getItemCount(): Int {
        return arrDataVal.size
    }


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        // holder.bindingClass.imageTaskFile.setImageResource(arrDataVal[position].imgDataModel)
        holder.bindingClass.TitleID.text = arrDataVal[position].taskTitle
        holder.bindingClass.TaskID.text = arrDataVal[position].taskDesc

        holder.bindingClass.btnUpdateItemCardView.setOnClickListener {
            myContext.startActivity(
                Intent(myContext, SecondActivity::class.java).putExtra("id", arrDataVal[position].userId)
                .putExtra("taskTitle",arrDataVal[position].taskTitle)
                .putExtra("taskDescription", arrDataVal[position].taskTitle)

            )

        }
    }



}