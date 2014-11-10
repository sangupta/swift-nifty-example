package com.sangupta.swiftnifty.example;

import com.facebook.swift.codec.ThriftConstructor;
import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;

/**
 * The object that is transferred between RPC calls.
 * 
 * @author sangupta
 *
 */
@ThriftStruct
public final class MyEntity {
	
	private String id;
	
	private String name;
	
	private String email;
	
	@ThriftConstructor
	public MyEntity(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return this.id + "::" + this.name + "::" + this.email;
	}
	
	@ThriftField(1)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ThriftField(2)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ThriftField(3)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
