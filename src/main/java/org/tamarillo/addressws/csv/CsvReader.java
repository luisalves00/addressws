package org.tamarillo.addressws.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringReader;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang3.StringUtils;
import org.jsefa.DeserializationException;
import org.jsefa.Deserializer;
import org.jsefa.csv.CsvIOFactory;
import org.mozilla.universalchardet.UniversalDetector;
import org.slf4j.Logger;
import org.tamarillo.addressws.csv.model.ConcelhoCsv;
import org.tamarillo.addressws.csv.model.DistritoCsv;
import org.tamarillo.addressws.csv.model.TodosCodigosPostaisCsv;
import org.tamarillo.addressws.entity.Arteria;
import org.tamarillo.addressws.entity.ArteriaPK;
import org.tamarillo.addressws.entity.CodigoPostal;
import org.tamarillo.addressws.entity.CodigoPostalPK;
import org.tamarillo.addressws.entity.Concelho;
import org.tamarillo.addressws.entity.ConcelhoPK;
import org.tamarillo.addressws.entity.Distrito;
import org.tamarillo.addressws.entity.Localidade;
import org.tamarillo.addressws.entity.LocalidadePK;
import org.tamarillo.addressws.jpa.exception.PreexistingEntityException;
import org.tamarillo.addressws.service.IAddressService;

// TODO: Auto-generated Javadoc
/**
 * The Class CsvReader.
 */
@Named
@RequestScoped
public class CsvReader implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6574521032990428214L;

	/** The Constant DISTRICT. */
	private static final int DISTRICT = 1;

	/** The Constant COUNTY. */
	private static final int COUNTY = 2;

	/** The Constant ALL_POSTAL_CODE. */
	private static final int ALL_POSTAL_CODE = 3;

	/** The log. */
	@Inject
	private Logger log;

	/** The address service. */
	@Inject
	private IAddressService addressService;

	/**
	 * Gets the input stream encoding.
	 * 
	 * @param is
	 *            the is
	 * @return the input stream encoding
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private String getInputStreamEncoding(InputStream is) throws IOException, RuntimeException {
		byte[] buf = new byte[4096];

		// detect charset (1)
		UniversalDetector detector = new UniversalDetector(null);

		// (2)
		int nread;
		
		// check if the stream supports mark/reset methods
		if (!is.markSupported()) {
			throw new RuntimeException("Mark/Reset not supported!");
		}
		
		while ((nread = is.read(buf)) > 0 && !detector.isDone()) {
			detector.handleData(buf, 0, nread);
		}
		// (3)
		detector.dataEnd();
		// (4)
		String encoding = detector.getDetectedCharset();
		if (encoding != null) {
			log.info("Detected encoding = " + encoding);
		} else {
			log.info("No encoding detected.");
		}
		// (5)
		detector.reset();
		is.reset();
		return encoding;
	}

	/**
	 * Gets the clean input stream.
	 * 
	 * @param is
	 *            the is
	 * @return the clean input stream
	 */
	private InputStream getCleanInputStream(InputStream is) {
		// remove bom if exists
		BOMInputStream bomCleanStream = new BOMInputStream(is);
		return bomCleanStream;
	}

	/**
	 * Handle distrito csv file.
	 * 
	 * @param is
	 *            the is
	 * @throws Exception
	 *             the exception
	 */
	public void handleDistritoCsvFile(InputStream is) throws Exception {
		LineIterator lineItr = IOUtils.lineIterator(getCleanInputStream(is),
				getInputStreamEncoding(is));
		Deserializer deserializer = CsvIOFactory.createFactory(
				DistritoCsv.class).createDeserializer();
		int lineNumber = 1;
		try {
			while (lineItr.hasNext()) {
				log.info("Reading line number '" + lineNumber + "'.");
				String line = lineItr.nextLine();
				StringReader reader = new StringReader(line);
				deserializer.open(reader);
				while (deserializer.hasNext()) {
					DistritoCsv distrito = deserializer.next();
					Distrito d = new Distrito();
					d.setId(distrito.getId().replaceAll("[^\\d]", ""));
					d.setName(distrito.getName());
					try {
						addressService.createDistrito(d);
					} catch (Exception e) {
						// TODO: store info to present in the UI
						// try to edit...
						try {
							addressService.editDistrito(d);
						} catch (Exception e1) {
							// TODO: store info to present in the UI
							log.debug("aqui", e);
						}
					}
				}
				deserializer.close(true);
				lineNumber++;
			}
		} catch (DeserializationException de) {
			log.error("Error reading line number '" + lineNumber + "'.", de);
		} finally {
			LineIterator.closeQuietly(lineItr);
		}
	}

	/**
	 * Handle concelho csv file.
	 * 
	 * @param is
	 *            the is
	 * @throws Exception
	 *             the exception
	 */
	public void handleConcelhoCsvFile(InputStream is) throws Exception {
		LineIterator lineItr = IOUtils.lineIterator(getCleanInputStream(is),
				getInputStreamEncoding(is));
		Deserializer deserializer = CsvIOFactory.createFactory(
				ConcelhoCsv.class).createDeserializer();
		int lineNumber = 1;
		try {
			while (lineItr.hasNext()) {
				log.info("Reading line number '" + lineNumber + "'.");
				String line = lineItr.nextLine();
				StringReader reader = new StringReader(line);
				deserializer.open(reader);
				while (deserializer.hasNext()) {
					ConcelhoCsv concelho = deserializer.next();
					Concelho c = new Concelho();
					ConcelhoPK pk = new ConcelhoPK();
					// FIXME: jsefa is reading '?' that don't exists...
					String cleanDistritoId = concelho.getIdDistrito()
							.replaceAll("[^\\d]", "");
					String cleanConcelhoId = concelho.getIdConcelho()
							.replaceAll("[^\\d]", "");
					pk.setIdDistrito(cleanDistritoId);
					pk.setIdConcelho(cleanConcelhoId);
					c.setId(pk);
					c.setName(StringUtils.trim(concelho.getName()));
					try {
						log.info("Concelho  --->  " + c.toString());
						addressService.createConcelho(c);
					} catch (Exception e) {
						// TODO: store info to present in the UI
						try {
							addressService.editConcelho(c);
						} catch (Exception e1) {
							// TODO: store info to present in the UI
						}
					}
				}
				deserializer.close(true);
				lineNumber++;
			}
		} catch (DeserializationException de) {
			log.error("Error reading line number '" + lineNumber + "'.", de);
		} finally {
			LineIterator.closeQuietly(lineItr);
		}
	}

	/**
	 * Handle todos codigos postais csv file.
	 * 
	 * @param is
	 *            the is
	 * @throws Exception
	 *             the exception
	 */
	public void handleTodosCodigosPostaisCsvFile(InputStream is)
			throws Exception {
		LineIterator lineItr = IOUtils.lineIterator(getCleanInputStream(is),
				getInputStreamEncoding(is));
		Deserializer deserializer = CsvIOFactory.createFactory(
				TodosCodigosPostaisCsv.class).createDeserializer();
		int lineNumber = 1;
		try {
			while (lineItr.hasNext()) {
				log.info("Reading line number '" + lineNumber + "'.");
				String line = lineItr.nextLine();
				StringReader reader = new StringReader(line);
				deserializer.open(reader);
				while (deserializer.hasNext()) {
					TodosCodigosPostaisCsv all = deserializer.next();
					handleCodigoPostal(all);
					// Localidade l = handleLocalidade(all);
					// Arteria a = handleArteria(all);

				}
				deserializer.close(true);
				lineNumber++;
			}
		} catch (DeserializationException de) {
			log.error("Error reading line number '" + lineNumber + "'.", de);
		} finally {
			LineIterator.closeQuietly(lineItr);
		}
	}

	/**
	 * Handle localidade.
	 * 
	 * @param all
	 *            the all
	 * @return the localidade
	 * @throws PreexistingEntityException
	 *             the preexisting entity exception
	 * @throws Exception
	 *             the exception
	 */
	private Localidade handleLocalidade(TodosCodigosPostaisCsv all)
			throws PreexistingEntityException, Exception {
		Localidade l = new Localidade();
		LocalidadePK pk = new LocalidadePK(all.getIdDistrito(),
				all.getIdConcelho(), all.getIdLocalidade());
		l.setId(pk);
		l.setName(all.getLocalidadeName());
		try {
			addressService.createLocalidade(l);
		} catch (Exception e) {
			try {
				addressService.editLocalidade(l);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		}
		return l;
	}

	/**
	 * Handle arteria.
	 * 
	 * @param all
	 *            the all
	 * @return the arteria
	 */
	private Arteria handleArteria(TodosCodigosPostaisCsv all) {
		Arteria a = new Arteria();
		ArteriaPK pk = new ArteriaPK(all.getIdDistrito(), all.getIdConcelho(),
				all.getIdLocalidade(), all.getIdArteria());
		a.setId(pk);
		a.setArteriaName(all.getArteriaName());
		a.setArteriaLocal(all.getArteriaLocal());
		a.setArteriaTitle(all.getArteriaTitle());
		a.setArteriaType(all.getArteriaType());
		a.setCliente(all.getCliente());
		a.setFirstPrep(all.getFirstPrep());
		a.setPorta(all.getPorta());
		a.setSecondPrep(all.getSecondPrep());
		a.setTroco(all.getTroco());
		try {
			addressService.createArteria(a);
		} catch (Exception e) {
			try {
				addressService.editArteria(a);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		}
		return a;
	}

	/**
	 * Handle codigo postal.
	 * 
	 * @param all
	 *            the all
	 * @throws Exception
	 *             the exception
	 */
	private void handleCodigoPostal(TodosCodigosPostaisCsv all)
			throws Exception {

		CodigoPostal cp = new CodigoPostal();
		CodigoPostalPK pk = new CodigoPostalPK(all.getCp4(), all.getCp3());
		cp.setId(pk);
		cp.setCpalf(all.getCpalf());
		// create postal code:
		try {
			addressService.createCodigoPostal(cp);
		} catch (Exception e) {
			log.debug("cp ---> " + cp.toString(), e);
		}
		if (StringUtils.isNotBlank(all.getIdArteria())) {
			Arteria a = handleArteria(all);
			cp.setArteria(a);
		} else if (StringUtils.isNotBlank(all.getIdLocalidade())) {
			Localidade l = handleLocalidade(all);
			cp.setLocalidade(l);
		} else {
			throw new Exception("Neither localidade nor arteria are setted.");
		}
		// update postal code?
	}

	/**
	 * Select file type.
	 * 
	 * @param is
	 *            the inputstream
	 * @return the int type
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public int selectFileType(InputStream is) throws IOException {
		LineIterator lineItr = IOUtils.lineIterator(getCleanInputStream(is),
				getInputStreamEncoding(is));
		String line = lineItr.nextLine();
		Integer d = selectFileTypeHelper(line, TodosCodigosPostaisCsv.class,
				ALL_POSTAL_CODE);
		if (d == null) {
			Integer c = selectFileTypeHelper(line, ConcelhoCsv.class, COUNTY);
			if (c == null) {
				Integer a = selectFileTypeHelper(line, DistritoCsv.class,
						DISTRICT);
				if (a != null) {
					return a;
				}
			} else {
				return c;
			}
		} else {
			return d;
		}
		return 0; // fail
	}

	/**
	 * Select file type helper.
	 * 
	 * @param line
	 *            the line
	 * @param clazz
	 *            the clazz
	 * @param type
	 *            the type
	 * @return the integer
	 */
	private Integer selectFileTypeHelper(String line, Class<?> clazz, int type) {
		Deserializer deserializer = CsvIOFactory.createFactory(clazz)
				.createDeserializer();
		try {
			StringReader reader = new StringReader(line);
			deserializer.open(reader);
			Object obj = deserializer.next();
		} catch (DeserializationException de) {
			return null; // fail to deserialize
		}
		return type;
	}
}
