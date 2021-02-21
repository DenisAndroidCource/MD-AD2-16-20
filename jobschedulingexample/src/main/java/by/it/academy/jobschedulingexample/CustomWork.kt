package by.it.academy.jobschedulingexample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class CustomWork(
    context: Context,
    workerParameters: WorkerParameters
): Worker(context, workerParameters) {

    override fun doWork(): Result {
        Log.d("CustomWork", Thread.currentThread().name)
        return Result.success()
    }

}