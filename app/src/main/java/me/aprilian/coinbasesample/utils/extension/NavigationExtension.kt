
package me.aprilian.coinbasesample.utils.extension

import android.content.Intent
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import android.util.SparseArray
import androidx.core.util.forEach
import androidx.core.util.set
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import me.aprilian.coinbasesample.R

//Reference: https://proandroiddev.com/step-by-step-to-bottom-navigation-with-jetpacks-navigation-component-and-multiple-nav-graphs-271c05af1dd3

fun BottomNavigationView.setupWithNavController(
    navGraphIds: List<Int>,
    fragmentManager: FragmentManager,
    containerId: Int,
    intent: Intent
): LiveData<NavController> {

    // Map of tags
    val graphIdToTagMap = SparseArray<String>()
    // Result. Mutable live data with the selected controlled
    val selectedNavController = MutableLiveData<NavController>()

    var firstFragmentGraphId = 0

    // First create a NavHostFragment for each NavGraph ID
    navGraphIds.forEachIndexed { index, navGraphId ->