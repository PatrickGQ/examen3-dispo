package com.example.usecases.plan

import com.example.data.repository.PlanRepository
import javax.inject.Inject

class GetPlanesUseCase @Inject constructor(
    private val repository: PlanRepository
) {
    operator fun invoke() = repository.getPlanes()
}
