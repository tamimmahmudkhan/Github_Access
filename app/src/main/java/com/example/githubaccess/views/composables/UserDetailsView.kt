package com.example.githubaccess.views.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.githubaccess.R
import com.example.githubaccess.model.User
import com.example.githubaccess.ui.theme.GithubAccessTheme
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "UserDetailsView"

class UserDetailsView(
    private val userUIState: User,
    private val userDetailsData: StateFlow<UserDetailsData>
) {


    @Composable
    fun GetView() {

        val state = userDetailsData.collectAsState()

        GithubAccessTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                UserDetailsComposable(
                    userUIState,
                    modifier = Modifier.padding(innerPadding),
                    state.value
                )
            }
        }
    }

    @Composable
    fun UserDetailsComposable(
        userUIState: User,
        modifier: Modifier,
        userDetailsData: UserDetailsData
    ) {
        Card(modifier = Modifier.fillMaxSize(), shape = RectangleShape, elevation = CardDefaults.elevatedCardElevation()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                    .data(userUIState.avatar_url)
                    .crossfade(true)
                    .build(),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxWidth()
                        .border(2.dp, MaterialTheme.colorScheme.onTertiary),
                    onError = {
                        Log.e(
                            TAG,
                            "UserDetailsComposable: Error loading image: ${it.result}",
                        )
                    }
                )
                Text(
                    text = "Login: ${userUIState.login}",
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.onTertiary,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                        .padding(4.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2), // Set to 2 columns
                    contentPadding = PaddingValues(8.dp) // Optional padding
                ) {
                    // Adding items to the grid
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_followers,
                            txt = "Followers: ${userDetailsData.followers}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_following,
                            txt = "Following: ${userDetailsData.following}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_gists,
                            txt = "Gists: ${userDetailsData.gists}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = android.R.drawable.star_on,
                            txt = "Starred: ${userDetailsData.starred}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_subscriptions,
                            txt = "Subscriptions: ${userDetailsData.subs}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_organizations,
                            txt = "Organizations: ${userDetailsData.orgs}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_repos,
                            txt = "Repos: ${userDetailsData.repos}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_events,
                            txt = "Events: ${userDetailsData.events}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_received_events,
                            txt = "Received Events: ${userDetailsData.recEvnt}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_user_type,
                            txt = "Type: ${userUIState.type}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = android.R.drawable.ic_menu_view,
                            txt = "User View Type: ${userUIState.user_view_type}"
                        )
                    }
                    item {
                        SingleDetailComposable(
                            resource = R.drawable.ic_admin,
                            txt = "Site Admin: ${userUIState.site_admin}"
                        )
                    }
                }

            }
        }
    }

    @Composable
    fun SingleDetailComposable(resource: Int, txt: String) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(),
            modifier = Modifier.background(MaterialTheme.colorScheme.onSecondaryContainer).wrapContentWidth()
        ) {
            Column {
                Icon(
                    painterResource(resource),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier
                        .fillMaxSize()
                        .requiredHeight(40.dp)
                        .clip(RectangleShape)
                )
                Text(
                    text = txt,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.onTertiary,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxSize()
                        .padding(4.dp),
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

    data class UserDetailsData(
        val followers: Int? = 0,
        val following: Int? = 0,
        val gists: Int? = 0,
        val starred: Int? = 0,
        val subs: Int? = 0,
        val orgs: Int? = 0,
        val repos: Int? = 0,
        val events: Int? = 0,
        val recEvnt: Int? = 0,
    )
}


/*
                Text(text = "Login: ${userUIState.login}")
                Text(text = "Node ID: ${userUIState.node_id}")
                Text(text = "Gravatar ID: ${userUIState.gravatar_id}")
                Text(text = "URL: ${userUIState.url}")
                Text(text = "HTML URL: ${userUIState.html_url}")
                Text(text = "Followers : ${userDetailsData.followers}")
                Text(text = "Following : ${userDetailsData.following}")
                Text(text = "Gists: ${userDetailsData.gists}")
                Text(text = "Starred: ${userDetailsData.starred}")
                Text(text = "Subscriptions: ${userDetailsData.subs}")
                Text(text = "Organizations: ${userDetailsData.orgs}")
                Text(text = "Repos: ${userDetailsData.repos}")
                Text(text = "Events : ${userDetailsData.events}")
                Text(text = "Received Events: ${userDetailsData.recEvnt}")
                Text(text = "Type: ${userUIState.type}")
                Text(text = "User View Type: ${userUIState.user_view_type}")
                Text(text = "Site Admin: ${userUIState.site_admin}")*/