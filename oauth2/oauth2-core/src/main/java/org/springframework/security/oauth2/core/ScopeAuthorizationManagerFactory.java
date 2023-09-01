/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.oauth2.core;

import java.util.Arrays;

import org.springframework.security.authorization.AuthorityAuthorizationManager;

/**
 * @author Mario Petrovski
 */
public class ScopeAuthorizationManagerFactory {

	private ScopeAuthorizationManagerFactory() {
	}

	public static <T> AuthorityAuthorizationManager<T> hasScope(String scope) {
		return AuthorityAuthorizationManager.hasAuthority("SCOPE_" + scope);
	}

	public static <T> AuthorityAuthorizationManager<T> hasAnyScope(String... scopes) {
		String[] mappedScopes = Arrays.stream(scopes).map(s -> {
			return "SCOPE_" + s;
		}).toArray(String[]::new);
		return AuthorityAuthorizationManager.hasAnyAuthority(mappedScopes);
	}
}