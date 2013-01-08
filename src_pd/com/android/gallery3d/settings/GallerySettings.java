/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gallery3d.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.CheckBoxPreference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.preference.PreferenceActivity;

import com.android.gallery3d.R;

public class GallerySettings extends PreferenceActivity
            implements OnPreferenceChangeListener {
    private static final String TAG = "GallerySettings";

    public static final String SMART_CONTROL = "pref_smart_control";

    private SharedPreferences sp;
    private CheckBoxPreference mSmartControl;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        addPreferencesFromResource(R.xml.gallerysettings);

        mSmartControl = (CheckBoxPreference) findPreference(SMART_CONTROL);
        mSmartControl.setChecked(mSmartControl.isChecked());
        mSmartControl.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference == mSmartControl) {
            mSmartControl.setChecked(mSmartControl.isChecked());
            return true;
        }
        return false;
    }

}
