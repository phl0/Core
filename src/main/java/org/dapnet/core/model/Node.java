/*
 * DAPNET CORE PROJECT
 * Copyright (C) 2016
 *
 * Daniel Sialkowski
 *
 * daniel.sialkowski@rwth-aachen.de
 *
 * Institute of High Frequency Technology
 * RWTH AACHEN UNIVERSITY
 * Melatener Str. 25
 * 52074 Aachen
 */

package org.dapnet.core.model;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jgroups.stack.IpAddress;

public class Node implements Serializable, Searchable {
	private static final long serialVersionUID = -4104175163845286560L;

	// ID
	@NotNull
	@Size(min = 3, max = 20)
	private String name;

	@NotNull
	@Digits(integer = 3, fraction = 8)
	@Min(-180)
	@Max(+180)
	private String longitude;

	@NotNull
	@Digits(integer = 3, fraction = 8)
	@Min(-90)
	@Max(+90)
	private String latitude;

	private IpAddress address;

	@NotNull
	private Status status;

	@NotNull
	private String key;

	public enum Status {
		ONLINE, SUSPENDED, UNKNOWN
	}

	// Used in case of creating new cluster
	public Node(String name, IpAddress address, String longitude, String latitude, Status status, String key) {
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
		this.status = status;
		this.key = key;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public IpAddress getAddress() {
		return address;
	}

	public void setAddress(IpAddress address) {
		this.address = address;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return String.format("Node{status=%s, name='%s'}", status, name);
	}
}
