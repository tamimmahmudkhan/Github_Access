package com.example.githubaccess.model

import org.json.JSONObject

data class User(
        var login: String? = null,
        var id: Int = -1,
        var node_id: String? = null,
        var avatar_url: String? = null,
        var gravatar_id: String? = null,
        var url: String? = null,
        var html_url: String? = null,
        var followers_url: String? = null,
        var following_url: String? = null,
        var gists_url: String? = null,
        var starred_url: String? = null,
        var subscriptions_url: String? = null,
        var organizations_url: String? = null,
        var repos_url: String? = null,
        var events_url: String? = null,
        var received_events_url: String? = null,
        var type: String? = null,
        var user_view_type: String? = null,
        var site_admin: String? = null
){
        fun fromJSON(jsonObject: JSONObject): User {
                return User(
                        login = jsonObject.optString("login"),
                        id = jsonObject.optInt("id", -1), // Use -1 as a default value if the key doesn't exist or is null
                        node_id = jsonObject.optString("node_id"),
                        avatar_url = jsonObject.optString("avatar_url"),
                        gravatar_id = jsonObject.optString("gravatar_id"),
                        url = jsonObject.optString("url"),
                        html_url = jsonObject.optString("html_url"),
                        followers_url = jsonObject.optString("followers_url"),
                        following_url = jsonObject.optString("following_url"),
                        gists_url = jsonObject.optString("gists_url"),
                        starred_url = jsonObject.optString("starred_url"),
                        subscriptions_url = jsonObject.optString("subscriptions_url"),
                        organizations_url = jsonObject.optString("organizations_url"),
                        repos_url = jsonObject.optString("repos_url"),
                        events_url = jsonObject.optString("events_url"),
                        received_events_url = jsonObject.optString("received_events_url"),
                        type = jsonObject.optString("type"),
                        user_view_type = jsonObject.optString("user_view_type"),
                        site_admin = jsonObject.optString("site_admin")
                )
        }

}