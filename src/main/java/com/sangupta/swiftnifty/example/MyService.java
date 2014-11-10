package com.sangupta.swiftnifty.example;

import java.util.List;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

/**
 * Contract for loose coupling.
 * 
 * @author sangupta
 *
 */
@ThriftService
public interface MyService {
	
	@ThriftMethod("add")
	public String add(MyEntity entity);

	@ThriftMethod("getAll")
	public List<MyEntity> getAll();
	
}
