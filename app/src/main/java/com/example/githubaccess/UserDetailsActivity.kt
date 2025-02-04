package com.example.githubaccess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.githubaccess.model.User
import com.example.githubaccess.service.GithubAccessService
import com.example.githubaccess.views.composables.UserDetailsView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject

class UserDetailsActivity : ComponentActivity() {

    private val userDetailsData = UserDetailsView.UserDetailsData()
    private val uiMutableState = MutableStateFlow(userDetailsData)
    private val uiState = uiMutableState.asStateFlow()
    private lateinit var user : User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        user = User().fromJSON(
            JSONObject(intent.extras!!.getString(MainActivity.KEY_DETAILS)!!)
        )

        val volley = Volley.newRequestQueue(this)

        val usrURL = "${GithubAccessService.USERS_API}/${user.login}"

        volley.add(requestFollower("$usrURL/followers"))
        volley.add(requestFollowing("$usrURL/following"))
        volley.add(requestGists("$usrURL/gists"))
        volley.add(requestStarred("$usrURL/starred"))
        volley.add(requestRepos("$usrURL/repos"))
        volley.add(requestSubs("$usrURL/subscriptions"))
        volley.add(requestOrgs("$usrURL/orgs"))
        volley.add(requestRecEvnt("$usrURL/received_events"))
        volley.add(requestEvents("$usrURL/events"))

        val view = UserDetailsView(user, uiState)

        enableEdgeToEdge()
        setContent {view.GetView()}
    }

    private fun requestFollower(url: String): JsonArrayRequest {
        return  JsonArrayRequest(
            url,
            { response ->
                uiMutableState.update {
                    it.copy(
                        followers = response.length()
                    )
                }
            },
            { uiMutableState.update {
                it.copy(
                    followers = -1
                )
            } }
        )
    }
    private fun requestFollowing(url: String): JsonArrayRequest {
        return  JsonArrayRequest(
            url,
            { response ->
                uiMutableState.update {
                    it.copy(
                        following = response.length()
                    )
                }
            },
            {
                uiMutableState.update {
                    it.copy(
                        following = -1
                    )
                }
            }
        )
    }
    private fun requestGists(url: String): JsonArrayRequest {
        return  JsonArrayRequest(
            url,
            { response ->
                uiMutableState.update {
                    it.copy(
                        gists = response.length()
                    )
                }
            },
            {
                uiMutableState.update {
                    it.copy(
                        gists = -1
                    )
                }
            }
        )
    }
    private fun requestSubs(url: String): JsonArrayRequest {
        return  JsonArrayRequest(
            url,
            { response ->
                uiMutableState.update {
                    it.copy(
                        subs = response.length()
                    )
                }
            },
            {
                uiMutableState.update {
                    it.copy(
                        subs = -1
                    )
                }
            }
        )
    }
    private fun requestOrgs(url: String): JsonArrayRequest {
        return  JsonArrayRequest(
            url,
            { response ->
                uiMutableState.update {
                    it.copy(
                        orgs = response.length()
                    )
                }
            },
            {
                uiMutableState.update {
                    it.copy(
                        orgs = -1
                    )
                }
            }
        )
    }
    private fun requestStarred(url: String): JsonArrayRequest {
        return  JsonArrayRequest(
            url,
            { response ->
                uiMutableState.update {
                    it.copy(
                        starred = response.length()
                    )
                }
            },
            {
                uiMutableState.update {
                    it.copy(
                        starred = -1
                    )
                }
            }
        )
    }
    private fun requestRepos(url: String): JsonArrayRequest {
        return  JsonArrayRequest(
            url,
            { response ->
                uiMutableState.update {
                    it.copy(
                        repos = response.length()
                    )
                }
            },
            {
                uiMutableState.update {
                    it.copy(
                        repos = -1
                    )
                }
            }
        )
    }
    private fun requestEvents(url: String): JsonArrayRequest {
        return  JsonArrayRequest(
            url,
            { response ->
                uiMutableState.update {
                    it.copy(
                        events = response.length()
                    )
                }
            },
            {
                uiMutableState.update {
                    it.copy(
                        events = -1
                    )
                }
            }
        )
    }
    private fun requestRecEvnt(url: String): JsonArrayRequest {
        return  JsonArrayRequest(
            url,
            { response ->
                uiMutableState.update {
                    it.copy(
                        recEvnt = response.length()
                    )
                }
            },
            {
                uiMutableState.update {
                    it.copy(
                        recEvnt = -1
                    )
                }
            }
        )
    }
}