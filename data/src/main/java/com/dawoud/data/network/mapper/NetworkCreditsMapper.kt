package com.dawoud.data.network.mapper

import com.dawoud.data.cache.entity.CastEntity
import com.dawoud.data.cache.entity.GeneralCreditsEntity
import com.dawoud.data.network.dto.CastDto
import com.dawoud.data.network.dto.GeneralCreditsDto
import com.dawoud.domain.model.CastModel
import com.dawoud.domain.model.GenerlCreditsModel

fun GeneralCreditsDto.tomodel(): GenerlCreditsModel {
    return GenerlCreditsModel(
        id = id,
        cast = cast.toModelList()
    )
}
fun GenerlCreditsModel.toDto(): GeneralCreditsDto {
    return GeneralCreditsDto(
        id = id,
        cast = cast.toDtoList()
    )
}
fun List<CastModel>.toDtoList():List<CastDto>{
    return this.map { it.toDto() }
}
fun List<CastDto>.toModelList():List<CastModel>{
    return this.map { it.toModel() }
}
fun CastDto.toModel(): CastModel {
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

fun CastModel.toDto(): CastDto {
    return CastDto(
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