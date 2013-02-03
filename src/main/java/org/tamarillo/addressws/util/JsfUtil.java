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

package org.tamarillo.addressws.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.tamarillo.addressws.controller.TechnicalInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class JsfUtil.
 */
public class JsfUtil {

	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(TechnicalInfo.class);

	/**
	 * find a Bean by name.
	 *
	 * @param <T> the generic type
	 * @param beanName the bean name
	 * @return the t
	 */
	public static <T> T findBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}
	
	/**
	 * Create a method expression
	 * 
	 * @param elExpression
	 * @param expectedReturnType
	 * @param expectedParamTypes
	 * @return
	 */
	public static MethodExpression createMethodExpression(String elExpression, Class<?> expectedReturnType, Class<?>[] expectedParamTypes) {
		ExpressionFactory factory = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
		MethodExpression methodsexpression = factory.createMethodExpression(FacesContext.getCurrentInstance().getELContext(), elExpression,
				expectedReturnType, expectedParamTypes);
		return methodsexpression;
	}

	/**
	 * Create a method expression
	 * 
	 * @param elExpression
	 * @param expectedType
	 * @return
	 */
	public static ValueExpression createValueExpression(String elExpression, Class<?> expectedType) {
		ExpressionFactory factory = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
		ValueExpression valueExpression = factory.createValueExpression(FacesContext.getCurrentInstance().getELContext(), elExpression, expectedType);
		return valueExpression;
	}

	/**
	 * Get Faces Message.
	 *
	 * @param ctx the ctx
	 * @param severity the severity
	 * @param msgKey the msg key
	 * @param args the args
	 * @return the faces message
	 */
	public static FacesMessage getFacesMessage(FacesContext ctx, FacesMessage.Severity severity, String msgKey, Object... args) {
		String msg = "";
		try {
			Locale loc = ctx.getViewRoot().getLocale();
			ResourceBundle bundle = ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(), loc);
			msg = bundle.getString(msgKey);
		} catch (MissingResourceException e) {
			logger.info("Missing Message Key.", e);
			return new FacesMessage(severity, "???" + msgKey + "???", "");
		}
		if (args != null) {
			MessageFormat format = new MessageFormat(msg);
			msg = format.format(args);
		}
		return new FacesMessage(severity, msg, "");
	}

	/**
	 * Add Fatal Message.
	 *
	 * @param clientId the client id
	 * @param msgKey the msg key
	 * @param ctx the ctx
	 * @param args the args
	 */
	public static void addFatalMessage(String clientId, String msgKey, FacesContext ctx, Object... args) {
		FacesMessage facesMsg = getFacesMessage(ctx, FacesMessage.SEVERITY_FATAL, msgKey, args);
		ctx.addMessage(clientId, facesMsg);
	}

	/**
	 * Add Error Message.
	 *
	 * @param clientId the client id
	 * @param msgKey the msg key
	 * @param ctx the ctx
	 * @param args the args
	 */
	public static void addErrorMessage(String clientId, String msgKey, FacesContext ctx, Object... args) {
		FacesMessage facesMsg = getFacesMessage(ctx, FacesMessage.SEVERITY_ERROR, msgKey, args);
		ctx.addMessage(clientId, facesMsg);
	}

	/**
	 * Add Warning Message.
	 *
	 * @param clientId the client id
	 * @param msgKey the msg key
	 * @param ctx the ctx
	 * @param args the args
	 */
	public static void addWarnMessage(String clientId, String msgKey, FacesContext ctx, Object... args) {
		FacesMessage facesMsg = getFacesMessage(ctx, FacesMessage.SEVERITY_WARN, msgKey, args);
		ctx.addMessage(clientId, facesMsg);
	}

	/**
	 * Add Success Message.
	 *
	 * @param clientId the client id
	 * @param msgKey the msg key
	 * @param ctx the ctx
	 * @param args the args
	 */
	public static void addSuccessMessage(String clientId, String msgKey, FacesContext ctx, Object... args) {
		FacesMessage facesMsg = getFacesMessage(ctx, FacesMessage.SEVERITY_INFO, msgKey, args);
		ctx.addMessage(clientId, facesMsg);
	}

	/**
	 * Add Fatal Message.
	 *
	 * @param msgKey the msg key
	 * @param ctx the ctx
	 * @param args the args
	 */
	public static void addFatalMessage(String msgKey, FacesContext ctx, Object... args) {
		FacesMessage facesMsg = getFacesMessage(ctx, FacesMessage.SEVERITY_FATAL, msgKey, args);
		ctx.addMessage(null, facesMsg);
	}

	/**
	 * Add Error Message.
	 *
	 * @param msgKey the msg key
	 * @param ctx the ctx
	 * @param args the args
	 */
	public static void addErrorMessage(String msgKey, FacesContext ctx, Object... args) {
		FacesMessage facesMsg = getFacesMessage(ctx, FacesMessage.SEVERITY_ERROR, msgKey, args);
		ctx.addMessage(null, facesMsg);
	}

	/**
	 * Add Warning Message.
	 *
	 * @param msgKey the msg key
	 * @param ctx the ctx
	 * @param args the args
	 */
	public static void addWarnMessage(String msgKey, FacesContext ctx, Object... args) {
		FacesMessage facesMsg = getFacesMessage(ctx, FacesMessage.SEVERITY_WARN, msgKey, args);
		ctx.addMessage(null, facesMsg);
	}

	/**
	 * Add Success Message.
	 *
	 * @param msgKey the msg key
	 * @param ctx the ctx
	 * @param args the args
	 */
	public static void addSuccessMessage(String msgKey, FacesContext ctx, Object... args) {
		FacesMessage facesMsg = getFacesMessage(ctx, FacesMessage.SEVERITY_INFO, msgKey, args);
		ctx.addMessage(null, facesMsg);
	}

	/**
	 * Get Resource Text.
	 *
	 * @param msgKey the msg key
	 * @param ctx the ctx
	 * @param args the args
	 * @return the resource text
	 */
	public static String getResourceText(String msgKey, FacesContext ctx, Object... args) {
		String msg = "";
		try {
			Locale loc = ctx.getViewRoot().getLocale();
			ResourceBundle bundle = ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(), loc);
			msg = bundle.getString(msgKey);
		} catch (MissingResourceException e) {
			logger.info("Missing Message Key.", e);
			return "???" + msgKey + "???";
		}
		if (args != null) {
			MessageFormat format = new MessageFormat(msg);
			msg = format.format(args);
		}
		return msg;
	}

	/**
	 * Gets the resource bundle.
	 *
	 * @param resource the resource
	 * @param key the key
	 * @return the resource bundle
	 */
	public static String getResourceBundle(String resource, String key) {
		ResourceBundle bundle = ResourceBundle.getBundle(resource);
		return bundle.getString(key);
	}
}
