package com.dawoud.domain.model

data class GenerlCreditsModel(
    val id: Int,
    val cast: List<CastModel>
)

data class CastModel(
    val adult: Boolean,
    val gender: Int?,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Long,
    val profile_path: String?,
    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val order: Int,
)
