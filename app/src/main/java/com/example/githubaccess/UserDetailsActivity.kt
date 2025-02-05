package com.example.githubaccess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.volley.toolbox.Volley
import com.example.githubaccess.model.User
import com.example.githubaccess.service.GithubAccessService
import com.example.githubaccess.views.composables.UserDetailsView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject

/**
 *  Activity to show user details
 **/

class UserDetailsActivity : ComponentActivity() {

    private val userDetailsData = UserDetailsView.UserDetailsData()
    private val uiMutableState = MutableStateFlow(userDetailsData)
    private val uiState = uiMutableState.asStateFlow()
    private lateinit var user : User
    private lateinit var githubAccessService: GithubAccessService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        user = User().fromJSON(
            JSONObject(intent.extras!!.getString(MainActivity.KEY_DETAILS)!!)
        )

        val volley = Volley.newRequestQueue(this)
        githubAccessService = GithubAccessService.getService(volley, {}, {})

        makeRequests()

        val view = UserDetailsView(user, uiState)

        enableEdgeToEdge()
        setContent {view.GetView()}
    }

    private fun makeRequests(){
        githubAccessService.apply {
            requestFollower(user.login!!, { response ->
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
                } })
            requestFollowing(user.login!!,{ response ->
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
                })
            requestSubs(user.login!!,
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
                })
            requestGists(user.login!!,
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
                })
            requestRecEvnt(user.login!!,
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
                })
            requestRepos(user.login!!,
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
                })
            requestStarred(user.login!!,
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
                })
            requestOrgs(user.login!!,
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
                })
            requestEvents(user.login!!,
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
                })
        }
    }

}