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

package org.tamarillo.addressws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class CodigoPostalPK.
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodigoPostalPK")
public class CodigoPostalPK implements Serializable {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4632943880446394426L;

	/** The cp4. */
	@Pattern(regexp = "\\d{4}", message = "must contain only numbers")
	@Column(name = "cp4")
	private String cp4;

	/** The cp3. */
	@Pattern(regexp = "\\d{3}", message = "must contain only numbers")
	@Column(name = "cp3")
	private String cp3;

	/**
	 * The Constructor.
	 */
	public CodigoPostalPK() {
	}

	/**
	 * Instantiates a new codigo postal pk.
	 *
	 * @param cp4 the cp4
	 * @param cp3 the cp3
	 */
	public CodigoPostalPK(String cp4, String cp3) {
		this.cp4 = cp4;
		this.cp3 = cp3;
	}

	/**
	 * Gets the cp4.
	 *
	 * @return the cp4
	 */
	public String getCp4() {
		return cp4;
	}

	/**
	 * Sets the cp4.
	 *
	 * @param cp4 the new cp4
	 */
	public void setCp4(String cp4) {
		this.cp4 = cp4;
	}

	/**
	 * Gets the cp3.
	 *
	 * @return the cp3
	 */
	public String getCp3() {
		return cp3;
	}

	/**
	 * Sets the cp3.
	 *
	 * @param cp3 the new cp3
	 */
	public void setCp3(String cp3) {
		this.cp3 = cp3;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp3 == null) ? 0 : cp3.hashCode());
		result = prime * result + ((cp4 == null) ? 0 : cp4.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodigoPostalPK other = (CodigoPostalPK) obj;
		if (cp3 == null) {
			if (other.cp3 != null)
				return false;
		} else if (!cp3.equals(other.cp3))
			return false;
		if (cp4 == null) {
			if (other.cp4 != null)
				return false;
		} else if (!cp4.equals(other.cp4))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CodigoPostalPK [cp4=" + cp4 + ", cp3=" + cp3 + "]";
	}
	
}
