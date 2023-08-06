package com.example.ezlotestapp.di

import android.content.Context
import androidx.room.Room
import com.example.ezlotestapp.data.api.ApiDevices
import com.example.ezlotestapp.database.DeviceDao
import com.example.ezlotestapp.database.DeviceDataBase
import com.example.ezlotestapp.data.repository.DevicesRepository
import com.example.ezlotestapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideDevicesRepository(
        api: ApiDevices,
        deviceDao: DeviceDao,
    ) = DevicesRepository(api,deviceDao)

    @Provides
    fun provideDevicesApi(): ApiDevices {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiDevices::class.java)
    }

    @Singleton
    @Provides
    fun createDatabase(
        @ApplicationContext context: Context
    ) =
        Room.databaseBuilder(
            context.applicationContext,
            DeviceDataBase::class.java,
            "article_db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideArticleDao(appDatabase: DeviceDataBase): DeviceDao {
        return appDatabase.getDevisesDao()
    }
}