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

package com.liferay.user.associated.data.web.internal.portlet.action;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.user.associated.data.anonymizer.UADAnonymizer;
import com.liferay.user.associated.data.constants.UserAssociatedDataPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Noah Sherrill
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + UserAssociatedDataPortletKeys.USER_ASSOCIATED_DATA,
		"mvc.command.name=/auto_anonymize_uad_entity"
	},
	service = MVCActionCommand.class
)
public class AutoAnonymizeUADEntityMVCActionCommand
	extends BaseUADMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		User selectedUser = _portal.getSelectedUser(actionRequest);

		UADAnonymizer uadAnonymizer = getUADAnonymizer(actionRequest);

		uadAnonymizer.autoAnonymize(
			getEntity(actionRequest), selectedUser.getUserId());

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		sendRedirect(actionRequest, actionResponse, redirect);
	}

	@Reference
	private Portal _portal;

}