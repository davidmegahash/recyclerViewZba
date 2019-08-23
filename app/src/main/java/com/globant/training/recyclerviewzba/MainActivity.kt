package com.globant.training.recyclerviewzba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.globant.training.recyclerviewzba.model.Item

class MainActivity : AppCompatActivity(), CustomAdapter.AdapterEvents {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        val fakeIntent = Intent(applicationContext,FakeActivity::class.java)
        val items = ArrayList<Item>()

        items.add(Item(1,"diceRoller","Today could be your lucky day!","dice_roller_icon",fakeIntent))
        items.add(Item(2,"diceRoller2","Today could be your lucky day!","about_me_icon",fakeIntent))
        items.add(Item(3,"diceRoller3","Today could be your lucky day!","trivia_icon",fakeIntent))
        items.add(Item(4,"diceRoller4","Today could be your lucky day!","more_icon",fakeIntent))

        val adapter = CustomAdapter(items,this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(item:Item){
        startActivity(item.intent)
    }
}
