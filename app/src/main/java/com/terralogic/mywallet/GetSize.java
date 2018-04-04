package com.terralogic.mywallet;

public class GetSize {
    int screen_height=0, screen_width=0;
    WindowManager wm;
    DisplayMetrics displaymetrics;

    GetSize(Context context) {

        getdisplayheightWidth(context);
    }

    void getdisplayheightWidth(Context context) {
        wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        displaymetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displaymetrics);
        screen_height = displaymetrics.heightPixels;
        screen_width = displaymetrics.widthPixels;
    }

    public int getScreen_height() {
        return screen_height;
    }

    public int getScreen_width() {
        return screen_width;
    }
}
