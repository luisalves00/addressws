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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The Class ConcelhoPK.
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConcelhoPK")
public class ConcelhoPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3955259818700681326L;

	/** The id distrito. */
	@Column(name = "id_distrito")
	@NotNull
	@Size(min = 2, max = 2)
	// missing regexp
	private String idDistrito;

	/** The id concelho. */
	@NotNull
	@Column(name = "id_concelho")
	@Size(min = 2, max = 2)
	private String idConcelho;

	/**
	 * The Constructor.
	 */
	public ConcelhoPK() {
	}

	/**
	 * The Constructor.
	 * 
	 * @param idDistrito
	 *            the id distrito
	 * @param idConcelho
	 *            the id concelho
	 */
	public ConcelhoPK(String idDistrito, String idConcelho) {
		this.idDistrito = idDistrito;
		this.idConcelho = idConcelho;
	}

	/**
	 * Gets the id distrito.
	 * 
	 * @return the id distrito
	 */
	public String getIdDistrito() {
		return idDistrito;
	}

	/**
	 * Sets the id distrito.
	 * 
	 * @param idDistrito
	 *            the id distrito
	 */
	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}

	/**
	 * Gets the id concelho.
	 * 
	 * @return the id concelho
	 */
	public String getIdConcelho() {
		return idConcelho;
	}

	/**
	 * Sets the id concelho.
	 * 
	 * @param idConcelho
	 *            the id concelho
	 */
	public void setIdConcelho(String idConcelho) {
		this.idConcelho = idConcelho;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConcelho == null) ? 0 : idConcelho.hashCode());
		result = prime * result + ((idDistrito == null) ? 0 : idDistrito.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ConcelhoPK)) {
			return false;
		}
		ConcelhoPK other = (ConcelhoPK) obj;
		if (idConcelho == null) {
			if (other.idConcelho != null) {
				return false;
			}
		} else if (!idConcelho.equals(other.idConcelho)) {
			return false;
		}
		if (idDistrito == null) {
			if (other.idDistrito != null) {
				return false;
			}
		} else if (!idDistrito.equals(other.idDistrito)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConcelhoPK [idDistrito=" + idDistrito + ", idConcelho=" + idConcelho + "]";
	}

}
