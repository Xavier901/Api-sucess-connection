adb reverse tcp:8000 tcp:8000
8000

<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

android:usesCleartextTraffic="true"
android:networkSecurityConfig="@xml/network_security_config"

<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config cleartextTrafficPermitted="true">
        <domain includeSubdomains="true">127.0.0.1</domain>
        <domain includeSubdomains="true">172.20.160.1</domain>
        <domain includeSubdomains="true">10.0.2.2</domain>
    </domain-config>
</network-security-config>

inside network security config file

Control Panel\All Control Panel Items\Windows Defender Firewall\Allowed apps

allow android studios
