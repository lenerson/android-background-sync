package com.example.backgroundsync.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.text.MessageFormat;
import java.util.Calendar;

public final class UploadWorker extends Worker {
    public UploadWorker(@NonNull final Context context, @NonNull final WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.i("BackgroundSyncUpload", MessageFormat.format("Upload Synchronized on {0}", Calendar.getInstance().getTime()));
        return Result.success();
    }
}
