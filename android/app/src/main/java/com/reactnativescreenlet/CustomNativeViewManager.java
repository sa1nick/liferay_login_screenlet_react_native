package com.reactnativescreenlet;

import android.widget.FrameLayout;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

public class CustomNativeViewManager extends SimpleViewManager<FrameLayout> {

    public static final String REACT_CLASS = "CustomNativeView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected FrameLayout createViewInstance(ThemedReactContext reactContext) {
        FrameLayout frameLayout = new FrameLayout(reactContext);
        reactContext.getCurrentActivity().getLayoutInflater().inflate(R.layout.activity_main, frameLayout);
        return frameLayout;
    }
}
