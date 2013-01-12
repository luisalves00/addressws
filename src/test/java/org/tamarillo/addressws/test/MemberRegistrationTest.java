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

package org.tamarillo.addressws.test;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.tamarillo.addressws.controller.MemberRegistration;
import org.tamarillo.addressws.model.Member;
import org.tamarillo.addressws.util.Resources;

/**
 * The Class MemberRegistrationTest.
 */
@RunWith(Arquillian.class)
public class MemberRegistrationTest {

	/**
	 * Creates the test archive.
	 * 
	 * @return the archive<?>
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addClasses(Member.class, MemberRegistration.class, Resources.class)
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	/** The member registration. */
	@Inject
	MemberRegistration memberRegistration;

	/** The log. */
	@Inject
	Logger log;

	/**
	 * Test register.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testRegister() throws Exception {
		Member newMember = memberRegistration.getNewMember();
		newMember.setName("Jane Doe");
		newMember.setEmail("jane@mailinator.com");
		newMember.setPhoneNumber("2125551234");
		memberRegistration.register();
		assertNotNull(newMember.getId());
		log.info(newMember.getName() + " was persisted with id " + newMember.getId());
	}

}
