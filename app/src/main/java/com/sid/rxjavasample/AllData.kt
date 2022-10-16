package com.sid.rxjavasample

import com.google.gson.annotations.SerializedName

data class AllData(

    @SerializedName("articles")
    var articlelist: List<Article>?
)
