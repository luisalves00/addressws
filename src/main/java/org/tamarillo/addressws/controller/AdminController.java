/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tamarillo.addressws.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;

/**
 * The Class AdminController.
 */
@ConversationScoped
@Named(value = "admin")
public class AdminController implements Serializable{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7771383570022793589L;
	
	public static final String MAX_FILE_SIZE = "3932160"; //30Mb
	
	/** The log. */
	@Inject
	private Logger log;
	
	
	/**
	 * Initialize.
	 */
	@PostConstruct
	protected void initialize() {
	}

	/* ********************************* */
	/* ************ Actions ************ */
	/* ********************************* */
	
	/**
	 * Handle distrito file upload.
	 *
	 * @param event the event
	 */
	public void handleDistritoFileUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		//invoke the csv file process
		
	}
	
	/**
	 * Handle concelho file upload.
	 *
	 * @param event the event
	 */
	public void handleConcelhoFileUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		//invoke the csv file process
		
	}

	
	/**
	 * Handle todos codigos postais file upload.
	 *
	 * @param event the event
	 */
	public void handleTodosCodigosPostaisFileUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		//invoke the csv file process
	}

	/* ********************************* */
	/* ******** Getters/Setters ******** */
	/* ********************************* */
	
	/**
	 * Gets the max file size.
	 *
	 * @return the max file size
	 */
	public String getMaxFileSize(){
		return MAX_FILE_SIZE;
	}
	
}
