/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.asset.display.template.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.display.template.service.AssetDisplayTemplateServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link AssetDisplayTemplateServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.asset.display.template.model.AssetDisplayTemplateSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.asset.display.template.model.AssetDisplayTemplate}, that is translated to a
 * {@link com.liferay.asset.display.template.model.AssetDisplayTemplateSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetDisplayTemplateServiceHttp
 * @see com.liferay.asset.display.template.model.AssetDisplayTemplateSoap
 * @see AssetDisplayTemplateServiceUtil
 * @generated
 */
@ProviderType
public class AssetDisplayTemplateServiceSoap {
	public static com.liferay.asset.display.template.model.AssetDisplayTemplateSoap addAssetDisplayTemplate(
		long groupId, long userId, String name, long classNameId,
		String language, String scriptContent, boolean main,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.asset.display.template.model.AssetDisplayTemplate returnValue =
				AssetDisplayTemplateServiceUtil.addAssetDisplayTemplate(groupId,
					userId, name, classNameId, language, scriptContent, main,
					serviceContext);

			return com.liferay.asset.display.template.model.AssetDisplayTemplateSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.asset.display.template.model.AssetDisplayTemplateSoap deleteAssetDisplayTemplate(
		long assetDisplayTemplateId) throws RemoteException {
		try {
			com.liferay.asset.display.template.model.AssetDisplayTemplate returnValue =
				AssetDisplayTemplateServiceUtil.deleteAssetDisplayTemplate(assetDisplayTemplateId);

			return com.liferay.asset.display.template.model.AssetDisplayTemplateSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.asset.display.template.model.AssetDisplayTemplateSoap updateAssetDisplayTemplate(
		long assetDisplayTemplateId, String name, long classNameId,
		String language, String scriptContent, boolean main,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.asset.display.template.model.AssetDisplayTemplate returnValue =
				AssetDisplayTemplateServiceUtil.updateAssetDisplayTemplate(assetDisplayTemplateId,
					name, classNameId, language, scriptContent, main,
					serviceContext);

			return com.liferay.asset.display.template.model.AssetDisplayTemplateSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AssetDisplayTemplateServiceSoap.class);
}