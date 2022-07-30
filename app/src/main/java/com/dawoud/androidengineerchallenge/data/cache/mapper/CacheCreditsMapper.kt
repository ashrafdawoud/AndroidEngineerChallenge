package com.dawoud.data.cache.mapper

import com.dawoud.data.cache.entity.CastEntity
import com.dawoud.data.cache.entity.GeneralCreditsEntity
import com.dawoud.domain.model.CastModel
import com.dawoud.domain.model.GenerlCreditsModel

fun GeneralCreditsEntity.tomodel(): GenerlCreditsModel {
    return GenerlCreditsModel(
        id = id,
        cast = cast.toModelList()
    )
}
fun GenerlCreditsModel.toEntity(): GeneralCreditsEntity {
    return GeneralCreditsEntity(
        id = id,
        cast = cast.toEntityList()
    )
}
fun List<CastModel>.toEntityList():List<CastEntity>{
    return this.map { it.toEntity() }
}
fun List<CastEntity>.toModelList():List<CastModel>{
    return this.map { it.toModel() }
}
fun CastEntity.toModel(): CastModel {
    return CastModel(
        adult = adult,
        gender = gender,
        id = id,
        known_for_department = known_for_department,
        name = name,
        original_name = original_name,
        popularity = popularity,
        profile_path = profile_path,
        cast_id = cast_id,
        character = character,
        credit_id = credit_id,
        order = order
    )
}

fun CastModel.toEntity(): CastEntity {
    return CastEntity(
        adult = adult,
        gender = gender,
        id = id,
        known_for_department = known_for_department,
        name = name,
        original_name = original_name,
        popularity = popularity,
        profile_path = profile_path,
        cast_id = cast_id,
        character = character,
        credit_id = credit_id,
        order = order
    )
}