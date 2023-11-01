package com.example.todolistroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.todolistroomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().add(R.id.framLayout,TodayTaskFragment()).commit()


        val arrSpinnerListItem = ArrayList<String>()
        arrSpinnerListItem.apply {
            add("All list")
            add("Default")
            add("Personal")
            add("Work")
            add("Shopping")
            add("Travel")
        }

        val mySpinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arrSpinnerListItem)
        binding.spinner.adapter = mySpinnerAdapter





        // default load fragment on home page
        loadFragment(TodayTaskFragment(), true)

        // on click Fragment open
        binding.btnAllTask.setOnClickListener(this)

        binding.btnTodayTask.setOnClickListener(this)

        binding.btnPendingTask.setOnClickListener(this)

        binding.btnCompletedTask.setOnClickListener(this)


    }



    override fun onClick(v: View?) {
        val id = v!!.id

        if (id==R.id.btnAllTask){
            loadFragment(AllTaskFragment(), false)
        }else if (id==R.id.btnTodayTask){
            loadFragment(TodayTaskFragment(), false)
        }else if (id==R.id.btnPendingTask){
            loadFragment(PendingTaskFragment(), false)
        }else{
            loadFragment(CompletedTaskFragment(), false)
        }

        true
    }


    // Load all Fragment on UI
    fun loadFragment(frag : Fragment, isFirst :Boolean){

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        if (isFirst){
            ft.add(R.id.framLayout, frag)
        }else{
            ft.replace(R.id.framLayout, frag)
        }
        ft.commit()
    }



}