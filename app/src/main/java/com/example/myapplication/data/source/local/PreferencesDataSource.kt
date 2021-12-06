package com.example.myapplication.data.source.local

import android.content.Context
import android.os.Build
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

const val SHARED_PREFERENCE_NAME = "secret_shared_prefs"

const val KEY_USER_EMAIL = "UserEmail"
const val KEY_REMEMBER_EMAIL = "RememberEmail"

class PreferencesDataSource(
    private val context: Context
) {

    private fun getMasterKey(): MasterKey {
        return MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
    }

    private fun providesSharedPreference() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        EncryptedSharedPreferences.create(
            context,
            SHARED_PREFERENCE_NAME,
            getMasterKey(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    } else {
        context.getSharedPreferences(
            SHARED_PREFERENCE_NAME,
            Context.MODE_PRIVATE
        )
    }

    fun rememberEmail(email: String) {
        providesSharedPreference().edit().apply {
            putString(KEY_REMEMBER_EMAIL, email)
            apply()
        }
    }

    fun getUserEmail(): String? {
        return providesSharedPreference().getString(KEY_USER_EMAIL, null)
    }

    fun saveUserEmail(email: String) {
        providesSharedPreference().edit().apply {
            putString(KEY_USER_EMAIL, email)
            apply()
        }
    }
}
