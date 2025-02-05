package com.example.githubaccess.service

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.Response.ErrorListener
import com.android.volley.toolbox.JsonArrayRequest
import org.json.JSONArray


/**
 * Service class to access github USERS API.
 * Encapsulates the github api from the app logic
 **/


class GithubAccessService private constructor(
    private val volley: RequestQueue,
    listener: Response.Listener<JSONArray>,
    errorListener: ErrorListener
) {

    companion object {
        const val USERS_API = "https://api.github.com/users"
        private var githubAccessService: GithubAccessService? = null


        fun getService(
            volley: RequestQueue,
            listener: Response.Listener<JSONArray>,
            errorListener: ErrorListener
        ): GithubAccessService {
            if (this.githubAccessService == null) {
                githubAccessService = GithubAccessService(volley, listener, errorListener)
            }
            return githubAccessService!!
        }
    }

    private val jsonArrayRequest =
        JsonArrayRequest(Request.Method.GET, USERS_API, null, listener, errorListener)

    fun loadData() {
        volley.add(jsonArrayRequest)
    }

     fun requestFollower(
        url: String,
        listener: Response.Listener<JSONArray>,
        errorListener: ErrorListener
    ) {
        volley.add(JsonArrayRequest(
            "$USERS_API/$url/followers",
            listener,
            errorListener
        ))
    }

     fun requestFollowing(
        url: String,
        listener: Response.Listener<JSONArray>,
        errorListener: ErrorListener
    ) {
        volley.add(JsonArrayRequest(
            "$USERS_API/$url/following",
            listener,
            errorListener
        )  ) }

     fun requestGists(
        url: String,
        listener: Response.Listener<JSONArray>,
        errorListener: ErrorListener
    ) {
        volley.add(JsonArrayRequest(
            "$USERS_API/$url/gists",
            listener,
            errorListener
        ))
    }

     fun requestSubs(
        url: String,
        listener: Response.Listener<JSONArray>,
        errorListener: ErrorListener
    ) {
        volley.add(JsonArrayRequest(
            "$USERS_API/$url/subscriptions",
            listener,
            errorListener
        ))
    }

     fun requestOrgs(
        url: String,
        listener: Response.Listener<JSONArray>,
        errorListener: ErrorListener
    ) {
        volley.add(JsonArrayRequest(
            "$USERS_API/$url/orgs",
            listener,
            errorListener
        ))
    }

     fun requestStarred(
        url: String,
        listener: Response.Listener<JSONArray>,
        errorListener: ErrorListener
    ) {
        volley.add(JsonArrayRequest(
            "$USERS_API/$url/starred",
            listener,
            errorListener
        ))
    }

     fun requestRepos(
        url: String,
        listener: Response.Listener<JSONArray>,
        errorListener: ErrorListener
    ) {
        volley.add(JsonArrayRequest(
            "$USERS_API/$url/repos",
            listener,
            errorListener
        ))
    }

     fun requestEvents(
        url: String,
        listener: Response.Listener<JSONArray>,
        errorListener: ErrorListener
    ) {
        volley.add(JsonArrayRequest(
            "$USERS_API/$url/events",
            listener,
            errorListener
        ))
    }

     fun requestRecEvnt(
        url: String,
        listener: Response.Listener<JSONArray>,
        errorListener: ErrorListener
    ) {
        volley.add(JsonArrayRequest(
            "$USERS_API/$url/received_events",
            listener,
            errorListener
        ))
    }
}