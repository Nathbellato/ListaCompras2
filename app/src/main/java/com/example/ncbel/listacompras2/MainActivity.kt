package com.example.ncbel.listacompras2

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_minhaLista -> {
                message.setText(R.string.title_home)
                createFragmentMinhaLista()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_itens -> {
                message.setText(R.string.title_home)
                createFragmentItens()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = note_list_recyclerview
        recyclerView.adapter = ListAdapter(notes(), this)
        val layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager


        createFragmentMinhaLista()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun notes(): List<Note>{
        return listOf(
                Note("TEste1"),
                Note("Testeeeeee2"),
                Note("eudes"))
    }



    fun createFragmentMinhaLista(){

        val transaction = manager.beginTransaction()
        val fragment = MinhaListaFragment()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    fun createFragmentItens(){

        val transaction = manager.beginTransaction()
        val fragment = ItensFragment()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }


}
