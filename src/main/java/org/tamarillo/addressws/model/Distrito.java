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
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
 * The Class Distrito.
 */
@Entity
@Table(name = "Distrito", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedQueries({ @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d"),
		@NamedQuery(name = "Distrito.findById", query = "SELECT d FROM Distrito d WHERE d.id = :id"),
		@NamedQuery(name = "Distrito.findByName", query = "SELECT d FROM Distrito d WHERE d.name = :name"),
		@NamedQuery(name = "Distrito.findByLikeName", query = "SELECT d FROM Distrito d WHERE d.name LIKE :name") })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Distrito")
public class Distrito implements IEntity, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2685556051200336081L;

	/** The id. */
	@Id
	@Column(name = "id")
	@NotNull
	@Size(min = 2, max = 2)
	// missing regexp
	private String id;

	/** The name. */
	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "name")
	private String name;

	/** The version. */
	@Version
	@NotNull
	@Column(name = "version")
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	private Timestamp version;

	/* ********************************* */
	/* ******** Relationship *********** */
	/* ********************************* */

	/** The concelhos. */
	@OneToMany(mappedBy = "distrito")
	public Set<Concelho> concelhos;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tamarillo.addressws.model.IEntity#getId()
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the id
	 */
	public void setId(String id) {
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
	 * Gets the version.
	 * 
	 * @return the version
	 */
	public Timestamp getVersion() {
		return version;
	}

	/**
	 * Gets the concelhos.
	 * 
	 * @return the concelhos
	 */
	public Set<Concelho> getConcelhos() {
		return concelhos;
	}

	/**
	 * Sets the concelhos.
	 * 
	 * @param concelhos
	 *            the concelhos
	 */
	public void setConcelhos(Set<Concelho> concelhos) {
		this.concelhos = concelhos;
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
		if (!(obj instanceof Distrito)) {
			return false;
		}
		Distrito other = (Distrito) obj;
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
		return "Distrito [id=" + id + "]";
	}

}
