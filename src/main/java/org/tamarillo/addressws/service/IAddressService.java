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

package org.tamarillo.addressws.service;

import java.util.List;

import javax.ws.rs.PathParam;

import org.tamarillo.addressws.entity.Arteria;
import org.tamarillo.addressws.entity.CodigoPostal;
import org.tamarillo.addressws.entity.Concelho;
import org.tamarillo.addressws.entity.Distrito;
import org.tamarillo.addressws.entity.Localidade;
import org.tamarillo.addressws.jpa.exception.PreexistingEntityException;



// TODO: Auto-generated Javadoc
/**
 * The Interface IAddressService.
 */
public interface IAddressService {

	/**
	 * List all distrito.
	 *
	 * @return the list
	 */
	public List<Distrito> listAllDistrito();

	/**
	 * Lookup distrito by id.
	 *
	 * @param id the id
	 * @return the distrito
	 */
	public Distrito lookupDistritoById(String id);
	
	/**
	 * Creates the distrito.
	 *
	 * @param d the d
	 * @throws PreexistingEntityException the preexisting entity exception
	 * @throws Exception the exception
	 */
	public void createDistrito(Distrito d) throws PreexistingEntityException,
	Exception ;
	
	/**
	 * Edits the distrito.
	 *
	 * @param d the d
	 */
	public void editDistrito(Distrito d);
	
	/**
	 * List all concelho.
	 *
	 * @return the list
	 */
	public List<Concelho> listAllConcelho();
	
	/**
	 * Lookup concelho by id.
	 *
	 * @param idDistrito the id distrito
	 * @param idConcelho the id concelho
	 * @return the concelho
	 */
	public Concelho lookupConcelhoById(String idDistrito,String idConcelho);
	
	
	/**
	 * Creates the concelho.
	 *
	 * @param c the c
	 * @throws PreexistingEntityException the preexisting entity exception
	 * @throws Exception the exception
	 */
	public void createConcelho(Concelho c) throws PreexistingEntityException,
	Exception;
	
	
	/**
	 * Edits the concelho.
	 *
	 * @param c the c
	 */
	public void editConcelho(Concelho c);
	
	/**
	 * List all localidade.
	 *
	 * @return the list
	 */
	public List<Localidade> listAllLocalidade();
	
	
	/**
	 * Lookup localidade by id.
	 *
	 * @param idDistrito the id distrito
	 * @param idConcelho the id concelho
	 * @param idLocalidade the id localidade
	 * @return the localidade
	 */
	public Localidade lookupLocalidadeById(String idDistrito,String idConcelho, String idLocalidade);
	
	/**
	 * Creates the localidade.
	 *
	 * @param l the l
	 * @throws PreexistingEntityException the preexisting entity exception
	 * @throws Exception the exception
	 */
	public void createLocalidade(Localidade l) throws PreexistingEntityException,
	Exception;
	
	/**
	 * Edits the localidade.
	 *
	 * @param c the c
	 */
	public void editLocalidade(Localidade c);
	

	/**
	 * Creates the arteria.
	 *
	 * @param a the a
	 * @throws PreexistingEntityException the preexisting entity exception
	 * @throws Exception the exception
	 */
	public void createArteria(Arteria a) throws PreexistingEntityException, Exception;
	
	
	/**
	 * Edits the arteria.
	 *
	 * @param a the a
	 */
	public void editArteria(Arteria a);
	
	/**
	 * Creates the codigo postal.
	 *
	 * @param cp the cp
	 * @throws PreexistingEntityException the preexisting entity exception
	 * @throws Exception the exception
	 */
	public void createCodigoPostal(CodigoPostal cp) throws PreexistingEntityException, Exception;

	/**
	 * Lookup distrito by name.
	 *
	 * @param name the name
	 * @return the distrito
	 */
	public List<Distrito> lookupDistritoByName(String name);

	/**
	 * Lookup concelho by name.
	 *
	 * @param name the name
	 * @return the concelho
	 */
	public List<Concelho> lookupConcelhoByName(String name);

	/**
	 * Lookup localidade by name.
	 *
	 * @param name the name
	 * @return the localidade
	 */
	public List<Localidade> lookupLocalidadeByName(String name);

	/**
	 * List all arteria.
	 *
	 * @return the list
	 */
	public List<Arteria> listAllArteria();

	/**
	 * Lookup arteria by id.
	 *
	 * @param idDistrito the id distrito
	 * @param idConcelho the id concelho
	 * @param idLocalidade the id localidade
	 * @param idArteria the id arteria
	 * @return the arteria
	 */
	public Arteria lookupArteriaById(String idDistrito, String idConcelho,
			String idLocalidade, String idArteria);

	/**
	 * Lookup arteria by name.
	 *
	 * @param name the name
	 * @return the arteria
	 */
	public List<Arteria> lookupArteriaByName(String name);

	/**
	 * List all codigos postais.
	 *
	 * @return the list
	 */
	public List<CodigoPostal> listAllCodigosPostais();

	/**
	 * Lookup codigo postal by id.
	 *
	 * @param cp4 the cp4
	 * @param cp3 the cp3
	 * @return the codigo postal
	 */
	public CodigoPostal lookupCodigoPostalById(String cp4, String cp3);

	/**
	 * Lookup codigo postal by name.
	 *
	 * @param name the name
	 * @return the codigo postal
	 */
	public List<CodigoPostal> lookupCodigoPostalByName(String name);

	/**
	 * Search address by query.
	 *
	 * @param query the query
	 * @return the codigo postal
	 */
	public CodigoPostal searchAddressByQuery(String query);
	
}
