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

package org.tamarillo.addressws.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.tamarillo.addressws.model.Member;

// The @Stateful annotation eliminates the need for manual transaction demarcation
/**
 * The Class MemberRegistration.
 */
@Stateful
// The @Model stereotype is a convenience mechanism to make this a
// request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class MemberRegistration implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8497563434945271379L;

	/** The log. */
	@Inject
	private Logger log;

	/** The em. */
	@Inject
	private EntityManager em;

	/** The member event src. */
	@Inject
	private Event<Member> memberEventSrc;

	/** The new member. */
	private Member newMember;

	/**
	 * Gets the new member.
	 * 
	 * @return the new member
	 */
	@Produces
	@Named
	public Member getNewMember() {
		return newMember;
	}

	/**
	 * Register.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void register() throws Exception {
		log.info("Registering " + newMember.getName());
		em.persist(newMember);
		memberEventSrc.fire(newMember);
		initNewMember();
	}

	/**
	 * Inits the new member.
	 */
	@PostConstruct
	public void initNewMember() {
		newMember = new Member();
	}
}
