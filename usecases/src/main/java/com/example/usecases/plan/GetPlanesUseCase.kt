package com.example.usecases.plan

import com.example.data.repository.PlanRepository
import com.example.domain.model.Plan
import javax.inject.Inject

class GetPlanesUseCase @Inject constructor(
    private val repository: PlanRepository
) {
    operator fun invoke(): List<Plan> = repository.getPlanes()
}