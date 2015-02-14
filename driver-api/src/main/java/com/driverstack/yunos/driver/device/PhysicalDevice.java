package com.driverstack.yunos.driver.device;

import java.util.List;

import com.driverstack.yunos.ExecutionEnvironment;

/**
 * it is physical device.
 * 
 * @author jack
 * 
 */
public interface PhysicalDevice {

	@Deprecated
	void init(ExecutionEnvironment executionEnvironment, Object configure);
	
	void init(ExecutionEnvironment executionEnvironment, DeviceInfo deviceInfo);
	
	void destroy();
	
	Object getConfigure();

	List<FunctionalDevice> getFunctionDevices();

	FunctionalDevice getFunctionDevice(int index);
		
}
