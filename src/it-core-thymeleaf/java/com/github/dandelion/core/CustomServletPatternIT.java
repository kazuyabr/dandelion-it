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
package com.github.dandelion.core;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.dandelion.AbstractCoreIT;
import com.github.dandelion.TemplateEngine;
import com.github.dandelion.core.config.StandardConfigurationLoader;
import com.github.dandelion.junit.JettyJUnitRunner;
import com.github.dandelion.junit.JettyJUnitRunner.ServerConfig;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JettyJUnitRunner.class)
@ServerConfig(templateEngine = TemplateEngine.THYMELEAF, webappBase = CustomServletPatternIT.WEBAPP_BASE)
public class CustomServletPatternIT extends AbstractCoreIT {

	public static final String WEBAPP_BASE = "src/it-core-thymeleaf/resources/webapp-custom-servlet-pattern";

	@BeforeClass
	public static void setup() {
		String path = new File(WEBAPP_BASE + "/").getAbsolutePath();
		System.setProperty(StandardConfigurationLoader.DANDELION_CONFIGURATION, path);
	}

	@AfterClass
	public static void tearDown() {
		System.clearProperty(StandardConfigurationLoader.DANDELION_CONFIGURATION);
	}

	@Test
	public void should_display_column_headers_from_spring_message_source() {
		goToPage("index");
		assertThat(findFirst("link").getAttribute("href")).contains("/my-custom-pattern/");
		assertThat(findFirst("script").getAttribute("src")).contains("/my-custom-pattern/");
	}
}
