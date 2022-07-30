package com.dawoud.data.network.dto

import com.google.gson.annotations.SerializedName
import javax.annotation.Nullable

data class GeneralCreditsDto(
    @SerializedName("id")
    val id :Int,
    @SerializedName("cast")
    val cast:List<CastDto>
)
data class CastDto(
    @SerializedName("adult")
    val adult:Boolean,
    @SerializedName("gender")
    @Nullable
    val gender:Int?,
    @SerializedName("id")
    val id:Int,
    @SerializedName("known_for_department")
    val known_for_department:String,
    @SerializedName("name")
    val name:String,
    @SerializedName("original_name")
    val original_name:String,
    @SerializedName("popularity")
    val popularity:Long,
    @SerializedName("profile_path")
    @Nullable
    val profile_path:String?,
    @SerializedName("cast_id")
    val cast_id:Int,
    @SerializedName("character")
    val character:String,
    @SerializedName("credit_id")
    val credit_id:String,
    @SerializedName("order")
    val order:Int,
)
