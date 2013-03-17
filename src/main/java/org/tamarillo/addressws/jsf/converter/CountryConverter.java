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

package org.tamarillo.addressws.jsf.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.tamarillo.addressws.controller.LanguageBean;
import org.tamarillo.addressws.model.Country;

/**
 * The Class CountryConverter.
 */
@FacesConverter(forClass = org.tamarillo.addressws.model.Country.class)
public class CountryConverter implements Converter, Serializable {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5355209065937351861L;

	/**
	 * Gets the as object.
	 *
	 * @param facesContext the faces context
	 * @param component the component
	 * @param string the string
	 * @return the as object
	 */
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String string) {
		if (string == null || string.length() == 0) {
			return null;
		}
		for (Country c : LanguageBean.countries) {

			if (c.toString().equals(string)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Gets the as string.
	 *
	 * @param facesContext the faces context
	 * @param component the component
	 * @param object the object
	 * @return the as string
	 */
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Country) {
			Country o = (Country) object;
			return o.toString() == null ? "" : o.toString();
		} else {
			throw new IllegalArgumentException(
					"object "
							+ object
							+ " is of type "
							+ object.getClass().getName()
							+ "; expected type: org.tamarillo.addressws.model.Country.class");
		}
	}

}
