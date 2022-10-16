package com.sid.rxjavasample

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("title")
    var title : String,

    @SerializedName("description")
    var description :  String,

    @SerializedName("content")
    var content : String,

    @SerializedName("image")
    var image : String,

    @SerializedName("publishedAt")
    var publisedAt : String,

    @SerializedName("url")
    var url : String
)
