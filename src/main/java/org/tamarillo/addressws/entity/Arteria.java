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

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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


/**
 * The Class Arteria.
 */
@Entity
@Table(name = "Arteria")
@NamedQueries({ @NamedQuery(name = "Arteria.findAll", query = "SELECT a FROM Arteria a"),
		@NamedQuery(name = "Arteria.findById", query = "SELECT a FROM Arteria a WHERE a.id = :id"),
		@NamedQuery(name = "Arteria.findByName", query = "SELECT a FROM Arteria a WHERE a.arteriaName = :arteriaName"),
		@NamedQuery(name = "Arteria.findByLikeName", query = "SELECT a FROM Arteria a WHERE a.arteriaName LIKE :arteriaName") })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Arteria")
public class Arteria implements IEntity, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8031939063913984014L;

	/** The id. */
	@EmbeddedId
	protected ArteriaPK id;
	
	/** The arteria type. */
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "arteria_type")
	private String arteriaType;

	/** The first prep. */
	@Size(min = 1, max = 8)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "first_prep")
	private String firstPrep;

	/** The arteria title. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "arteria_title")
	private String arteriaTitle;

	/** The second prep. */
	@Size(min = 1, max = 8)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "second_prep")
	private String secondPrep;

	/** The arteria name. */
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "arteria_name")
	private String arteriaName;

	/** The arteria local. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "arteria_local")
	private String arteriaLocal;

	/** The troco. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "troco")
	private String troco;

	/** The porta. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "porta")
	private String porta;

	/** The cliente. */
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	@Column(name = "cliente")
	private String cliente;
	
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

	/** The localidade. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_distrito", insertable = false, updatable = false),
			@JoinColumn(name = "id_concelho", insertable = false, updatable = false),
			@JoinColumn(name = "id_localidade", insertable = false, updatable = false)})
	private Localidade localidade;
	
	 /** The codigo postal. */
    @OneToOne
    @JoinColumns({ @JoinColumn(name = "cp4", insertable = false, updatable = false),
		@JoinColumn(name = "cp3", insertable = false, updatable = false) })
    private CodigoPostal codigoPostal;

	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.model.IEntity#getId()
	 */
	public ArteriaPK getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(ArteriaPK id) {
		this.id = id;
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
	 * @param arteriaType the new arteria type
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
	 * @param firstPrep the new first prep
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
	 * @param arteriaTitle the new arteria title
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
	 * @param secondPrep the new second prep
	 */
	public void setSecondPrep(String secondPrep) {
		this.secondPrep = secondPrep;
	}

	/**
	 * Gets the arteria name.
	 *
	 * @return the arteria name
	 */
	public String getArteriaName() {
		return arteriaName;
	}

	/**
	 * Sets the arteria name.
	 *
	 * @param arteriaName the new arteria name
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
	 * @param arteriaLocal the new arteria local
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
	 * @param troco the new troco
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
	 * @param porta the new porta
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
	 * @param cliente the new cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
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
		Arteria other = (Arteria) obj;
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
		return "Arteria [id=" + id + ", arteriaType=" + arteriaType
				+ ", firstPrep=" + firstPrep + ", arteriaTitle=" + arteriaTitle
				+ ", secondPrep=" + secondPrep + ", arteriaName=" + arteriaName
				+ ", arteriaLocal=" + arteriaLocal + ", troco=" + troco
				+ ", porta=" + porta + ", cliente=" + cliente + ", version="
				+ version + "]";
	}
	
}
