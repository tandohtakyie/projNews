package com.example.projectnews.domain.usecase.app_entry

import com.example.projectnews.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager,
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }

}