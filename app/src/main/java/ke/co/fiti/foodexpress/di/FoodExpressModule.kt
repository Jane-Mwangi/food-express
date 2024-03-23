package design.fiti.thrive.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ke.co.fiti.foodexpress.core.USER_PREFERENCES_NAME
import ke.co.fiti.foodexpress.data.repository.UserPreferencesImplementation
import ke.co.fiti.foodexpress.domain.repository.UserPreferencesRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


val Context.ourdataStore by preferencesDataStore(
    name = USER_PREFERENCES_NAME
)

@Module
@InstallIn(SingletonComponent::class)
object ThriveModule {
    @Provides
    @Singleton
    fun provideUserPreferenceRepository(
        @ApplicationContext context: Context,
    ): UserPreferencesRepository {
        val dataStore: DataStore<Preferences> = context.ourdataStore
        return UserPreferencesImplementation(dataStore)
    }


    @Provides
    @Singleton
    fun provideDatastore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> {
        val dataStore: DataStore<Preferences> = context.ourdataStore
        return dataStore
    }








}