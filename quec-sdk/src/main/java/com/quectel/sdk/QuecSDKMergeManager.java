package com.quectel.sdk;

import android.app.Application;

import com.quectel.app.blesdk.utils.QuecBleServiceManager;
import com.quectel.app.common.tools.utils.GlobalConfig;
import com.quectel.app.common.tools.utils.QuecCommonManager;
import com.quectel.app.device.utils.QuecDeviceServiceManager;
import com.quectel.app.quecnetwork.QuecNetWorkManager;


public class QuecSDKMergeManager {

    private static QuecSDKMergeManager csi = null;

    private QuecSDKMergeManager() {
    }

    public static QuecSDKMergeManager getInstance() {
        if (csi == null) {
            synchronized (QuecSDKMergeManager.class) {
                if (csi == null) {
                    csi = new QuecSDKMergeManager();
                }
            }
        }
        return csi;
    }

    public void init(Application app) {
        QuecNetWorkManager.getInstance().init(app);
        QuecDeviceServiceManager.getInstance().init(app);
        QuecBleServiceManager.getInstance().init(app);

    }


    public void initProject(int serviceType, String userDomain, String domainSecret) {
        QuecCommonManager.getInstance().configServiceType(serviceType);
        QuecCommonManager.getInstance().configUserDomain(userDomain);
        QuecCommonManager.getInstance().configDomainSecret(domainSecret);
        if (serviceType == 0) {
            GlobalConfig.BASE_BASE_URL = "https://iot-gateway.quectel.com";
            GlobalConfig.WEB_SOCKET = "wss://iot-ws.quectel.com/ws/v1";
            GlobalConfig.EAID = "C1";
            GlobalConfig.ETID_REGISTER = "C1";
            GlobalConfig.ETID_RESET_PASSWORD = "C2";
            GlobalConfig.ETID_DELETE_ACCOUNT = "C5";
            GlobalConfig.SSID = "C1";
            GlobalConfig.STID_REGISTER = "C3";
            GlobalConfig.STID_LOGIN = "C2";
            GlobalConfig.STID_RESET_PASSWORD = "C1";
            GlobalConfig.Account_Cancellation = "C7";
        } else {
            GlobalConfig.BASE_BASE_URL = "https://ioteu-gateway.quectel.com";
            GlobalConfig.WEB_SOCKET = "wss://ioteu-ws.quectel.com/ws/v1";
            GlobalConfig.EAID = "E1";
            GlobalConfig.ETID_REGISTER = "E1";
            GlobalConfig.ETID_RESET_PASSWORD = "E2";
            GlobalConfig.ETID_DELETE_ACCOUNT = "E5";
            GlobalConfig.SSID = "C1";
            GlobalConfig.STID_REGISTER = "C4";
            GlobalConfig.STID_LOGIN = "C5";
            GlobalConfig.STID_RESET_PASSWORD = "C6";
            GlobalConfig.Account_Cancellation = "C8";
        }
    }

}