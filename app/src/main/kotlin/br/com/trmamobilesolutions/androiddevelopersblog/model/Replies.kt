package br.com.trmamobilesolutions.androiddevelopersblog.model

import com.google.gson.annotations.SerializedName

data class Replies(@SerializedName("totalItems")
                   val totalItems: String = "",
                   @SerializedName("selfLink")
                   val selfLink: String = "")