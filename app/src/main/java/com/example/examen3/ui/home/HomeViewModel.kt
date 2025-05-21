package com.example.examen3.ui.home

import androidx.lifecycle.ViewModel
import com.example.domain.model.Plan
import com.example.usecases.plan.GetPlanesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPlanesUseCase: GetPlanesUseCase
) : ViewModel() {

    val planes: List<Plan> = getPlanesUseCase()
}