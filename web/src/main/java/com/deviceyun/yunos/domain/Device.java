package com.deviceyun.yunos.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.json.JSONObject;

import com.deviceyun.yunos.api.device.DeviceInfo;

/**
 * physical device
 * 
 * @author jackding
 * 
 */
@javax.persistence.Entity
@Table
public class Device {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@JoinColumn(name = "modelId")
	@ManyToOne(cascade = CascadeType.ALL)
	private Model model;
	@Column
	private String revision;
	@Column
	private String mfgSerialNumber;

	/**
	 * factory configure
	 */
	@Column
	private String factoryConfigure;

	@JoinColumn(name = "userId")
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	@JoinColumn(name = "driverId")
	@ManyToOne(cascade = CascadeType.ALL)
	private Driver driver;

	@JoinColumn(name = "deviceApiId")
	@ManyToOne(cascade = CascadeType.ALL)
	private DeviceApi deviceApi;
	@Column
	private String deviceApiVersion;

	@Column
	private String userConfigure;
	@Column
	private String deviceState;

	@Column
	private String name;
	@Column
	private String location;
	@Column
	private String description;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMfgSerialNumber() {
		return mfgSerialNumber;
	}

	public void setMfgSerialNumber(String mfgSerialNumber) {
		this.mfgSerialNumber = mfgSerialNumber;
	}

	public String getFactoryConfigure() {
		return factoryConfigure;
	}

	public void setFactoryConfigure(String factoryConfigure) {
		this.factoryConfigure = factoryConfigure;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public DeviceApi getDeviceApi() {
		return deviceApi;
	}

	public void setDeviceApi(DeviceApi deviceApi) {
		this.deviceApi = deviceApi;
	}

	public String getDeviceApiVersion() {
		return deviceApiVersion;
	}

	public void setDeviceApiVersion(String deviceApiVersion) {
		this.deviceApiVersion = deviceApiVersion;
	}

	public String getUserConfigure() {
		return userConfigure;
	}

	public void setUserConfigure(String userConfigure) {
		this.userConfigure = userConfigure;
	}

	public String getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * override model configure by device factory configure then user configure
	 * 
	 * @return
	 */
	public JSONObject getFinalConfigure() {

		String modelConfigStr = model.getConfigure();
		String deviceConfigStr = this.factoryConfigure;
		String userConfigStr = this.getUserConfigure();

		if (modelConfigStr == null)
			modelConfigStr = "{}";

		if (deviceConfigStr == null)
			deviceConfigStr = "{}";

		if (userConfigStr == null)
			userConfigStr = "{}";

		JSONObject modelConfig = new JSONObject(modelConfigStr);
		JSONObject deviceConfig = new JSONObject(deviceConfigStr);
		JSONObject userConfig = new JSONObject(userConfigStr);

		JSONObject computedConfig = new JSONObject();
		for (Object objKey : modelConfig.keySet()) {
			String key = (String) objKey;
			Object value = modelConfig.get(key);
			computedConfig.put(key, value);
		}
		// overwrite with device configure
		for (Object objKey : deviceConfig.keySet()) {
			String key = (String) objKey;
			Object value = deviceConfig.get(key);
			computedConfig.put(key, value);
		}

		// overwrite with user configure
		for (Object objKey : userConfig.keySet()) {
			String key = (String) objKey;
			Object value = userConfig.get(key);
			computedConfig.put(key, value);
		}

		return computedConfig;
	}

	public DeviceInfo getInfo() {

		return new DeviceInfo(id, model.getVO(), getFinalConfigure());

	}
}
