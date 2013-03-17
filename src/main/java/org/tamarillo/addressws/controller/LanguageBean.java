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
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tamarillo.addressws.jsf.converter.CountryConverter;
import org.tamarillo.addressws.model.Country;
import org.tamarillo.addressws.util.JsfUtil;

/**
 * The Class LanguageBean.
 */
@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4881768578431058764L;

	/** The Constant COOKIE_SELECTED_LANGUAGE_KEY. */
	private static final String COOKIE_SELECTED_LANGUAGE_KEY = "addressws-selectedCountry";

	/** The selected country. */
	private Country selectedCountry;

	/** The map with the supported countries. */
	public static List<Country> countries;
	static {
		countries = new LinkedList<Country>();
		countries.add(new Country(new Locale("pt", "PT"),
				"page.language.selector.pt", "flag-pt"));
		countries.add(new Country(new Locale("en", "US"),
				"page.language.selector.en", "flag-us"));
		
	}

	// -----------------------------------------------
	// ------------------ Listeners ------------------
	// -----------------------------------------------

	// <p:ajax event="change" listener="#{language.localeCodeChanged}" />
	// /**
	// * Locale code changed.
	// */
	// public void localeCodeChanged() {
	// //set the current page with the selected locale
	// FacesContext.getCurrentInstance().getViewRoot()
	// .setLocale(selectedCountry.getLocale());
	//
	// //persist to a cookie
	// }

	// -----------------------------------------------
	// -------------- Getters/Setters ----------------
	// -----------------------------------------------

	/**
	 * Gets the supported countries.
	 * 
	 * @return the countries
	 */
	public List<Country> getCountries() {
		return countries;
	}

	/**
	 * Gets the selected country.
	 * 
	 * @return the selected country
	 */
	public Country getSelectedCountry() {
		if (selectedCountry == null) {
			// check for the cookie
			Cookie cookie = getCookie(COOKIE_SELECTED_LANGUAGE_KEY);
			if (cookie == null) {
				// if not existing use default
				selectedCountry = new Country(new Locale("pt", "PT"),
						"page.language.selector.pt", "flag-pt");
				setCookie(COOKIE_SELECTED_LANGUAGE_KEY,
						selectedCountry.toString());
			} else {
				String cookieValue = cookie.getValue();
				for (Country c : countries) {
					if (c.toString().equals(cookieValue)) {
						selectedCountry = c;
					}
				}
			}

		}
		return selectedCountry;
	}

	/**
	 * Sets the selected country.
	 * 
	 * @param selectedCountry
	 *            the new selected country
	 */
	public void setSelectedCountry(Country selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	/**
	 * @param cookieKey
	 * @param cookieValue
	 */
	private void setCookie(String cookieKey, String cookieValue) {
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		Cookie cookie = new Cookie(cookieKey, cookieValue);
		cookie.setVersion(0);
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		cookie.setMaxAge(365 * 24 * 60 * 60);
		cookie.setComment("Selected Language");
		httpServletResponse.addCookie(cookie);
		String cookieHeader = httpServletResponse.getHeader("Set-Cookie");
		cookieHeader += "; Expires="
				+ new Date((new Date()).getTime() + (365 * 24 * 60 * 60 * 1000));
		httpServletResponse.setHeader("Set-Cookie", cookieHeader);
	}

	/**
	 * @param cookieKey
	 * @return
	 */
	private Cookie getCookie(String cookieKey) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		Cookie[] cookies = httpServletRequest.getCookies();
		Cookie cookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equalsIgnoreCase(cookieKey)) {
					cookie = cookies[i];
					break;
				}
			}
		}
		return cookie;
	}

}
