package com.example.examen3.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.domain.model.Plan
import com.example.usecases.plan.GetPlanesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanCarouselViewModel @Inject constructor(
    getPlanesUseCase: GetPlanesUseCase
) : ViewModel() {
    private val _index = mutableStateOf(0)
    val index: State<Int> = _index

    val planes: List<Plan> = getPlanesUseCase()

    fun nextPlan() {
        _index.value = (_index.value + 1).coerceAtMost(planes.size - 1)
    }

    fun previousPlan() {
        _index.value = (_index.value - 1).coerceAtLeast(0)
    }
}
