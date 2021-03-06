/*
 * [The "BSD licence"]
 * Copyright (c) 2013-2014 Dandelion
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. Neither the name of Dandelion nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.github.dandelion.datatables.basics;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.dandelion.AbstractDatatablesIT;
import com.github.dandelion.TemplateEngine;
import com.github.dandelion.junit.JettyJUnitRunner;
import com.github.dandelion.junit.JettyJUnitRunner.ServerConfig;
import com.github.dandelion.mock.Mock;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test the basic Features of Dandelion-Datatables.
 * 
 * @author Thibault Duchateau
 */
@RunWith(JettyJUnitRunner.class)
@ServerConfig(templateEngine = TemplateEngine.THYMELEAF, webappBase = AbstractDatatablesIT.DEFAULT_011x_THYMELEAF)
public class FeatureEnablementIT extends AbstractDatatablesIT {

	@Test
	public void should_disable_paging() {
		goToPage("basics/disable_paging");

		assertThat(find("#" + TABLE_ID + "_length")).hasSize(0);

		// If paging is disabled, the entire collection is displayed
		assertThat(getTable().find("tbody").find("tr")).hasSize(Mock.persons.size());
	}
	
	@Test
	public void should_disable_filtering() {
		goToPage("basics/disable_filtering");

		// If paging is disabled, the entire collection is displayed
		assertThat(find("#" + TABLE_ID + "_filter")).hasSize(0);
	}

	@Test
	public void should_disable_info() {
		goToPage("basics/disable_info");

		// If paging is disabled, the entire collection is displayed
		assertThat(find("#" + TABLE_ID + "_info")).hasSize(0);
	}

	@Test
	public void should_disable_sorting() {
		goToPage("basics/disable_sorting");

		// If paging is disabled, the entire collection is displayed
		assertThat(getTable().find("tbody").find(".sorting")).hasSize(0);
		assertThat(getTable().find("tbody").find(".sorting_desc")).hasSize(0);
		assertThat(getTable().find("tbody").find(".sorting_asc")).hasSize(0);
	}
}