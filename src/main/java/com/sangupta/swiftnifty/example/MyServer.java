package com.sangupta.swiftnifty.example;

import java.util.ArrayList;
import java.util.List;

import com.facebook.nifty.processor.NiftyProcessor;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServerConfig;
import com.facebook.swift.service.ThriftServiceProcessor;

/**
 * Thrift server that can respond to RPC calls from clients.
 * 
 * Refer https://github.com/facebook/swift/tree/master/swift-service
 * 
 * @author sangupta
 *
 */
public class MyServer {
	
	public static void main(String[] args) {
		MyService service = new MyServiceImpl();
		
		List<ThriftEventHandler> handlers = new ArrayList<ThriftEventHandler>();
		
		NiftyProcessor processor = new ThriftServiceProcessor(new ThriftCodecManager(), handlers, service);
		final ThriftServer server = new ThriftServer(processor, new ThriftServerConfig().setPort(8899));
		server.start();
		System.out.println("Server has started...");
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				server.close();
			}
		});

		do {
			int at = server.getAcceptorThreads();
			int iot = server.getIoThreads();
			int wt = server.getWorkerThreads();
			
			System.out.println("Acceptor: " + at + ", IO: " + iot + ", Worker: " + wt);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		} while(true);
		
	}

}
