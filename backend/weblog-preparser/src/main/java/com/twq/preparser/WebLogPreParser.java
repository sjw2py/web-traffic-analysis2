package com.twq.preparser;

public class WebLogPreParser {
    public static PreparsedLog parse(String line) {
        if (line.startsWith("#")) {
            return null;
        }
        else {
            PreparsedLog preparsedLog = new PreparsedLog();
            String[] temp = line.split(" ");
            preparsedLog.setServerTime(temp[0] + " " + temp[1]);
            preparsedLog.setServerIp(temp[2]);
            preparsedLog.setMethod(temp[3]);
            preparsedLog.setUriStem(temp[4]);
            String tempUrl = temp[5];
            preparsedLog.setQueryString(tempUrl);
            preparsedLog.setServerPort(temp[6]);
            preparsedLog.setClientIp(temp[8]);
            preparsedLog.setUserAgent(temp[9].replace("+"," "));
            String[] tempUrlArr = tempUrl.split("&");
            preparsedLog.setCommand(tempUrlArr[1].split("=")[1]);
            //通过分隔符切分来获取profileId
            preparsedLog.setProfileId(Integer.valueOf(tempUrlArr[2].split("=")[1].split("-")[1]));
            //年月日
            String timeVar = temp[0].replace("-", "");
            preparsedLog.setYear(Integer.valueOf(timeVar.substring(0,4)));
            preparsedLog.setMonth(Integer.valueOf(timeVar.substring(0,6)));
            preparsedLog.setDay(Integer.valueOf(timeVar.substring(0,8)));

            return preparsedLog;
        }
    }


}
