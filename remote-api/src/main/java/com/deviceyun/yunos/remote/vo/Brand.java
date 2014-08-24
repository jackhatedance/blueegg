package com.deviceyun.yunos.remote.vo;

import java.io.Serializable;


/**
 * it is a entity.
 * 
 * @author jack
 * 
 */
public class Brand implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1772551256715574984L;

	private String id;

	private String name;

	private String description;

	private String languageCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

}
