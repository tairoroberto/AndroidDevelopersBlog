package br.com.trmamobilesolutions.androiddevelopersblog

import com.google.gson.annotations.SerializedName

data class Image(@SerializedName("url")
                 val url: String = "")