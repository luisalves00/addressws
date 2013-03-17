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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;
import org.tamarillo.addressws.entity.Arteria;
import org.tamarillo.addressws.entity.CodigoPostal;
import org.tamarillo.addressws.entity.Concelho;
import org.tamarillo.addressws.entity.Distrito;
import org.tamarillo.addressws.entity.Localidade;
import org.tamarillo.addressws.service.IAddressService;



/**
 * The Class DistritoResourceRESTService.
 */
@Path("/api")
@RequestScoped
public class AddressRESTService {

	/** The address service. */
	@Inject
	private IAddressService addressService;

	/**
	 * List all distrito.
	 *
	 * @return the list
	 */
	@BadgerFish
	@GET
	@Path("/distritos")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Distrito> listAllDistrito() {
		return addressService.listAllDistrito();
	}


	/**
	 * Lookup distrito by id.
	 *
	 * @param id the id
	 * @return the distrito
	 */
	@BadgerFish
	@GET
	@Path("/distritos/{id:\\d{2}}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Distrito lookupDistritoById(@PathParam("id") String id) {
		return addressService.lookupDistritoById(id);
	}
	
	/**
	 * Lookup distrito by name.
	 *
	 * @param name the name
	 * @return the distrito
	 */
	@BadgerFish
	@GET
	@Path("/distritos/{name:[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç%)(-]*")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Distrito> lookupDistritoByName(@PathParam("name") String name) {
		return addressService.lookupDistritoByName(name);
	}

	/**
	 * List all concelho.
	 *
	 * @return the list
	 */
	@BadgerFish
	@GET
	@Path("/concelhos")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Concelho> listAllConcelho() {
		return addressService.listAllConcelho();
	}


	/**
	 * Lookup concelho by id.
	 *
	 * @param idDistrito the id distrito
	 * @param idConcelho the id concelho
	 * @return the concelho
	 */
	@BadgerFish
	@GET
	@Path("/distritos/{idDistrito:\\d{2}}/{idConcelho:\\d{2}}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Concelho lookupConcelhoById(@PathParam("idDistrito") String idDistrito,@PathParam("idConcelho") String idConcelho) {
		return addressService.lookupConcelhoById(idDistrito, idConcelho);
	}
	
	/**
	 * Lookup concelho by name.
	 *
	 * @param name the name
	 * @return the concelho
	 */
	@BadgerFish
	@GET
	@Path("/concelhos/{name:[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç%)(-]*")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Concelho> lookupConcelhoByName(@PathParam("name") String name) {
		return addressService.lookupConcelhoByName(name);
	}

	/**
	 * List all localidade.
	 *
	 * @return the list
	 */
	@BadgerFish
	@GET
	@Path("/localidades")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Localidade> listAllLocalidade() {
		return addressService.listAllLocalidade();
	}

	/**
	 * Lookup localidade by id.
	 *
	 * @param idDistrito the id distrito
	 * @param idConcelho the id concelho
	 * @param idLocalidade the id localidade
	 * @return the localidade
	 */
	@BadgerFish
	@GET
	@Path("/localidades/{idDistrito:\\d{2}}/{idConcelho:\\d{2}}/{idLocalidade:\\d{3,5}}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Localidade lookupLocalidadeById(@PathParam("idDistrito") String idDistrito,
			@PathParam("idConcelho") String idConcelho,@PathParam("idLocalidade") String idLocalidade) {
		return addressService.lookupLocalidadeById(idDistrito, idConcelho, idLocalidade);
	}
	
	/**
	 * Lookup localidade by name.
	 *
	 * @param name the name
	 * @return the localidade
	 */
	@BadgerFish
	@GET
	@Path("/localidades/{name:[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç%)(-]*")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Localidade> lookupLocalidadeByName(@PathParam("name") String name) {
		return addressService.lookupLocalidadeByName(name);
	}
	
	
	/**
	 * List all arteria.
	 *
	 * @return the list
	 */
	@BadgerFish
	@GET
	@Path("/arterias")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Arteria> listAllArteria() {
		return addressService.listAllArteria();
	}

	/**
	 * Lookup arteria by id.
	 *
	 * @param idDistrito the id distrito
	 * @param idConcelho the id concelho
	 * @param idLocalidade the id localidade
	 * @param idArteria the id arteria
	 * @return the arteria
	 */
	@BadgerFish
	@GET
	@Path("/arterias/{idDistrito:\\d{2}}/{idConcelho:\\d{2}}/{idLocalidade:\\d{3,5}}/{idArteria:\\d{5,10}}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Arteria lookupArteriaById(@PathParam("idDistrito") String idDistrito,
			@PathParam("idConcelho") String idConcelho,@PathParam("idLocalidade") String idLocalidade, @PathParam("idArteria") String idArteria) {
		return addressService.lookupArteriaById(idDistrito, idConcelho, idLocalidade, idArteria);
	}
	
	/**
	 * Lookup arteria by name.
	 *
	 * @param name the name
	 * @return the arteria
	 */
	@BadgerFish
	@GET
	@Path("/arterias/{name:[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç%)(-]*")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Arteria> lookupArteriaByName(@PathParam("name") String name) {
		return addressService.lookupArteriaByName(name);
	}
	
	/**
	 * List all codigos postais.
	 *
	 * @return the list
	 */
	@BadgerFish
	@GET
	@Path("/cp")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<CodigoPostal> listAllCodigosPostais() {
		return addressService.listAllCodigosPostais();
	}

	/**
	 * Lookup codigo postal by id.
	 *
	 * @param cp4 the cp4
	 * @param cp3 the cp3
	 * @return the codigo postal
	 */
	@BadgerFish
	@GET
	@Path("/cp/{cp4:\\d{4}}/{cp3:\\d{3}}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public CodigoPostal lookupCodigoPostalById(@PathParam("cp4") String cp4,
			@PathParam("cp3") String cp3) {
		return addressService.lookupCodigoPostalById(cp4,cp3);
	}
	
	/**
	 * Lookup codigo postal by name.
	 *
	 * @param name the name
	 * @return the codigo postal
	 */
	@BadgerFish
	@GET
	@Path("/cp/{name:[A-Za-z ÁÂÀÃáâàãÊÈÉêèéÍÎÌíîìÓÔÒÕóôòõÚÛÙúûùÇç%)(-]*")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<CodigoPostal> lookupCodigoPostalByName(@PathParam("name") String name) {
		return addressService.lookupCodigoPostalByName(name);
	}
	
	/**
	 * Search address.
	 *
	 * @param query the query
	 * @return the codigo postal
	 */
	@BadgerFish
	@GET
	@Path("/cp/search")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public CodigoPostal searchAddressByQuery(@QueryParam("query") String query) {
		return addressService.searchAddressByQuery(query);
	}
	
}
