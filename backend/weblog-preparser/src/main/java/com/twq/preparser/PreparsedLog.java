package com.twq.preparser;

public class PreparsedLog {
    private String serverTime;
    private String serverIp;
    private String method;
    private String uriStem;
    private String queryString;
    private String serverPort;
    private String clientIp;
    private String userAgent;
    private int profileId;
    private String command;

    //用于hive表分区
    private int year;
    private int month;
    private int day;

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUriStem(String uriStem) {
        this.uriStem = uriStem;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getServerTime() {
        return serverTime;
    }

    public String getServerIp() {
        return serverIp;
    }

    public String getMethod() {
        return method;
    }

    public String getUriStem() {
        return uriStem;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getServerPort() {
        return serverPort;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public int getProfileId() {
        return profileId;
    }

    public String getCommand() {
        return command;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
