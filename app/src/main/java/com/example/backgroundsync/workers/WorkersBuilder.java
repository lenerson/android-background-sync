package com.example.backgroundsync.workers;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.util.concurrent.TimeUnit;

public final class WorkersBuilder {

    private static final int REPEAT_INTERVAL_IN_MINUTES = 15;

    public static void build(final Context context) {
        enqueueUploadWorker(context);
        enqueueDownloadWorker(context);
    }

    private static void enqueueUploadWorker(@NonNull final Context context) {
        enqueueWorkRequest(context, createWorkRequest(UploadWorker.class));
    }

    private static void enqueueDownloadWorker(@NonNull final Context context) {
        enqueueWorkRequest(context, createWorkRequest(DownloadWorker.class));
    }

    private static WorkRequest createWorkRequest(@NonNull final Class<? extends ListenableWorker> workerClass) {
        final Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .setRequiresStorageNotLow(true)
                .build();

        return new PeriodicWorkRequest.Builder(
                workerClass,
                REPEAT_INTERVAL_IN_MINUTES,
                TimeUnit.MINUTES
        ).setConstraints(constraints).build();
    }

    private static void enqueueWorkRequest(@NonNull final Context context, @NonNull final WorkRequest workRequest) {
        WorkManager
                .getInstance(context)
                .enqueue(workRequest);
    }
}
