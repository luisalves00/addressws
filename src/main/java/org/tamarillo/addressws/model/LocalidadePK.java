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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * The Class LocalidadePK.
 */
public class LocalidadePK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4653139578894063964L;

	/** The id distrito. */
	@Column(name = "id_distrito")
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9][a-zA-Z0-9]", message = "must contain only 2 letters and/or numbers")
	private String idDistrito;

	/** The id concelho. */
	@NotNull
	@Column(name = "id_concelho")
	@Pattern(regexp = "[a-zA-Z0-9][a-zA-Z0-9]", message = "must contain only 2 letters and/or numbers")
	private String idConcelho;

	/** The id localidade. */
	@NotNull
	@Column(name = "id_localidade")
	@Pattern(regexp = "[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]", message = "must contain only 4 letters and/or numbers")
	private String idLocalidade;

	/** The id arteria. */
	@NotNull
	@Column(name = "id_arteria")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "must contain only letters and numbers")
	private String idArteria;

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
	 *            the new id distrito
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
	 *            the new id concelho
	 */
	public void setIdConcelho(String idConcelho) {
		this.idConcelho = idConcelho;
	}

	/**
	 * Gets the id localidade.
	 * 
	 * @return the id localidade
	 */
	public String getIdLocalidade() {
		return idLocalidade;
	}

	/**
	 * Sets the id localidade.
	 * 
	 * @param idLocalidade
	 *            the new id localidade
	 */
	public void setIdLocalidade(String idLocalidade) {
		this.idLocalidade = idLocalidade;
	}

	/**
	 * Gets the id arteria.
	 * 
	 * @return the id arteria
	 */
	public String getIdArteria() {
		return idArteria;
	}

	/**
	 * Sets the id arteria.
	 * 
	 * @param idArteria
	 *            the new id arteria
	 */
	public void setIdArteria(String idArteria) {
		this.idArteria = idArteria;
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
		result = prime * result + ((idArteria == null) ? 0 : idArteria.hashCode());
		result = prime * result + ((idConcelho == null) ? 0 : idConcelho.hashCode());
		result = prime * result + ((idDistrito == null) ? 0 : idDistrito.hashCode());
		result = prime * result + ((idLocalidade == null) ? 0 : idLocalidade.hashCode());
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
		if (!(obj instanceof LocalidadePK)) {
			return false;
		}
		LocalidadePK other = (LocalidadePK) obj;
		if (idArteria == null) {
			if (other.idArteria != null) {
				return false;
			}
		} else if (!idArteria.equals(other.idArteria)) {
			return false;
		}
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
		if (idLocalidade == null) {
			if (other.idLocalidade != null) {
				return false;
			}
		} else if (!idLocalidade.equals(other.idLocalidade)) {
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
		return "LocalidadePK [idDistrito=" + idDistrito + ", idConcelho=" + idConcelho + ", idLocalidade=" + idLocalidade + ", idArteria="
				+ idArteria + "]";
	}

}
