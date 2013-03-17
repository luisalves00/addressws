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
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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



/**
 * The Class Localidade.
 */
@Entity
@Table(name = "Localidade")
@NamedQueries({ @NamedQuery(name = "Localidade.findAll", query = "SELECT l FROM Localidade l"),
		@NamedQuery(name = "Localidade.findByLikeName", query = "SELECT l FROM Localidade l WHERE l.name LIKE :name") })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Localidade")
public class Localidade implements IEntity, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5712355616301529260L;

	/** The Localidade pk. */
	@EmbeddedId
	protected LocalidadePK id;

	/** The name. */
	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "name")
	private String name;

	/** The version. */
	@Version
	@Column(name = "version")
	@XmlTransient
	//@XmlJavaTypeAdapter(TimestampAdapter.class)
	private Timestamp version;
	
	/** The cp4. */
	@Pattern(regexp = "\\d{4}", message = "must contain only numbers")
	@Column(name = "cp4")
	private String cp4;

	/** The cp3. */
	@Pattern(regexp = "\\d{3}", message = "must contain only numbers")
	@Column(name = "cp3")
	private String cp3;

	/* ********************************* */
	/* ******** Relationship *********** */
	/* ********************************* */

	/** The concelho. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_distrito", insertable = false, updatable = false),
			@JoinColumn(name = "id_concelho", insertable = false, updatable = false) })
	private Concelho concelho;
	
	/** The arterias. */
	@OneToMany(mappedBy = "localidade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@XmlTransient
	public Set<Arteria> arterias;
	
    /** The codigo postal. */
    @OneToOne
    @JoinColumns({ @JoinColumn(name = "cp4", insertable = false, updatable = false),
		@JoinColumn(name = "cp3", insertable = false, updatable = false) })
    private CodigoPostal codigoPostal;


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tamarillo.addressws.model.IEntity#getId()
	 */
	public LocalidadePK getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the id
	 */
	public void setId(LocalidadePK id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the version.
	 * 
	 * @param version
	 *            the new version
	 */
	public void setVersion(Timestamp version) {
		this.version = version;
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
	 * Gets the concelho.
	 *
	 * @return the concelho
	 */
	public Concelho getConcelho() {
		return concelho;
	}

	/**
	 * Sets the concelho.
	 *
	 * @param concelho the concelho to set
	 */
	public void setConcelho(Concelho concelho) {
		this.concelho = concelho;
	}
	
	/**
	 * Gets the arterias.
	 *
	 * @return the arterias
	 */
	public Set<Arteria> getArterias() {
		return arterias;
	}

	/**
	 * Sets the arterias.
	 *
	 * @param arterias the new arterias
	 */
	public void setArterias(Set<Arteria> arterias) {
		this.arterias = arterias;
	}

	/**
	 * Gets the codigo postal.
	 *
	 * @return the codigo postal
	 */
	public CodigoPostal getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * Sets the codigo postal.
	 *
	 * @param codigoPostal the new codigo postal
	 */
	public void setCodigoPostal(CodigoPostal codigoPostal) {
		this.codigoPostal = codigoPostal;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!(obj instanceof Localidade)) {
			return false;
		}
		Localidade other = (Localidade) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
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
		return "Localidade [id=" + id + "]";
	}

}
