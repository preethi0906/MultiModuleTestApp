package com.example.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_database.entity.AuthEntity

@Dao
interface AuthDao {
    @Query("SELECT * FROM auth LIMIT 1")
    suspend fun getAuth(): AuthEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAuth(auth: AuthEntity)

    @Query("DELETE FROM auth")
    suspend fun clearAuth()
}
