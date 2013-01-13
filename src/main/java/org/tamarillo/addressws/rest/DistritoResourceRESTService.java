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

import org.tamarillo.addressws.model.Distrito;

/**
 * The Class DistritoResourceRESTService.
 */
@Path("/distrito")
@RequestScoped
public class DistritoResourceRESTService {

	/** The em. */
	@Inject
	private EntityManager em;

	/**
	 * List all distrito xml.
	 * 
	 * @return the list< distrito>
	 */
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Distrito> listAllDistritoXml() {
		return listAllDistrito();
	}

	/**
	 * List all distrito xml.
	 * 
	 * @return the list< distrito>
	 */
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Distrito> listAllDistritoJson() {
		return listAllDistrito();
	}

	/**
	 * List all distrito.
	 * 
	 * @return the list< distrito>
	 */
	private List<Distrito> listAllDistrito() {
		return em.createNamedQuery("Distrito.findAll", Distrito.class).getResultList();
	}

	/**
	 * Lookup member by id xml.
	 * 
	 * @param id
	 *            the id
	 * @return the distrito
	 */
	@GET
	@Path("/xml/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_XML)
	public Distrito lookupMemberByIdXml(@PathParam("id") long id) {
		return lookupMemberById(id);
	}

	/**
	 * Lookup member by id json.
	 * 
	 * @param id
	 *            the id
	 * @return the distrito
	 */
	@GET
	@Path("/json/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Distrito lookupMemberByIdJson(@PathParam("id") long id) {
		return lookupMemberById(id);
	}

	/**
	 * Lookup member by id.
	 * 
	 * @param id
	 *            the id
	 * @return the distrito
	 */
	private Distrito lookupMemberById(@PathParam("id") long id) {
		return (Distrito) em.find(Distrito.class, id);
	}
}
