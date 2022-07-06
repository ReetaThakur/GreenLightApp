package com.example.greenlightapp.di

import android.content.Context
import androidx.room.Room
import com.example.greenlightapp.database.CountryRoomdatabase
import com.example.greenlightapp.database.ItemDao
import com.example.greenlightapp.response.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ItemModule {

    @Singleton
    @Provides
    fun provideAPIC():ApiService{
        val builder = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        return builder.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context):CountryRoomdatabase{
        val builder=  Room.databaseBuilder(context,CountryRoomdatabase::class.java,"news_database")
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }
    @Singleton
    @Provides
    fun provideNewsDao(db:CountryRoomdatabase):ItemDao{
        return db.getDao()
    }
}