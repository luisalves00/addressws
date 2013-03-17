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

package org.tamarillo.addressws.model;

import java.util.Locale;

import javax.faces.context.FacesContext;

import org.tamarillo.addressws.util.JsfUtil;

/**
 * The Class LanguageLocale.
 */
public class Country {
	
	/** The locale. */
	private Locale locale;

	/** The label key. */
	private String labelKey;
	
	/** The flag css. */
	private String flagCss;

	/**
	 * Instantiates a new language locale.
	 * 
	 * @param locale
	 *            the locale
	 * @param labelKey
	 *            the label key
	 */
	public Country(Locale locale, String labelKey, String flagCss) {
		super();
		this.locale = locale;
		this.labelKey = labelKey;
		this.flagCss = flagCss;
	}

	/**
	 * Gets the locale.
	 * 
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Sets the locale.
	 * 
	 * @param locale
	 *            the new locale
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * Gets the label key.
	 * 
	 * @return the label key
	 */
	public String getLabelKey() {
		return labelKey;
	}

	/**
	 * Sets the label key.
	 * 
	 * @param labelKey
	 *            the new label key
	 */
	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}
	
	/**
	 * Gets the flag css.
	 *
	 * @return the flag css
	 */
	public String getFlagCss() {
		return flagCss;
	}

	/**
	 * Sets the flag css.
	 *
	 * @param flagCss the new flag css
	 */
	public void setFlagCss(String flagCss) {
		this.flagCss = flagCss;
	}

	/**
	 * Gets the label.
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return JsfUtil.getResourceText(labelKey,
				FacesContext.getCurrentInstance());
	}

	@Override
	public String toString() {
		return locale.toString();
	}

}
