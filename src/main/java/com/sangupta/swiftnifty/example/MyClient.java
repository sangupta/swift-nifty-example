package com.sangupta.swiftnifty.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.google.common.net.HostAndPort;

/**
 * Simple client that accesses a Thrift based server for running RPC methods.
 * 
 * @author sangupta
 *
 */
public class MyClient {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThriftClientManager clientManager = null;
		try {
			clientManager = new ThriftClientManager();
			FramedClientConnector connector = new FramedClientConnector(HostAndPort.fromParts("localhost", 8899));
			MyService service = clientManager.createClient(connector, MyService.class).get();
			List<MyEntity> list = createList();
			
			final long start = System.currentTimeMillis();
			for(MyEntity me : list) {
				service.add(me);
			}
			
			list = service.getAll();
			final long end = System.currentTimeMillis();
			
			System.out.println("Total time: " +  (end - start) + "ms");
			
			
			if(list != null) {
				System.out.println("Got " + list.size() + " items");
//				for(MyEntity me : list) {
//					System.out.println(me);
//				}
			} else {
				System.out.println("got null");
			}
		} finally {
			if(clientManager != null) {
				clientManager.close();
			}
		}
	}
	
	private static List<MyEntity> createList() {
		List<MyEntity> list = new ArrayList<MyEntity>();
		for(int i = 0; i < 50000; i++) {
			list.add(new MyEntity(String.valueOf(i), "test-" + i, "email-" + i));
		}
		
		return list;
	}

}
