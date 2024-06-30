package com.reactnativescreenlet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import com.liferay.mobile.screens.auth.login.LoginScreenlet;
import com.liferay.mobile.screens.auth.login.LoginListener;
import com.liferay.mobile.screens.context.User;

public class MainActivity extends ReactActivity implements LoginListener {

    private static final String TAG = "MainActivity";

    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "reactNativeScreenlet";
    }

    /**
     * Returns the instance of the [ReactActivityDelegate]. We use [DefaultReactActivityDelegate]
     * which allows you to enable New Architecture with a single boolean flag [fabricEnabled]
     */
    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new DefaultReactActivityDelegate(
            this,
            getMainComponentName(),
            DefaultNewArchitectureEntryPoint.getFabricEnabled()
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate called");
        
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            DefaultNewArchitectureEntryPoint.load();
        }
        setContentView(R.layout.activity_main);
        Log.i(TAG, "activity_main layout set");

        // Initialize and set the listener for LoginScreenlet
        LoginScreenlet loginScreenlet = findViewById(R.id.login_screenlet);
        if (loginScreenlet != null) {
            loginScreenlet.setListener(this);
            Log.i(TAG, "LoginScreenlet initialized and listener set.");
        } else {
            Log.e(TAG, "LoginScreenlet is null.");
        }
    }

    @Override
    public void onLoginSuccess(User user) {
        Log.i(TAG, "Login success: " + user.getEmail() + " " + user.getScreenName());

        // Create an intent to start ActivitySuccess
        Intent intent = new Intent(MainActivity.this, ActivitySuccess.class);

        // Put the user details into the intent
        intent.putExtra("userEmail", user.getEmail());
        intent.putExtra("userScreenName", user.getScreenName());

        // Start ActivitySuccess
        startActivity(intent);

        // Show the Toast message
        Toast.makeText(MainActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(Exception e) {
        Log.e(TAG, "Login failed: ", e);
        Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthenticationBrowserShown() {
        Log.i(TAG, "Authentication browser shown.");
    }
}
