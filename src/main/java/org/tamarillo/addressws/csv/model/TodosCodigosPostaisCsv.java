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

package org.tamarillo.addressws.csv.model;

import java.io.Serializable;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

/**
 * The Class TodosCodigosPostaisCsv.
 */
@CsvDataType()
public class TodosCodigosPostaisCsv implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8159309854352657548L;
	
	/** The id distrito. */
	@CsvField(pos = 1 , required=true, constraints = "pattern=\\d{2}")
	private String idDistrito;

	/** The id concelho. */
	@CsvField(pos = 2,  required=true, constraints = "pattern=\\d{2}")
	private String idConcelho;
	
	/** The id localidade. */
	@CsvField(pos = 3,  required=true, constraints = "pattern=\\d{3,5}")
	private String idLocalidade;
	
	/** The localidade name. */
	@CsvField(pos = 4, required=true, constraints = "pattern=[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç)(-]*")
	private String localidadeName;
	
	/** The id arteria. */
	@CsvField(pos = 5, constraints = "pattern=\\d{5,10}") 
	private String idArteria;
	
	/** The arteria type. */
	@CsvField(pos = 6)
	private String arteriaType;

	/** The first prep. */
	@CsvField(pos = 7)
	private String firstPrep;

	/** The arteria title. */
	@CsvField(pos = 8)
	private String arteriaTitle;

	/** The second prep. */
	@CsvField(pos = 9)
	private String secondPrep;

	/** The arteria name. */
	@CsvField(pos = 10)
	private String arteriaName;

	/** The arteria local. */
	@CsvField(pos = 11)
	private String arteriaLocal;

	/** The troco. */
	@CsvField(pos = 12)
	private String troco;

	/** The porta. */
	@CsvField(pos = 13)
	private String porta;

	/** The cliente. */
	@CsvField(pos = 14)
	private String cliente;
	
	/** The cp4. */
	@CsvField(pos = 15, required = true, constraints="pattern=\\d{4}")
	private String cp4;

	/** The cp3. */
	@CsvField(pos = 16, required = true, constraints="pattern=\\d{3}")
	private String cp3;
	
	/** The cpalf. */
	@CsvField(pos = 17)
	private String cpalf;

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
	 * @param idDistrito the new id distrito
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
	 * @param idConcelho the new id concelho
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
	 * @param idLocalidade the new id localidade
	 */
	public void setIdLocalidade(String idLocalidade) {
		this.idLocalidade = idLocalidade;
	}

	/**
	 * Gets the localidade name.
	 *
	 * @return the localidade name
	 */
	public String getLocalidadeName() {
		return localidadeName;
	}

	/**
	 * Sets the localidade name.
	 *
	 * @param localidadeName the new localidade name
	 */
	public void setLocalidadeName(String localidadeName) {
		this.localidadeName = localidadeName;
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
	 * @param idArteria the new id arteria
	 */
	public void setIdArteria(String idArteria) {
		this.idArteria = idArteria;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((arteriaType == null) ? 0 : arteriaType.hashCode());
		result = prime * result + ((cp3 == null) ? 0 : cp3.hashCode());
		result = prime * result + ((cp4 == null) ? 0 : cp4.hashCode());
		result = prime * result + ((cpalf == null) ? 0 : cpalf.hashCode());
		result = prime * result
				+ ((idArteria == null) ? 0 : idArteria.hashCode());
		result = prime * result
				+ ((idConcelho == null) ? 0 : idConcelho.hashCode());
		result = prime * result
				+ ((idDistrito == null) ? 0 : idDistrito.hashCode());
		result = prime * result
				+ ((idLocalidade == null) ? 0 : idLocalidade.hashCode());
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
		TodosCodigosPostaisCsv other = (TodosCodigosPostaisCsv) obj;
		if (arteriaType == null) {
			if (other.arteriaType != null)
				return false;
		} else if (!arteriaType.equals(other.arteriaType))
			return false;
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
		if (cpalf == null) {
			if (other.cpalf != null)
				return false;
		} else if (!cpalf.equals(other.cpalf))
			return false;
		if (idArteria == null) {
			if (other.idArteria != null)
				return false;
		} else if (!idArteria.equals(other.idArteria))
			return false;
		if (idConcelho == null) {
			if (other.idConcelho != null)
				return false;
		} else if (!idConcelho.equals(other.idConcelho))
			return false;
		if (idDistrito == null) {
			if (other.idDistrito != null)
				return false;
		} else if (!idDistrito.equals(other.idDistrito))
			return false;
		if (idLocalidade == null) {
			if (other.idLocalidade != null)
				return false;
		} else if (!idLocalidade.equals(other.idLocalidade))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TodosCodigosPostaisCsv [idDistrito=" + idDistrito
				+ ", idConcelho=" + idConcelho + ", idLocalidade="
				+ idLocalidade + ", localidadeName=" + localidadeName
				+ ", idArteria=" + idArteria + ", arteriaType=" + arteriaType
				+ ", firstPrep=" + firstPrep + ", arteriaTitle=" + arteriaTitle
				+ ", secondPrep=" + secondPrep + ", arteriaName=" + arteriaName
				+ ", arteriaLocal=" + arteriaLocal + ", troco=" + troco
				+ ", porta=" + porta + ", cliente=" + cliente + ", cp4=" + cp4
				+ ", cp3=" + cp3 + ", cpalf=" + cpalf + "]";
	}
	
	

}
