package com.example.todolistroomdb

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistroomdb.databinding.FragmentTodayTaskBinding
import com.example.todolistroomdb.databinding.MyDialogResourceBinding


class TodayTaskFragment : Fragment() {

    lateinit var binding: FragmentTodayTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTodayTaskBinding.inflate(inflater, container , false)



        val myRoomDataBase = MyRoomDataBase.getInstance(requireContext())
        val arrNotes = myRoomDataBase.NoteDataDao().getAllNotes()


        binding.recyclerViewID.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewID.adapter = RecyclerAdapterClass(requireContext(),arrNotes as ArrayList<NoteTableModelClass>)



        binding.floatingActionButton.setOnClickListener {

            val myDialogBox = Dialog(requireContext())
            val dialogBindingVal = MyDialogResourceBinding.inflate(layoutInflater)
            myDialogBox.setContentView(dialogBindingVal.root)


            dialogBindingVal.btnSAVE.setOnClickListener {

                val myTaskTitle = dialogBindingVal.editEnterTaskTitle.text.toString()
                val myTaskDescription = dialogBindingVal.editEnterTask.text.toString()

                myRoomDataBase.NoteDataDao().addNote(NoteTableModelClass(0, myTaskTitle, myTaskDescription))
                Toast.makeText(requireContext(), "Successfully", Toast.LENGTH_SHORT).show()
                myDialogBox.dismiss()


               /* if (myTaskTitle!="" && myTaskDescription!=""){
                    arrNotes.add(NoteTableModelClass(id,myTaskTitle, myTaskDescription))
                    myRoomDataBase.addNote(myTaskTitle, myTaskDescription)
                    myRecyclerAdapterClass.notifyItemInserted(arrNotes.size-1)
                    Toast.makeText(requireContext(), "Successfully", Toast.LENGTH_SHORT).show()
                    myDialogBox.dismiss()
                }*/

            }


            dialogBindingVal.BtnClosed.setOnClickListener{
                myDialogBox.dismiss()
            }

            dialogBindingVal.btnCalender.setOnClickListener {
                Toast.makeText(requireContext(), "Open Your Calendar", Toast.LENGTH_SHORT).show()
            }
            dialogBindingVal.btnFile.setOnClickListener {
                Toast.makeText(requireContext(), "Open Your Gallery File ", Toast.LENGTH_SHORT).show()
            }

            myDialogBox.show()
        }




        return binding.root
    }
}