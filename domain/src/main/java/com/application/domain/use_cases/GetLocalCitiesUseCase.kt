package com.application.domain.use_cases

import com.application.domain.repo.LocalCitiesRepo

class GetLocalCitiesUseCase(private val repo: LocalCitiesRepo) {

    operator fun invoke() = repo.getLocalCities()

}