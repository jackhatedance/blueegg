package net.abstractfactory.yunos.service;

import java.util.List;
import java.util.Map;

import net.abstractfactory.yunos.remote.vo.AccessToken;
import net.abstractfactory.yunos.remote.vo.ConfigurationItem;
import net.abstractfactory.yunos.remote.vo.Device;
import net.abstractfactory.yunos.remote.vo.Driver;
import net.abstractfactory.yunos.remote.vo.DriverConfigurationDefinitionItem;
import net.abstractfactory.yunos.remote.vo.FunctionalDevice;
import net.abstractfactory.yunos.remote.vo.User;

public interface RemoteService {

	AccessToken requestAccessToken(String userId);

	void createUser(User user);

	User getUser(String userId);

	void revokeAccessToken(String key);
	
	void changePassword(String userId, String newPassword);

	/**
	 * list devices of a user.
	 * 
	 * @param userId
	 * @return device list
	 */
	List<Device> queryUserDevices(String userId, String deviceClassId);

	Device getDevice(String deviceId, String locale);

	/**
	 * user add a new device. it returns a device ID;
	 * 
	 * @param userId
	 * @param device
	 */
	String addDevice(String userId, Device device);

	/**
	 * can not delete others device
	 * 
	 * @param deviceId
	 */
	void removeDevice(String deviceId);

	/**
	 * get initial device configuration. note that the initial configuration are
	 * not bound to the device until you save them.
	 * 
	 * @param deviceId
	 * @return
	 */
	List<ConfigurationItem> getDeviceInitialConfiguration(String deviceId,
			String driverId);

	/**
	 * get device configuration.
	 * 
	 * @param deviceId
	 * @return
	 */
	List<ConfigurationItem> getDeviceConfiguration(String deviceId);

	/**
	 * update user configuration
	 * 
	 * @param deviceId
	 * @param config
	 */
	void updateDeviceConfiguration(String deviceId,
			List<ConfigurationItem> configuration);

	/**
	 * operate a device. the functional device API is varying.
	 * 
	 * @param deviceId ID of device
	 * @param functionalDeviceIndex index
	 * @param operationName operation
	 * @param parameters parameters
	 * @return result object, could be any object
	 */
	Object operateDevice(String deviceId, int functionalDeviceIndex,
			String operationName, Map<String, String> parameters);

	/**
	 * 
	 * @param locale
	 *            such as en_US
	 * @return list of vendors
	 */
	List<net.abstractfactory.yunos.remote.vo.Vendor> getAllVendors(String locale);

	List<net.abstractfactory.yunos.remote.vo.DeviceClass> getDeviceClasses(
			String vendorId, String locale);

	List<net.abstractfactory.yunos.remote.vo.Model> getModels(String vendorId,
			String deviceClassId, String locale);

	List<Driver> getAvailableDrivers(String modelId);

	List<DriverConfigurationDefinitionItem> getDriverConfigurationDefinitionItems(
			String driverId, String locale);

	void updateDevice(Device device);

	List<FunctionalDevice> getFunctionalDevices(String deviceId, String locale);

	/**
	 * query all functional devices for a user.
	 * 
	 * @param userId
	 * @param className
	 *            class name of functional device
	 * @param locale
	 * @return list of functional device
	 */
	List<FunctionalDevice> queryUserFunctionalDevices(String userId,
			String className, String locale);

	/**
	 * reload device driver after changing driver, device configuration.
	 * 
	 * @param deviceId ID of device
	 */
	void reloadDriver(String deviceId);

}