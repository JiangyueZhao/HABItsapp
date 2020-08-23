package me.aprilian.coinbasesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.hilt.android.AndroidEntryPoint
import me.aprilian.coinbasesample.databinding.ActivityMainBinding
import me.aprilian.coinbasesample.utils.extension.setupWithNavController

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private 