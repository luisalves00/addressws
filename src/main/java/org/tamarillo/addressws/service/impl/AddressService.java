package org.tamarillo.addressws.service.impl;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.tamarillo.addressws.model.Concelho;
import org.tamarillo.addressws.model.ConcelhoPK;
import org.tamarillo.addressws.model.Distrito;
import org.tamarillo.addressws.service.IAddressService;

@Stateful(name="addressService")
public class AddressService implements IAddressService {

	/** The em. */
	@Inject
	private EntityManager em;
	
	@Override
	public List<Distrito> listAllDistrito() {
		return em.createNamedQuery("Distrito.findAll", Distrito.class)
				.getResultList();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Distrito lookupDistritoById(String id) {
		return (Distrito) em.find(Distrito.class, id);
	}

	@Override
	public List<Concelho> listAllConcelho() {
		return em.createNamedQuery("Concelho.findAll", Concelho.class)
				.getResultList();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Concelho lookupConcelhoById(String idDistrito, String idConcelho) {
		ConcelhoPK id = new ConcelhoPK(idDistrito,idConcelho);
		return (Concelho) em.find(Concelho.class, id);
	}

}
