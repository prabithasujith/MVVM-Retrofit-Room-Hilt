package com.prabitha.kotlin.mvvmretrofitroom.di

import android.app.Application
import androidx.room.Room
import com.prabitha.kotlin.mvvmretrofitroom.roomDb.RoomDAO
import com.prabitha.kotlin.mvvmretrofitroom.roomDb.RoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class StorageModule {

@Provides
@Singleton
fun getRoomDB(application:Application):RoomDB{
    return Room.databaseBuilder<RoomDB>(application, RoomDB::class.java, "Favorite Database")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
}

    @Provides
    @Singleton
    fun getRoomDAO(roomDB: RoomDB):RoomDAO{
        return roomDB.RoomDAO()
    }

}