package com.example.githubaccess.views.composables

import android.util.Log
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.Response.ErrorListener
import com.android.volley.VolleyError
import com.example.githubaccess.service.GithubAccessService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONArray

/**
 * Main Viewmodel responsible for fetching the data from server and managing UI state for composables.
 **/

class MainViewModel: ViewModel(), Response.Listener<JSONArray>, ErrorListener {

    private val users = mutableListOf<UserItemState>()
    lateinit var userList : JSONArray
    private val uiMutableState = MutableStateFlow(users)
    val uiState = uiMutableState.asStateFlow()
    private lateinit var githubAccessService: GithubAccessService

    fun getUserData(requestQueue: RequestQueue){
        githubAccessService = GithubAccessService.getService(requestQueue, this, this)
        githubAccessService.loadData()
    }

    override fun onResponse(response: JSONArray?) {

        userList = response!!

        uiMutableState.update {
        val newList = mutableListOf<UserItemState>()
            for (i in 0 until response.length()) {
                val userJson = response.getJSONObject(i)

                val userItem = UserItemState(
                    login = userJson.optString("login"),
                    id = userJson.optString("id").toInt(),
                    avatarUrl = userJson.optString("avatar_url")
                )
                Log.d(TAG, "onResponse: ${userItem.avatarUrl}")
                newList.add(userItem)
            }
            newList
        }
    }

    override fun onErrorResponse(error: VolleyError?) {

    }
    companion object {
        private const val TAG = "MainViewModel"
    }
}

data class UserItemState(
    var login: String = "Empty",
    var avatarUrl: String = "https://avatars.githubusercontent.com/u/1?v=4",
    var id: Int? = -1,
    var type: String? = "Default"
)
