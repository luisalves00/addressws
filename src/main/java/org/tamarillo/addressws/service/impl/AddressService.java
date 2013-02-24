package org.tamarillo.addressws.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.tamarillo.addressws.entity.Arteria;
import org.tamarillo.addressws.entity.CodigoPostal;
import org.tamarillo.addressws.entity.Concelho;
import org.tamarillo.addressws.entity.ConcelhoPK;
import org.tamarillo.addressws.entity.Distrito;
import org.tamarillo.addressws.entity.Localidade;
import org.tamarillo.addressws.entity.LocalidadePK;
import org.tamarillo.addressws.jpa.exception.PreexistingEntityException;
import org.tamarillo.addressws.service.IAddressService;


// TODO: Auto-generated Javadoc
/**
 * The Class AddressService.
 */
@Stateful(name = "addressService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@Model
public class AddressService implements IAddressService {

	/** The em. */
	@Inject
	private EntityManager em;

	/**
	 * Creates the distrito.
	 *
	 * @param d the d
	 * @throws PreexistingEntityException , Exception
	 * @throws Exception the exception
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createDistrito(Distrito d) throws PreexistingEntityException,
			Exception {
		try {
			em.persist(d);
		} catch (Exception ex) {
			if (lookupDistritoById(d.getId()) != null) {
				throw new PreexistingEntityException("Distrito " + d.toString()
						+ " already exists.", ex);
			}
			throw ex;
		}
	}


	/**
	 * Edits the distrito.
	 *
	 * @param d the d
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editDistrito(Distrito d) {
		em.merge(d);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tamarillo.addressws.service.IAddressService#listAllDistrito()
	 */
	@Override
	public List<Distrito> listAllDistrito() {
		return em.createNamedQuery("Distrito.findAll", Distrito.class)
				.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tamarillo.addressws.service.IAddressService#lookupDistritoById(java
	 * .lang.String)
	 */
	@Override
	public Distrito lookupDistritoById(String id) {
		return (Distrito) em.find(Distrito.class, id);
	}

	/**
	 * Creates the concelho.
	 *
	 * @param c the c
	 * @throws PreexistingEntityException the preexisting entity exception
	 * @throws Exception the exception
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createConcelho(Concelho c) throws PreexistingEntityException,
			Exception {
//		try {
			em.persist(c);
//		} catch (Exception ex) {
//			if (c.getId() != null
//					&& lookupConcelhoById(c.getId().getIdDistrito(), c.getId()
//							.getIdConcelho()) != null) {
//				throw new PreexistingEntityException("Concelho " + c.toString()
//						+ " already exists.", ex);
//			}
//			throw ex;
//		}
	}
	
	/**
	 * Edits the concelho.
	 *
	 * @param c the c
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editConcelho(Concelho c){
		em.merge(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tamarillo.addressws.service.IAddressService#listAllConcelho()
	 */
	@Override
	public List<Concelho> listAllConcelho() {
		return em.createNamedQuery("Concelho.findAll", Concelho.class)
				.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tamarillo.addressws.service.IAddressService#lookupConcelhoById(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public Concelho lookupConcelhoById(String idDistrito, String idConcelho) {
		ConcelhoPK id = new ConcelhoPK(idDistrito, idConcelho);
		return (Concelho) em.find(Concelho.class, id);
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#createLocalidade(org.tamarillo.addressws.entity.Localidade)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createLocalidade(Localidade l)
			throws PreexistingEntityException, Exception {
		try {
			em.persist(l);
		} catch (Exception ex) {
			if (l.getId() != null
					&& lookupLocalidadeById(l.getId().getIdDistrito(), l
							.getId().getIdConcelho(), l.getId()
							.getIdLocalidade()) != null) {
				throw new PreexistingEntityException("Localidade "
						+ l.toString() + " already exists.", ex);
			}
			throw ex;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#editLocalidade(org.tamarillo.addressws.entity.Localidade)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editLocalidade(Localidade l){
		em.merge(l);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.tamarillo.addressws.service.IAddressService#listAllLocalidade()
	 */
	@Override
	public List<Localidade> listAllLocalidade() {
		return em.createNamedQuery("Localidade.findAll", Localidade.class)
				.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.tamarillo.addressws.service.IAddressService#lookupConcelhoById(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public Localidade lookupLocalidadeById(String idDistrito,
			String idConcelho, String idLocalidade) {
		LocalidadePK id = new LocalidadePK(idDistrito, idConcelho, idLocalidade);
		return (Localidade) em.find(Localidade.class, id);
	}

	/**
	 * Creates the arteria.
	 *
	 * @param a the a
	 * @throws PreexistingEntityException the preexisting entity exception
	 * @throws Exception the exception
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createArteria(Arteria a) throws PreexistingEntityException, Exception {
		em.persist(a);
	}
	
	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#editArteria(org.tamarillo.addressws.entity.Arteria)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editArteria(Arteria a){
		em.merge(a);
	}

	/**
	 * Creates the codigo postal.
	 * 
	 * @param cp
	 *            the cp
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createCodigoPostal(CodigoPostal cp) {
		em.persist(cp);
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#lookupDistritoByName(java.lang.String)
	 */
	@Override
	public Distrito lookupDistritoByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#lookupConcelhoByName(java.lang.String)
	 */
	@Override
	public Concelho lookupConcelhoByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#lookupLocalidadeByName(java.lang.String)
	 */
	@Override
	public Localidade lookupLocalidadeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#listAllArteria()
	 */
	@Override
	public List<Arteria> listAllArteria() {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#lookupArteriaById(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Arteria lookupArteriaById(String idDistrito, String idConcelho,
			String idLocalidade, String idArteria) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#lookupArteriaByName(java.lang.String)
	 */
	@Override
	public Arteria lookupArteriaByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#listAllCodigosPostais()
	 */
	@Override
	public List<CodigoPostal> listAllCodigosPostais() {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#lookupCodigoPostalById(java.lang.String, java.lang.String)
	 */
	@Override
	public CodigoPostal lookupCodigoPostalById(String cp4, String cp3) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#lookupCodigoPostalByName(java.lang.String)
	 */
	@Override
	public CodigoPostal lookupCodigoPostalByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see org.tamarillo.addressws.service.IAddressService#searchAddressByQuery(java.lang.String)
	 */
	@Override
	public CodigoPostal searchAddressByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
