package com.example.a3_recyclerviewcustomadapterwithheaderandfooterkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a3_recyclerviewcustomadapterwithheaderandfooterkotlin.R
import com.example.a3_recyclerviewcustomadapterwithheaderandfooterkotlin.adapter.CustomAdapter
import com.example.a3_recyclerviewcustomadapterwithheaderandfooterkotlin.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()
        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(members)
        recylerView.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        members.add(Member())

        for (i in 0..30 step 1){
            if (i % 3 == 0){
                members.add(Member("Odilbek $i", "+998-97-775-17-79", false))
            }else {
                members.add(Member("Odilbek $i", "+998-97-775-17-79", true))
            }
        }

        members.add(Member())
        
        return members
    }


    fun initViews(){
        recylerView.layoutManager = GridLayoutManager(this, 1)
    }
}