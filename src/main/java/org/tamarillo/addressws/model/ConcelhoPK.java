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
	private static final long serialVersionUID = -1132136995494926673L;

	/** The id distrito. */
	@Column(name = "id_distrito")
	@NotNull
	private long idDistrito;

	/** The id concelho. */
	@NotNull
	@Column(name = "id_concelho")
	private long idConcelho;

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
	public ConcelhoPK(long idDistrito, long idConcelho) {
		this.idDistrito = idDistrito;
		this.idConcelho = idConcelho;
	}

	/**
	 * Gets the id distrito.
	 * 
	 * @return the id distrito
	 */
	public long getIdDistrito() {
		return idDistrito;
	}

	/**
	 * Sets the id distrito.
	 * 
	 * @param idDistrito
	 *            the id distrito
	 */
	public void setIdDistrito(long idDistrito) {
		this.idDistrito = idDistrito;
	}

	/**
	 * Gets the id concelho.
	 * 
	 * @return the id concelho
	 */
	public long getIdConcelho() {
		return idConcelho;
	}

	/**
	 * Sets the id concelho.
	 * 
	 * @param idConcelho
	 *            the id concelho
	 */
	public void setIdConcelho(long idConcelho) {
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
		result = prime * result + (int) (idConcelho ^ (idConcelho >>> 32));
		result = prime * result + (int) (idDistrito ^ (idDistrito >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		if (idConcelho != other.idConcelho) {
			return false;
		}
		if (idDistrito != other.idDistrito) {
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
