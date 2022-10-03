package ke.co.osl.kiambufarmermappingapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var back: ImageView
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarToggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var navView: NavigationView
    lateinit var editor: SharedPreferences.Editor
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.appbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer)
        navView = findViewById(R.id.nav_view)

        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, 0,0)

        drawerLayout.addDrawerListener(actionBarToggle)
        actionBarToggle.isDrawerIndicatorEnabled
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        actionBarToggle.syncState()

        preferences = this.getSharedPreferences("farmermappingapp", MODE_PRIVATE)
        editor = preferences.edit()

        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Collect Data"))
        tabLayout.addTab(tabLayout.newTab().setText("Update Data"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MyAdapter(this, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        navView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> implementHome()
                R.id.nav_farmerdetails -> editFarmerDetails()
                R.id.nav_farmeraddress -> editFarmerAddress()
                R.id.nav_farmerassociations -> editFarmerAssociations()
                R.id.nav_farmerresources -> editFarmerResources()
                R.id.nav_valuechains -> editValueChains()
                R.id.logout -> logout()
            }

            true
        }

    }

    private fun implementHome() {
       startActivity(Intent(this, MainActivity::class.java))
    }

    private fun editUpdateProduce() {
        startActivity(Intent(this, UpdateProduce::class.java))
    }

    private fun editValueChains() {
        startActivity(Intent(this, ValueChains::class.java))
    }

    private fun editFarmerResources() {
        startActivity(Intent(this, FarmerResources::class.java))
    }

    private fun editFarmerAddress() {
        startActivity(Intent(this, FarmerAddress::class.java))
    }

    private fun editFarmerAssociations() {
        startActivity(Intent(this, FarmerAssociations::class.java))
    }

    private fun editFarmerDetails() {
        startActivity(Intent(this, FarmerDetails::class.java))
    }

    private fun logout() {
        editor.remove("token")
        editor.commit()
        startActivity(Intent(this@MainActivity, LoginPage::class.java))
        finish()
    }



}

