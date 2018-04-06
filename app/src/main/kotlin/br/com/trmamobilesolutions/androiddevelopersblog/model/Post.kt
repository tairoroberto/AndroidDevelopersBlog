package br.com.trmamobilesolutions.androiddevelopersblog.model

import com.google.gson.annotations.SerializedName

data class Post(@SerializedName("replies")
                var replies: Replies,
                @SerializedName("kind")
                var kind: String = "",
                @SerializedName("author")
                var author: Author,
                @SerializedName("id")
                var id: String = "",
                @SerializedName("published")
                var published: String = "",
                @SerializedName("blog")
                var blog: Blog,
                @SerializedName("title")
                var title: String = "",
                @SerializedName("updated")
                var updated: String = "",
                @SerializedName("url")
                var url: String = "",
                @SerializedName("content")
                var content: String = "",
                @SerializedName("selfLink")
                var selfLink: String = "")