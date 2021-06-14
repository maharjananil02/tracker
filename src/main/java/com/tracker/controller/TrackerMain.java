package com.tracker.controller;

import com.tracker.domain.Tracker;
import com.tracker.service.TrackerService;
import com.tracker.util.CurrentActiveWindow;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;


public class TrackerMain {
    @Autowired
    private TrackerService service;

    public static final String WIN_ID_CMD = "xprop -root | grep " + "\"_NET_ACTIVE_WINDOW(WINDOW)\"" + "|cut -d ' ' -f 5";


    private Long time;

    public void getInformation(){
        CurrentActiveWindow activeWindow = new CurrentActiveWindow();
        Tracker tracker = new Tracker();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        time = System.currentTimeMillis();
        String windowTitle = activeWindow.execShellCmd(activeWindow.windowInfoCmd(activeWindow.execShellCmd(WIN_ID_CMD)));
        tracker.setTitle(windowTitle);
        tracker.setTime(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()-time));
        service.save(tracker);
    }

    public static void main(String[] args) {
        TrackerMain trackerMain = new TrackerMain();
        trackerMain.getInformation();
    }

}




