package com.practice.mvpdemo.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.practice.mvpdemo.R
import com.practice.mvpdemo.adapter.ImageAdapter
import com.practice.mvpdemo.data.ImageData
import com.practice.mvpdemo.view.main.presenter.MainContract
import com.practice.mvpdemo.view.main.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    private val imageAdapter: ImageAdapter by lazy {
        ImageAdapter()
    }

    private val presenter by lazy {
        MainPresenter(
            view = this@MainActivity,
            imageData = ImageData,
            adapterView = imageAdapter,
            adapterModel = imageAdapter
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView.adapter = imageAdapter

        presenter.loadItem(this, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_reload -> {
                presenter.loadItem(this, true)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showToast(title: String) {
        Toast.makeText(this@MainActivity, "current title : $title", Toast.LENGTH_SHORT).show()
    }
}