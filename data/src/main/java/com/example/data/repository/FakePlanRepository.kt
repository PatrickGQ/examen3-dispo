package com.example.data.repository

import com.example.domain.model.Plan
import javax.inject.Inject
import javax.inject.Singleton

interface PlanRepository {
    fun getPlanes(): List<Plan>
}

@Singleton
class FakePlanRepository @Inject constructor() : PlanRepository {
    override fun getPlanes(): List<Plan> {
        return listOf(
            Plan("Plan FLEX 5", 270, 199, 5),
            Plan("Plan FLEX 8", 370, 299, 8),
            Plan("Plan FLEX 10", 470, 399, 10)
        )
    }
}