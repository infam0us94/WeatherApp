package com.example.myweatherapp

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.myweatherapp.repository.entity.CurrentWeatherEntry
import com.example.myweatherapp.weather.current.CurrentWeatherFragment
import com.example.myweatherapp.weather.current.future.list.FutureListWeatherFragment
import com.google.android.material.navigation.NavigationView
import com.mxn.soul.flowingdrawer_core.ElasticDrawer
import com.mxn.soul.flowingdrawer_core.ElasticDrawer.OnDrawerStateChangeListener
import com.mxn.soul.flowingdrawer_core.FlowingDrawer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
//     private lateinit var drawer: FlowingDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        flowingDrawer()

//        drawer = findViewById(R.id.drawer_layout)
//        val navigationView: NavigationView = findViewById(R.id.id_container_menu)
//        navigationView.setNavigationItemSelectedListener(this)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottom_nav.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }

    fun flowingDrawer() {
        val mDrawer: FlowingDrawer = findViewById(R.id.drawer_layout)
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL)
        mDrawer.setOnDrawerStateChangeListener(object : OnDrawerStateChangeListener {
            override fun onDrawerStateChange(oldState: Int, newState: Int) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivity", "Drawer STATE_CLOSED")
                }
            }

            override fun onDrawerSlide(openRatio: Float, offsetPixels: Int) {
                Log.i("MainActivity", "openRatio=$openRatio ,offsetPixels=$offsetPixels")
            }
        })

        supportFragmentManager.beginTransaction()
            .add(R.id.menulayout, FutureListWeatherFragment.newInstance())
            .commit()
    }

//    override fun onNavigationItemSelected(p0: MenuItem): Boolean {

//    }
}

