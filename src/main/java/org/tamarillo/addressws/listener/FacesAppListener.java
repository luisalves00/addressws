package org.tamarillo.addressws.listener;

import java.util.logging.LogManager;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class FacesAppListener implements SystemEventListener {
	
	private static Logger log = LoggerFactory.getLogger(FacesAppListener.class);

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {

		if (event instanceof PostConstructApplicationEvent) {
			System.out.println("PostConstructApplicationEvent is Called");
			slf4JBridgeHandlerInstal();
		}

		if (event instanceof PreDestroyApplicationEvent) {
			System.out.println("PreDestroyApplicationEvent is Called");
		}

	}

	@Override
	public boolean isListenerForSource(Object source) {
		// only for Application
		return (source instanceof Application);

	}

	/**
	 * SLF4JBridgeHandler install
	 */
	public static void slf4JBridgeHandlerInstal() {
		try {
			//FIXME: generates an infinite loop
			//SLF4JBridgeHandler.install(); // install SLF4JBridgeHandler
		} catch (Exception ex) {
			log.error("Couldn't initialize the  SLF4JBridgeHandler.install()!",ex);
		}
	}

}