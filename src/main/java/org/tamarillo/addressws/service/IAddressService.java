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

import org.tamarillo.addressws.model.Concelho;
import org.tamarillo.addressws.model.Distrito;

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
}
