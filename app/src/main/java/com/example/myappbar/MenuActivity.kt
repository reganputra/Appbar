package com.example.myappbar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myappbar.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            searchView.setupWithSearchBar(searchBar) // to connect searchView and searchBar
            searchView
                .editText
                .setOnEditorActionListener { textView, actionId, event ->
                    searchBar.setText(searchView.text) // take input from searchView and put it into searchBar
                    searchView.hide()
                    Toast.makeText(this@MenuActivity, searchView.text, Toast.LENGTH_SHORT).show()
                    false
                }
            searchBar.inflateMenu(R.menu.option_menu)
            searchBar.setOnMenuItemClickListener{menuItem ->
                when (menuItem.itemId) {
                    R.id.menu1 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, MenuFragment())
                            .addToBackStack(null)
                            .commit()
                        true

                    }
//                    R.id.menu2 -> {
//                        val intent = Intent(this@MenuActivity, MainActivity::class.java)
//                        startActivity(intent)
//                        true
//                    }
                    else -> false
                }
            }
        }

    }
}