package com.example.githubaccess

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.android.volley.toolbox.Volley
import com.example.githubaccess.views.composables.MainView
import com.example.githubaccess.views.composables.MainViewModel

/**
 * Main activity. Responsible for initializing the view model and MainView for displaying userlist.
 **/

class MainActivity : ComponentActivity(), HostActivity {

    companion object{
        const val KEY_DETAILS = "user_details"
    }

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val volley = Volley.newRequestQueue(this)
        viewModel.getUserData(volley)
        val mainView = MainView(viewModel, this)

        enableEdgeToEdge()
        setContent {mainView.GetView()}
    }

    override fun onClickFrom(position: Int) {

        val intent = Intent( this, UserDetailsActivity::class.java)
        val bundle = Bundle().apply {
            putString(KEY_DETAILS, viewModel.userList.getJSONObject(position).toString())
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }
}

interface HostActivity {
    fun onClickFrom(position: Int)
}

