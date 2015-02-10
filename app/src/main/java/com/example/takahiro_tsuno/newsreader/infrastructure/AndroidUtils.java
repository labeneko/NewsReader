package com.example.takahiro_tsuno.newsreader.infrastructure;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Environment;

import com.example.utils.ExtraIOUtils;
import com.example.utils.MethodCallUtils;

import java.io.InputStream;
import java.util.concurrent.Callable;

public final class AndroidUtils {

    private AndroidUtils() {
    }

    public static Orientation getOrientation(final Context context) {
        final Configuration config = context.getResources().getConfiguration();
        if(config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            return Orientation.PORTRAIT;
        }
        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return Orientation.LANDSCAPE;
        }
        return null;
    }

    public static byte[] openAssetAsByteArray(final Context context, final String filePath) {
        return ExtraIOUtils.toByteArrayOrNull(openAsset(context, filePath));
    }

    public static byte[] openAssetAsByteArray(final Context context, final String filePath, final int accessMode) {
        return ExtraIOUtils.toByteArrayOrNull(openAsset(context, filePath, accessMode));
    }

    public static InputStream openAsset(final Context context, final String filePath) {
        return openAsset(context, filePath, AssetManager.ACCESS_STREAMING);
    }

    public static InputStream openAsset(final Context context, final String filePath, final int accessMode) {
        return MethodCallUtils.callOrNull(new Callable<InputStream>() {
            @Override
            public InputStream call() throws Exception {
                return context.getAssets().open(filePath, accessMode);
            }
        });
    }

    public static boolean isExternalStorageMounted() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
}
