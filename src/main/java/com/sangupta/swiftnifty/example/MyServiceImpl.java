package com.sangupta.swiftnifty.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link MyService}
 * 
 * @author sangupta
 *
 */
public class MyServiceImpl implements MyService {
	
	private static final List<MyEntity> list = new ArrayList<MyEntity>();
	
	public String add(MyEntity entity) {
		if(entity == null) {
			return null;
		}
		
		list.add(entity);
		return "done";
	}

	public List<MyEntity> getAll() {
		return list;
	}

}
