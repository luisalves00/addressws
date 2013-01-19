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
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.tamarillo.addressws.xml.util.TimestampAdapter;

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
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "name")
	private String name;

	/** The arteria type. */
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "arteria_type")
	private String arteriaType;

	/** The first prep. */
	@Size(min = 1, max = 8)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "first_prep")
	private String firstPrep;

	/** The arteria title. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "arteria_title")
	private String arteriaTitle;

	/** The second prep. */
	@Size(min = 1, max = 8)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "second_prep")
	private String secondPrep;

	/** The arteria name. */
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "arteria_name")
	private String arteriaName;

	/** The arteria local. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "arteria_local")
	private String arteriaLocal;

	/** The troco. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "troco")
	private String troco;

	/** The porta. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "porta")
	private String porta;

	/** The cliente. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "cliente")
	private String cliente;

	/** The cp4. */
	@Size(min = 4, max = 4)
	@Pattern(regexp = "[A-Za-z]*", message = "must contain only letters and spaces")
	@Column(name = "cp4")
	private String cp4;

	/** The cp3. */
	@Size(min = 3, max = 3)
	@Pattern(regexp = "[A-Za-z]*", message = "must contain only letters and spaces")
	@Column(name = "cp3")
	private String cp3;

	/** The cpalf. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z]*", message = "must contain only letters and spaces")
	@Column(name = "cpalf")
	private String cpalf;

	/** The version. */
	@Version
	@NotNull
	@Column(name = "version")
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	private Timestamp version;

	/* ********************************* */
	/* ******** Relationship *********** */
	/* ********************************* */

	// /** The distrito. */
	// @ManyToOne
	// @JoinColumn(name = "id_distrito", insertable = false, updatable = false)
	// @XmlTransient
	// private Distrito distrito;
	//
	// /** The distrito. */
	// @ManyToOne
	// /** The concelho. */
	// @JoinColumns({ @JoinColumn(name = "id_distrito", insertable = false,
	// updatable = false),
	// @JoinColumn(name = "id_concelho", insertable = false, updatable = false)
	// })
	// @XmlTransient
	// private Concelho concelho;

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
	 * Gets the arteria type.
	 * 
	 * @return the arteria type
	 */
	public String getArteriaType() {
		return arteriaType;
	}

	/**
	 * Sets the arteria type.
	 * 
	 * @param arteriaType
	 *            the new arteria type
	 */
	public void setArteriaType(String arteriaType) {
		this.arteriaType = arteriaType;
	}

	/**
	 * Gets the first prep.
	 * 
	 * @return the first prep
	 */
	public String getFirstPrep() {
		return firstPrep;
	}

	/**
	 * Sets the first prep.
	 * 
	 * @param firstPrep
	 *            the new first prep
	 */
	public void setFirstPrep(String firstPrep) {
		this.firstPrep = firstPrep;
	}

	/**
	 * Gets the arteria title.
	 * 
	 * @return the arteria title
	 */
	public String getArteriaTitle() {
		return arteriaTitle;
	}

	/**
	 * Sets the arteria title.
	 * 
	 * @param arteriaTitle
	 *            the new arteria title
	 */
	public void setArteriaTitle(String arteriaTitle) {
		this.arteriaTitle = arteriaTitle;
	}

	/**
	 * Gets the second prep.
	 * 
	 * @return the second prep
	 */
	public String getSecondPrep() {
		return secondPrep;
	}

	/**
	 * Sets the second prep.
	 * 
	 * @param secondPrep
	 *            the new second prep
	 */
	public void setSecondPrep(String secondPrep) {
		this.secondPrep = secondPrep;
	}

	/**
	 * Gets the arteria name.
	 * 
	 * @return the arteriaName
	 */
	public String getArteriaName() {
		return arteriaName;
	}

	/**
	 * Sets the arteria name.
	 * 
	 * @param arteriaName
	 *            the arteriaName to set
	 */
	public void setArteriaName(String arteriaName) {
		this.arteriaName = arteriaName;
	}

	/**
	 * Gets the arteria local.
	 * 
	 * @return the arteria local
	 */
	public String getArteriaLocal() {
		return arteriaLocal;
	}

	/**
	 * Sets the arteria local.
	 * 
	 * @param arteriaLocal
	 *            the new arteria local
	 */
	public void setArteriaLocal(String arteriaLocal) {
		this.arteriaLocal = arteriaLocal;
	}

	/**
	 * Gets the troco.
	 * 
	 * @return the troco
	 */
	public String getTroco() {
		return troco;
	}

	/**
	 * Sets the troco.
	 * 
	 * @param troco
	 *            the new troco
	 */
	public void setTroco(String troco) {
		this.troco = troco;
	}

	/**
	 * Gets the porta.
	 * 
	 * @return the porta
	 */
	public String getPorta() {
		return porta;
	}

	/**
	 * Sets the porta.
	 * 
	 * @param porta
	 *            the new porta
	 */
	public void setPorta(String porta) {
		this.porta = porta;
	}

	/**
	 * Gets the cliente.
	 * 
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Sets the cliente.
	 * 
	 * @param cliente
	 *            the new cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
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
	 * @param cp4
	 *            the new cp4
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
	 * @param cp3
	 *            the new cp3
	 */
	public void setCp3(String cp3) {
		this.cp3 = cp3;
	}

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
	 * @param cpalf
	 *            the new cpalf
	 */
	public void setCpalf(String cpalf) {
		this.cpalf = cpalf;
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

	// /**
	// * Gets the distrito.
	// *
	// * @return the distrito
	// */
	// public Distrito getDistrito() {
	// return distrito;
	// }
	//
	// /**
	// * Sets the distrito.
	// *
	// * @param distrito
	// * the distrito
	// */
	// public void setDistrito(Distrito distrito) {
	// this.distrito = distrito;
	// }
	//
	// /**
	// * @return the concelho
	// */
	// public Concelho getConcelho() {
	// return concelho;
	// }
	//
	// /**
	// * @param concelho
	// * the concelho to set
	// */
	// public void setConcelho(Concelho concelho) {
	// this.concelho = concelho;
	// }

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
