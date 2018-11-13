package com.czfrobot.wechatrobot.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import de.robv.android.xposed.XSharedPreferences;

public class SettingsHelper {
    private SharedPreferences mPreferences = null;
    private XSharedPreferences mXPreferences = null;

    public SettingsHelper() {
        mXPreferences = new XSharedPreferences("com.exmaple.wechatrobot");
        mXPreferences.makeWorldReadable();
        this.reload();
    }

    public SettingsHelper(Context context) {
        this.mPreferences = context.getSharedPreferences("com.exmaple.wechatrobot_preferences", 1);
    }

    public String getString(String key, String defaultValue) {
        if (mPreferences != null) {
            return mPreferences.getString(key, defaultValue);
        } else if (mXPreferences != null) {
            return mXPreferences.getString(key, defaultValue);
        }

        return defaultValue;
    }

    public int getInt(String key, int defaultValue) {
        if (mPreferences != null) {
            return mPreferences.getInt(key, defaultValue);
        } else if (mXPreferences != null) {
            return mXPreferences.getInt(key, defaultValue);
        }

        return defaultValue;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        if (mPreferences != null) {
            return mPreferences.getBoolean(key, defaultValue);
        } else if (mXPreferences != null) {
            return mXPreferences.getBoolean(key, defaultValue);
        }

        return defaultValue;
    }

    public void setString(String key, String value) {
        Editor editor = null;
        if (mPreferences != null) {
            editor = mPreferences.edit();
        } else if (mXPreferences != null) {
            editor = mXPreferences.edit();
        }

        if (editor != null) {
            editor.putString(key, value);
            editor.commit();
        }
    }

    public void setBoolean(String key, boolean value) {
        Editor editor = null;
        if (mPreferences != null) {
            editor = mPreferences.edit();
        } else if (mXPreferences != null) {
            editor = mXPreferences.edit();
        }

        if (editor != null) {
            editor.putBoolean(key, value);
            editor.commit();
        }
    }

    public void setInt(String key, int value) {
        Editor editor = null;
        if (mPreferences != null) {
            editor = mPreferences.edit();
        } else if (mXPreferences != null) {
            editor = mXPreferences.edit();
        }

        if (editor != null) {
            editor.putInt(key, value);
            editor.commit();
        }
    }

    public void reload() {
        if (mXPreferences != null) {
            mXPreferences.reload();
        }
    }
}