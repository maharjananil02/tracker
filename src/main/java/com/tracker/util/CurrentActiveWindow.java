package com.tracker.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CurrentActiveWindow {



    public static final String WIN_INFO_CMD_PREFIX = "xwininfo -id ";
    public static final String WIN_INFO_CMD_MID = " |awk \'BEGIN {FS=\"\\\"\"}/xwininfo: Window id/{print $2}\' | sed \'s/-[^-]*$//g\'";

    public String execShellCmd(String cmd){
        try {

            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(new String[] { "/bin/bash", "-c", cmd });
            int exitValue = process.waitFor();
            System.out.println("exit value: " + exitValue);
            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            String output = "";
            while ((line = buf.readLine()) != null) {
                output = line;
            }
            return output;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String windowInfoCmd(String winId){
        if(null!=winId && !"".equalsIgnoreCase(winId)){
            return WIN_INFO_CMD_PREFIX+winId +WIN_INFO_CMD_MID;
        }
        return null;
    }

}
