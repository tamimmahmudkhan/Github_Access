package com.example.githubaccess

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.android.volley.toolbox.Volley
import com.example.githubaccess.service.GithubAccessService
import com.example.githubaccess.views.composables.MainView
import com.example.githubaccess.views.composables.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

lateinit var githubAccessService: GithubAccessService

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity(), HostActivity {

    val KEY_DATA = stringPreferencesKey("key_data")

    companion object{
        const val KEY_DETAILS = "user_details"
    }

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val volley = Volley.newRequestQueue(this)
        githubAccessService = GithubAccessService(volley, viewModel, viewModel)
        viewModel.getUserData(volley)
        val mainView = MainView(viewModel, this)

        enableEdgeToEdge()
        setContent {mainView.GetView()}
    }

    override fun onClickFrom(position: Int) {

//        CoroutineScope(Dispatchers.IO).launch {
//            applicationContext.dataStore.edit { settings ->
//                settings[KEY_DATA] = viewModel.userList.toString()
//            }
//        }

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

