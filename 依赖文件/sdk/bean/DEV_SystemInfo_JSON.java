package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class DEV_SystemInfo_JSON {
	
	@JSONField(name="AlarmInChannel")
	public Integer alarmInChannel;//告警输入通道数
	@JSONField(name="AlarmOutChannel")
	public Integer alarmOutChannel;//告警输出通道数
	@JSONField(name="AudioInChannel")
	public Integer audioInChannel;//报警输入路数[0,16]
	@JSONField(name="BuildTime")
	public String buildTime;//编译时间
	@JSONField(name="CombineSwitch")
	public Integer combineSwitch;
	@JSONField(name="DeviceRunTime")
	public String deviceRunTime;//16进制要转成10进制，累计时间，单位是分钟
	@JSONField(name="DigChannel")
	public Integer digChannel;//
	@JSONField(name="EncryptVersion")
	public String encryptVersion;//加密版本号
	@JSONField(name="ExtraChannel")
	public Integer extraChannel;//扩展通道数
	@JSONField(name="HardWare")
	public String hardWare;//硬件标示
	@JSONField(name="HardWareVersion")
	public String hardWareVersion;//硬件版本号
	@JSONField(name="SerialNo")
	public String serialNo;//序列号
	@JSONField(name="SoftWareVersion")
	public String softWareVersion;//软件版本号
	@JSONField(name="TalkInChannel")
	public Integer talkInChannel;//对讲输入通道数
	@JSONField(name="TalkOutChannel")
	public Integer talkOutChannel;//对讲输出通道数
	@JSONField(name="UpdataTime")
	public String updataTime;//序修改时间

	/**
	 * //程序修改内容
	 * 0x00000001:web,
	 * 0x00000002:logo,
	 * 0x00000004:user分区
	 * 0x00000008:ROMFS
	 * 0x00000010:配置
	 * 0x00000020:语言字符串
	 * 0x00000040:图片
	 * 0x00000080:其他
	 */
	@JSONField(name="UpdataType")
	public String updataType;

	@JSONField(name="VideoInChannel")
	public Integer videoInChannel;//视频输入通道数
	@JSONField(name="VideoOutChannel")
	public Integer videoOutChannel;//视频输出通道数
	
	public Integer getAlarmInChannel() {
		return alarmInChannel;
	}
	public void setAlarmInChannel(Integer alarmInChannel) {
		this.alarmInChannel = alarmInChannel;
	}
	public Integer getAlarmOutChannel() {
		return alarmOutChannel;
	}
	public void setAlarmOutChannel(Integer alarmOutChannel) {
		this.alarmOutChannel = alarmOutChannel;
	}
	public Integer getAudioInChannel() {
		return audioInChannel;
	}
	public void setAudioInChannel(Integer audioInChannel) {
		this.audioInChannel = audioInChannel;
	}
	public String getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
	public Integer getCombineSwitch() {
		return combineSwitch;
	}
	public void setCombineSwitch(Integer combineSwitch) {
		this.combineSwitch = combineSwitch;
	}
	public String getDeviceRunTime() {
		return deviceRunTime;
	}
	public void setDeviceRunTime(String deviceRunTime) {
		this.deviceRunTime = deviceRunTime;
	}
	public Integer getDigChannel() {
		return digChannel;
	}
	public void setDigChannel(Integer digChannel) {
		this.digChannel = digChannel;
	}
	public String getEncryptVersion() {
		return encryptVersion;
	}
	public void setEncryptVersion(String encryptVersion) {
		this.encryptVersion = encryptVersion;
	}
	public Integer getExtraChannel() {
		return extraChannel;
	}
	public void setExtraChannel(Integer extraChannel) {
		this.extraChannel = extraChannel;
	}
	public String getHardWare() {
		return hardWare;
	}
	public void setHardWare(String hardWare) {
		this.hardWare = hardWare;
	}
	public String getHardWareVersion() {
		return hardWareVersion;
	}
	public void setHardWareVersion(String hardWareVersion) {
		this.hardWareVersion = hardWareVersion;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getSoftWareVersion() {
		return softWareVersion;
	}
	public void setSoftWareVersion(String softWareVersion) {
		this.softWareVersion = softWareVersion;
	}
	public Integer getTalkInChannel() {
		return talkInChannel;
	}
	public void setTalkInChannel(Integer talkInChannel) {
		this.talkInChannel = talkInChannel;
	}
	public Integer getTalkOutChannel() {
		return talkOutChannel;
	}
	public void setTalkOutChannel(Integer talkOutChannel) {
		this.talkOutChannel = talkOutChannel;
	}
	public String getUpdataTime() {
		return updataTime;
	}
	public void setUpdataTime(String updataTime) {
		this.updataTime = updataTime;
	}
	public String getUpdataType() {
		return updataType;
	}
	public void setUpdataType(String updataType) {
		this.updataType = updataType;
	}
	public Integer getVideoInChannel() {
		return videoInChannel;
	}
	public void setVideoInChannel(Integer videoInChannel) {
		this.videoInChannel = videoInChannel;
	}
	public Integer getVideoOutChannel() {
		return videoOutChannel;
	}
	public void setVideoOutChannel(Integer videoOutChannel) {
		this.videoOutChannel = videoOutChannel;
	}
}
