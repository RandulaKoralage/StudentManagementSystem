/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.sms.controller;

import java.io.IOException;

/**
 *
 * @author Randula
 */
public class BackUpController {
    
    public static int restoreBackup(String path) throws IOException, InterruptedException {
        String[] executeCmd = new String[]{"mysql", "nanapiyasa", "--user=root", "--password=123", "-e", " source " + path};
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int res = runtimeProcess.waitFor();
        return res;
    }

    public static int writeBackup(String path) throws IOException, InterruptedException {
        Runtime runTime = Runtime.getRuntime();
        Process runtimeProcess = runTime.exec("mysqldump nanapiyasa -h localhost -u root -p123 --routines=true -r" + path);
        int res = runtimeProcess.waitFor();
        return res;
    }
}
