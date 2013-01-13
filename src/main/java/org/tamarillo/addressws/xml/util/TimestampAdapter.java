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

package org.tamarillo.addressws.xml.util;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * The Class TimestampAdapter.
 * 
 * @see http
 *      ://blog.2partsmagic.com/2009/04/resolving-javasqltimestamp-does-not-have
 *      -a-no-arg-default-constructor/
 */
public class TimestampAdapter extends XmlAdapter<Date, Timestamp> {

	/**
	 * Marshal.
	 * 
	 * @param v
	 *            the v
	 * @return the date
	 */
	public Date marshal(Timestamp v) {
		return new Date(v.getTime());
	}

	/**
	 * Unmarshal.
	 * 
	 * @param v
	 *            the v
	 * @return the timestamp
	 */
	public Timestamp unmarshal(Date v) {
		return new Timestamp(v.getTime());
	}
}
