package com.example.githubaccess.service

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.Response.ErrorListener
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.githubaccess.model.User
import org.json.JSONArray
import org.json.JSONObject

class GithubAccessService(val volley: RequestQueue, val listener: Response.Listener<JSONArray>, val errorListener: ErrorListener) {

    private val BASE_URL = "https://api.github.com/"
    companion object{
        val USERS_API = "https://api.github.com/users"
    }
    private val USER_API = "https://api.github.com/users/"

    private val jsonArrayRequest  = JsonArrayRequest(Request.Method.GET, USERS_API, null,listener, errorListener)

    fun loadData(){
        volley.add(jsonArrayRequest)
    }

    fun loadCountsFor(url: String){
        volley.add(JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener))
    }
}