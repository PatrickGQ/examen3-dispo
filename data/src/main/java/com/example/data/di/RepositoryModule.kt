package com.example.data.di

import com.example.data.repository.FakePlanRepository
import com.example.data.repository.PlanRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPlanRepository(
        fakePlanRepository: FakePlanRepository
    ): PlanRepository
}