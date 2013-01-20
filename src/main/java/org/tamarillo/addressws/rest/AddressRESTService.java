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

package org.tamarillo.addressws.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tamarillo.addressws.model.Concelho;
import org.tamarillo.addressws.model.Distrito;

/**
 * The Class DistritoResourceRESTService.
 */
@Path("/address")
@RequestScoped
public class AddressRESTService implements IAddressService {

	/** The em. */
	@Inject
	private EntityManager em;

	/**
	 * List all distrito.
	 * 
	 * @return the list< distrito>
	 */
	@GET
	@Path("/distritos")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Distrito> listAllDistrito() {
		return em.createNamedQuery("Distrito.findAll", Distrito.class).getResultList();
	}

	/**
	 * Lookup distrito by id.
	 * 
	 * @param id
	 *            the id
	 * @return the distrito
	 */
	@GET
	@Path("/distritos/{id:[a-zA-Z0-9][a-zA-Z0-9]}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Distrito lookupDistritoById(@PathParam("id") long id) {
		return (Distrito) em.find(Distrito.class, id);
	}

	/**
	 * List all concelho.
	 * 
	 * @return the list< distrito>
	 */
	@GET
	@Path("/concelhos")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Concelho> listAllConcelho() {
		return em.createNamedQuery("Concelho.findAll", Concelho.class).getResultList();
	}

	/**
	 * Lookup concelho by id.
	 * 
	 * @param id
	 *            the id
	 * @return the distrito
	 */
	@GET
	@Path("/concelhos/{id:[a-zA-Z0-9][a-zA-Z0-9]}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Concelho lookupConcelhoById(@PathParam("id") long id) {
		return (Concelho) em.find(Concelho.class, id);
	}
}
