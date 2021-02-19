package com.liuhao.wcwork.http

import com.google.gson.annotations.SerializedName

data class UserVO(
    @SerializedName("profile-image")
    var profileImage: String? = null,
    var avatar: String? = null,
    var nick: String? = null,
    var username: String? = null
)


data class TweetsVo(
    val comments: List<CommentsVo>? = null,
    val content: String? = null,
    val error: String? = null,
    val images: List<ImageVo>? = null,
    val sender: UserVO? = null,
    val unknownError: String? = null
)

data class ImageVo(
    val url: String
)

data class CommentsVo(
    val content: String? = null,
    val sender: UserVO? = null
)

