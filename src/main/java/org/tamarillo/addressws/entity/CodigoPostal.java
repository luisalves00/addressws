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
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoPostal.
 */
@Entity
@Table(name = "CodigoPostal")
@NamedQueries({
		@NamedQuery(name = "CodigoPostal.findAll", query = "SELECT cp FROM CodigoPostal cp"),
		@NamedQuery(name = "CodigoPostal.findById", query = "SELECT cp FROM CodigoPostal cp WHERE cp.id = :id"),
		@NamedQuery(name = "CodigoPostal.findByCpalf", query = "SELECT cp FROM CodigoPostal cp WHERE cp.cpalf = :cpalf"),
		@NamedQuery(name = "CodigoPostal.findByLikeName", query = "SELECT cp FROM CodigoPostal cp WHERE cp.cpalf LIKE :cpalf") })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodigoPostal")
public class CodigoPostal implements IEntity, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3892972430665734301L;

	/** The concelho pk. */
	@EmbeddedId
	protected CodigoPostalPK id;

	/** The cpalf. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "cpalf")
	private String cpalf;
	
	/** The version. */
	@Version
	@Column(name = "version")
	@XmlTransient
	//@XmlJavaTypeAdapter(TimestampAdapter.class)
	private Timestamp version;
	
	/* ********************************* */
	/* ******** Relationship *********** */
	/* ********************************* */
	
	/** The localidade. */
	@OneToOne(mappedBy = "codigoPostal", cascade = CascadeType.ALL)
    private Localidade localidade;
	
	/** The arteria. */
	@OneToOne(mappedBy = "codigoPostal", cascade = CascadeType.ALL)
    private Arteria arteria;

	/**
	 * Gets the cpalf.
	 *
	 * @return the cpalf
	 */
	public String getCpalf() {
		return cpalf;
	}

	/**
	 * Sets the cpalf.
	 *
	 * @param cpalf the new cpalf
	 */
	public void setCpalf(String cpalf) {
		this.cpalf = cpalf;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Timestamp getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(Timestamp version) {
		this.version = version;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(CodigoPostalPK id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.model.IEntity#getId()
	 */
	@Override
	public Object getId() {
		return id;
	}
	
	/**
	 * Gets the arteria.
	 *
	 * @return the arteria
	 */
	public Arteria getArteria() {
		return arteria;
	}

	/**
	 * Sets the arteria.
	 *
	 * @param arteria the new arteria
	 */
	public void setArteria(Arteria arteria) {
		this.arteria = arteria;
	}

	/**
	 * Gets the localidade.
	 *
	 * @return the localidade
	 */
	public Localidade getLocalidade() {
		return localidade;
	}

	/**
	 * Sets the localidade.
	 *
	 * @param localidade the new localidade
	 */
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CodigoPostal other = (CodigoPostal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CodigoPostal [id=" + id + ", cpalf=" + cpalf + ", version="
				+ version + "]";
	}
	
}
