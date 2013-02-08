package org.tamarillo.addressws.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.tamarillo.addressws.model.Concelho;
import org.tamarillo.addressws.model.ConcelhoPK;
import org.tamarillo.addressws.model.Distrito;
import org.tamarillo.addressws.service.IAddressService;


/**
 * The Class AddressService.
 */
@Stateful(name="addressService")
@LocalBean
public class AddressService implements IAddressService {

	/** The em. */
	@Inject
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#listAllDistrito()
	 */
	@Override
	public List<Distrito> listAllDistrito() {
		return em.createNamedQuery("Distrito.findAll", Distrito.class)
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#lookupDistritoById(java.lang.String)
	 */
	@Override
	public Distrito lookupDistritoById(String id) {
		return (Distrito) em.find(Distrito.class, id);
	}

	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#listAllConcelho()
	 */
	@Override
	public List<Concelho> listAllConcelho() {
		return em.createNamedQuery("Concelho.findAll", Concelho.class)
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#lookupConcelhoById(java.lang.String, java.lang.String)
	 */
	@Override
	public Concelho lookupConcelhoById(String idDistrito, String idConcelho) {
		ConcelhoPK id = new ConcelhoPK(idDistrito,idConcelho);
		return (Concelho) em.find(Concelho.class, id);
	}

}
