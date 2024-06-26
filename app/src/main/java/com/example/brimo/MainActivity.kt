package com.example.brimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.brimo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.itemIconTintList = null

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> replaceFragment(HomeFragment())
                R.id.navigation_mutasi -> replaceFragment(MutasiFragment())
                R.id.navigation_inbox -> replaceFragment(MailFragment())
                R.id.navigation_akun -> replaceFragment(AkunFragment())

            }
            true
        }

    }


    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayoutMain,fragment)
        fragmentTransaction.commit()
    }
}