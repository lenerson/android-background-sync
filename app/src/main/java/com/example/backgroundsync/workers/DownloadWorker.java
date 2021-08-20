package com.example.backgroundsync.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.text.MessageFormat;
import java.util.Calendar;

public final class DownloadWorker extends Worker {
    public DownloadWorker(@NonNull final Context context, @NonNull final WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.i("BackgroundSyncDownload", MessageFormat.format("Download Synchronized on {0}", Calendar.getInstance().getTime()));
        return Result.success();
    }
}
