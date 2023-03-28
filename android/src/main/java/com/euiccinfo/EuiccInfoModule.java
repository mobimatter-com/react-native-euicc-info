package com.euiccinfo;

import androidx.annotation.NonNull;

import android.content.Context;
import android.telephony.euicc.EuiccManager;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = EuiccInfoModule.NAME)
public class EuiccInfoModule extends ReactContextBaseJavaModule {
  public static final String NAME = "EuiccInfo";
  public ReactApplicationContext rc;

  public EuiccInfoModule(ReactApplicationContext reactContext) {
    super(reactContext);

    rc = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void getEuiccVersion(Promise promise) {
    EuiccManager mgr = (EuiccManager) rc.getSystemService(Context.EUICC_SERVICE);
    promise.resolve(mgr.getEuiccInfo().getOsVersion());
  }
}
