package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.ElmenusDAO
import com.example.data.local.ElmenusDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    fun provideElmenusDao(appDatabase: ElmenusDataBase): ElmenusDAO {
        return appDatabase.getElmenusDao()
    }

    @Provides
    @Singleton
    fun provideElmenusDatabase(@ApplicationContext appContext: Context)
            : ElmenusDataBase {
        return Room.databaseBuilder(
            appContext,
            ElmenusDataBase::class.java,
            "Elmenus_Database"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}