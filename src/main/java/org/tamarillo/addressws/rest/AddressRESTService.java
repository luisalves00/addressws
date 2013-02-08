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

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;
import org.tamarillo.addressws.model.Concelho;
import org.tamarillo.addressws.model.ConcelhoPK;
import org.tamarillo.addressws.model.Distrito;
import org.tamarillo.addressws.service.IAddressService;
import org.tamarillo.addressws.service.impl.AddressService;


/**
 * The Class DistritoResourceRESTService.
 */
@Path("/address")
@RequestScoped
public class AddressRESTService implements IAddressService {

	@Inject
	private AddressService addressService;


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.rest.IAddressService#listAllDistrito()
	 */
	@BadgerFish
	@GET
	@Path("/distritos")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Distrito> listAllDistrito() {
		return addressService.listAllDistrito();
	}

	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.rest.IAddressService#lookupDistritoById(java.lang.String)
	 */
	@BadgerFish
	@GET
	@Path("/distritos/{id:[a-zA-Z0-9][a-zA-Z0-9]}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Distrito lookupDistritoById(@PathParam("id") String id) {
		return addressService.lookupDistritoById(id);
	}

	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.rest.IAddressService#listAllConcelho()
	 */
	@BadgerFish
	@GET
	@Path("/concelhos")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Concelho> listAllConcelho() {
		return addressService.listAllConcelho();
	}


	
	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.rest.IAddressService#lookupConcelhoById(java.lang.String, java.lang.String)
	 */
	@BadgerFish
	@GET
	@Path("/distritos/{iddistrito:[a-zA-Z0-9][a-zA-Z0-9]}/{idconcelho:[a-zA-Z0-9][a-zA-Z0-9]}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Concelho lookupConcelhoById(@PathParam("idDistrito") String idDistrito,@PathParam("idConcelho") String idConcelho) {
		return addressService.lookupConcelhoById(idDistrito, idConcelho);
	}
	
	
}
