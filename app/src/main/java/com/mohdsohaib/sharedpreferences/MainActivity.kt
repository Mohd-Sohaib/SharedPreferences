package com.mohdsohaib.sharedpreferences

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mohdsohaib.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
        val editor = sharedPref.edit()

        //Store the data in SharedPrefrence , Whether user close the application data store in the SharedPrefrence
        binding.btnSave.setOnClickListener {
            val name = binding.editTextPersonName.text.toString()
            val number = binding.editTextNumber.text.toString().toLong()
            val check = binding.checkBox.isChecked

            editor.apply {
                putString("name", name)
                putLong("number", number)
                putBoolean("check", check)
                apply()
            }
        }

       // fetch store data
        binding.btnLoad.setOnClickListener {
            val name = sharedPref.getString("name", null)
            val number = sharedPref.getLong("number", 0)
            val check = sharedPref.getBoolean("check", false)

            binding.editTextPersonName.setText(name)
            binding.editTextNumber.setText(number.toString())
            binding.checkBox.isChecked = check
        }
    }

//    //Fetch the stored data onResume() Because this is what will be called when the app opens again
//    override fun onResume() {
//        super.onResume()
//
//        val sharedPref = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
//
//        val name = sharedPref.getString("name", null)
//        val number = sharedPref.getLong("number", 0)
//        val check = sharedPref.getBoolean("check",false)
//
//        binding.editTextPersonName.setText(name)
//        binding.editTextNumber.setText(number.toString())
//        binding.checkBox.isChecked = check
//    }
//
//    // Store the data in the SharedPreference in the onPause() method
//    // When the user closes the application onPause() will be called and data will be stored
//    override fun onPause() {
//        super.onPause()
//
//        val sharedPref = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
//        val editor = sharedPref.edit()
//
//        val name = binding.editTextPersonName.text.toString()
//        val number = binding.editTextNumber.text.toString().toLong()
//        val check = binding.checkBox.isChecked
//
//        editor.putString("name", name)
//        editor.putLong("number", number)
//        editor.putBoolean("check", check)
//    }
}