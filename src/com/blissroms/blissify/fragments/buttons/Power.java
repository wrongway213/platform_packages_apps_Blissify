package com.blissroms.blissify.fragments.buttons;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.ListPreference;
import android.support.v14.preference.SwitchPreference;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.format.DateFormat;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.blissroms.blissify.preference.SystemSettingSwitchPreference;
import android.provider.Settings;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.util.omni.DeviceUtils;

public class Power extends SettingsPreferenceFragment 
                                         implements Preference.OnPreferenceChangeListener{


        private static final String TAG = "Power";
        private static final String CATEGORY_PROXY = "proxy_check";
        private static final String SYSTEM_PROXI_CHECK_ENABLED = "system_proxi_check_enabled";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.buttons_power);
            PreferenceScreen prefSet = getPreferenceScreen();

            final PreferenceCategory proxyCategory =
                    (PreferenceCategory) prefSet.findPreference(CATEGORY_PROXY);

            boolean supportPowerButtonProxyCheck = getResources().getBoolean(com.android.internal.R.bool.config_proxiSensorWakupCheck);
            SwitchPreference proxyCheckPreference = (SwitchPreference) findPreference(SYSTEM_PROXI_CHECK_ENABLED);
            if (!DeviceUtils.deviceSupportsProximitySensor(getActivity()) || !supportPowerButtonProxyCheck) {
                proxyCategory.removePreference(proxyCheckPreference);
            }

        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            return false;
        }

    public boolean onPreferenceTreeClick(Preference preference) {
        ContentResolver resolver = getActivity().getContentResolver();
        return false;
    }

        @Override
        public int getMetricsCategory() {
            return MetricsProto.MetricsEvent.BLISSIFY;
        }
}
