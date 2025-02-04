package com.example.githubaccess.views.composables

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.animation.core.animateDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.githubaccess.HostActivity
import com.example.githubaccess.ui.theme.GithubAccessTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainView(private val viewModel: MainViewModel, private val hostActivity: HostActivity) {

    @Composable
    fun GetView(){

        val uiState = viewModel.uiState.collectAsState()

        return GithubAccessTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                UserListComposable(
                    modifier = Modifier.padding(innerPadding),
                    uiState,
                    hostActivity
                )
            }
        }
    }
}

@Composable
fun UserItemComposable( position: Int, modifier: Modifier, userItemState: UserItemState, hostActivity: HostActivity){
    Card (modifier = Modifier
        .clickable {hostActivity.onClickFrom(position)}
        .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(),
        shape = CardDefaults.elevatedShape
    ){
        Column(modifier = Modifier.wrapContentSize(Alignment.Center).padding(16.dp), verticalArrangement = Arrangement.SpaceEvenly) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(userItemState.avatar_url)
                    .crossfade(true)
                    .build(),
                contentDescription = "User Avatar image",
                placeholder = painterResource(android.R.drawable.star_on),
                modifier = Modifier
                    .requiredSize(150.dp)
                    .padding(horizontal = 2.dp , vertical = 4.dp)
                    .clip(CircleShape)
                )
            val textModifier = Modifier
                .background(color = MaterialTheme.colorScheme.onTertiary, shape = RoundedCornerShape(5.dp))
                .fillMaxWidth()
                .padding(4.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
            Text(text = userItemState.login, modifier = textModifier, textAlign = TextAlign.Center, softWrap = false)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Type: ${userItemState.type}", modifier = textModifier, textAlign = TextAlign.Center, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
fun UserListComposable(modifier: Modifier, userListState: State<MutableList<UserItemState>>, hostActivity: HostActivity){

    LazyVerticalGrid(
       columns =  GridCells.Fixed(2), modifier =  Modifier.padding(16.dp), content =  {
           items(userListState.value){
            UserItemComposable(userListState.value.indexOf(it) , modifier, it, hostActivity)
        }
       },
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    GithubAccessTheme {

    }
}

/**
 * {
 *     "login": "mojombo",
 *     "id": 1,
 *     "node_id": "MDQ6VXNlcjE=",
 *     "avatar_url": "https://avatars.githubusercontent.com/u/1?v=4",
 *     "gravatar_id": "",
 *     "url": "https://api.github.com/users/mojombo",
 *     "html_url": "https://github.com/mojombo",
 *     "followers_url": "https://api.github.com/users/mojombo/followers",
 *     "following_url": "https://api.github.com/users/mojombo/following{/other_user}",
 *     "gists_url": "https://api.github.com/users/mojombo/gists{/gist_id}",
 *     "starred_url": "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
 *     "subscriptions_url": "https://api.github.com/users/mojombo/subscriptions",
 *     "organizations_url": "https://api.github.com/users/mojombo/orgs",
 *     "repos_url": "https://api.github.com/users/mojombo/repos",
 *     "events_url": "https://api.github.com/users/mojombo/events{/privacy}",
 *     "received_events_url": "https://api.github.com/users/mojombo/received_events",
 *     "type": "User",
 *     "user_view_type": "public",
 *     "site_admin": false
 *   }
 * **/