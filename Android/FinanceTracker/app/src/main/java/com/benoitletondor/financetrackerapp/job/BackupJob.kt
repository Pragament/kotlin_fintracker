/*
 *   Copyright 2025 Benoit Letondor
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.benoitletondor.FinanceTrackerapp.job

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.benoitletondor.FinanceTrackerapp.auth.Auth
import com.benoitletondor.FinanceTrackerapp.cloudstorage.CloudStorage
import com.benoitletondor.FinanceTrackerapp.helper.backupDB
import com.benoitletondor.FinanceTrackerapp.iab.Iab
import com.benoitletondor.FinanceTrackerapp.parameters.Parameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class BackupJob @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val cloudStorage: CloudStorage,
    private val auth: Auth,
    private val parameters: Parameters,
    private val iab: Iab,
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        return backupDB(context, cloudStorage, auth, parameters, iab)
    }

}
