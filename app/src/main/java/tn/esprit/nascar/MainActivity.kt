package tn.esprit.nascar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import tn.esprit.nascar.R.id.fragmentContainer
import tn.esprit.nascar.databinding.ActivityMainBinding
import androidx.appcompat.widget.Toolbar



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO 11 Bind the toolbar to the activity
        val toolbar: Toolbar = binding.toolbar.appBar
        setSupportActionBar(toolbar)
        //TODO 1 Implement the click on the 3 buttons (btnNews|btnEvents|btnProfile) to call changeFragment(...)

        val btnEvents = binding.btnEvents
        val btnNews = binding.btnNews
        val btnProfile = binding.btnProfile
        //TODO 2 Implement the first call of the first fragment
        btnEvents.setOnClickListener { changeFragment(EventsFragment(), "") }
        btnNews.setOnClickListener { changeFragment(NewsFragment(), "") }
        btnProfile.setOnClickListener { changeFragment(ProfileFragment(), "") }
    }

    private fun changeFragment(fragment: Fragment, name: String) {

        //TODO 3 Check if tag is empty then replace the new fragment in the activity.
        //    If tag is not empty replace the new fragment in the activity and use addToBackStack

        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack("").commit()

    }

//TODO 12 Override the method onCreateOptionsMenu()
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_toolbar, menu)
            return super.onCreateOptionsMenu(menu)
        }


    //TODO 13 Override the method onOptionsItemSelected() and Implement info and logout behavior

}