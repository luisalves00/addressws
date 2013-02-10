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
package org.tamarillo.addressws.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.tamarillo.addressws.entity.Member;

/**
 * The Class MemberListProducer.
 */
@RequestScoped
public class MemberListProducer {

	/** The em. */
	@Inject
	private EntityManager em;

	/** The members. */
	private List<Member> members;

	// @Named provides access the return value via the EL variable name
	// "members" in the UI (e.g.,
	// Facelets or JSP view)
	/**
	 * Gets the members.
	 * 
	 * @return the members
	 */
	@Produces
	@Named
	public List<Member> getMembers() {
		return members;
	}

	/**
	 * On member list changed.
	 * 
	 * @param member
	 *            the member
	 */
	public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Member member) {
		retrieveAllMembersOrderedByName();
	}

	/**
	 * Retrieve all members ordered by name.
	 */
	@PostConstruct
	public void retrieveAllMembersOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
		Root<Member> member = criteria.from(Member.class);
		// Swap criteria statements if you would like to try out type-safe
		// criteria queries, a new
		// feature in JPA 2.0
		// criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		criteria.select(member).orderBy(cb.asc(member.get("name")));
		members = em.createQuery(criteria).getResultList();
	}
}
