/*
 * Copyright 2010 Grails Plugin Collective
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugin.rendering

import grails.plugin.spock.IntegrationSpec

import java.util.concurrent.TimeUnit

import spock.util.concurrent.BlockingVariable

class BackgroundRenderingSpec extends IntegrationSpec {

	def backgroundRenderingService

	def "background render"() {
		given:
		def renderError = new BlockingVariable(10, TimeUnit.SECONDS)
		when:
		backgroundRenderingService.fireEvent(renderError)
		then:
		renderError.get() == null
	}
}
