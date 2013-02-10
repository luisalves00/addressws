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

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.tamarillo.addressws.csv.CsvReader;
import org.tamarillo.addressws.util.JsfUtil;

/**
 * The Class AdminController.
 */
@ManagedBean(name="admin")
@ViewScoped
public class AdminController implements Serializable{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7771383570022793589L;
	
	/** The Constant MAX_FILE_SIZE. */
	public static final String MAX_FILE_SIZE = "31457280"; //30Mb
	
	/** The log. */
	@Inject
	private Logger log;
	
	@Inject
	private CsvReader csvReader;
	
	/** The file. */
	private UploadedFile file;
	
	/** The file uploaded. */
	private boolean fileUploaded = false;
	
	
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
	 * Handle file upload.
	 *
	 * @param event the event
	 */
	public void handleFileUpload(FileUploadEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			file = event.getFile();
			fileUploaded = true;
			JsfUtil.addSuccessMessage("admin.csv.file.upload.success", ctx, FilenameUtils.getName(file.getFileName()));
		} catch (Exception e) {
			log.error("Error handleling the csv file upload.", e);
			JsfUtil.addErrorMessage("admin.csv.file.upload.error", ctx);
			fileUploaded = false;
		}
		
	}
	
	/**
	 * Handle distrito csv file.
	 */
	public void handleDistritoCsvFile(ActionEvent evt) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			csvReader.handleDistritoCsvFile(file.getInputstream());
			JsfUtil.addSuccessMessage("admin.csv.file.distritos.execute.success", ctx);
		} catch (IOException e) {
			log.error("Error reading the csv file.",e);
		} catch (Exception e) {
			log.error("Unexpected Exception.",e);
			JsfUtil.addErrorMessage("admin.csv.file.distritos.execute.error", ctx);
		}
	}

	
	/**
	 * Handle concelho csv file.
	 */
	public void handleConcelhoCsvFile(ActionEvent evt) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			csvReader.handleConcelhoCsvFile(file.getInputstream());
			JsfUtil.addSuccessMessage("admin.csv.file.concelhos.execute.success", ctx);
		} catch (IOException e) {
			log.error("Error reading the csv file.",e);
		} catch (Exception e) {
			log.error("Unexpected Exception.",e);
			JsfUtil.addErrorMessage("admin.csv.file.concelhos.execute.error", ctx);
		}
	}

	/**
	 * Handle todos codigos postais csv file.
	 */
	public void handleTodosCodigosPostaisCsvFile(ActionEvent evt) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			csvReader.handleTodosCodigosPostaisCsvFile(file.getInputstream());
			JsfUtil.addSuccessMessage("admin.csv.file.all.zip.code.execute.success", ctx);
		} catch (IOException e) {
			log.error("Error reading the csv file.",e);
		} catch (Exception e) {
			log.error("Unexpected Exception.",e);
			JsfUtil.addErrorMessage("admin.csv.file.all.zip.code.execute.error", ctx);
		}
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

	/**
	 * Checks if is file uploaded.
	 *
	 * @return true, if is file uploaded
	 */
	public boolean isFileUploaded() {
		return fileUploaded;
	}

	
}
