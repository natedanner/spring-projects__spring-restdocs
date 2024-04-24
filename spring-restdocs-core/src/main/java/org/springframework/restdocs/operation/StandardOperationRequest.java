/*
 * Copyright 2014-2022 the original author or authors.
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

package org.springframework.restdocs.operation;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

/**
 * Standard implementation of {@link OperationRequest}.
 *
 * @author Andy Wilkinson
 */
class StandardOperationRequest extends AbstractOperationMessage implements OperationRequest {

	private final HttpMethod method;

	private final Collection<OperationRequestPart> parts;

	private final URI uri;

	private final Collection<RequestCookie> cookies;

	/**
	 * Creates a new request with the given {@code uri} and {@code method}. The request
	 * will have the given {@code headers}, {@code parameters}, {@code parts}, and
	 * {@code cookies}.
	 * @param uri the uri
	 * @param method the method
	 * @param content the content
	 * @param headers the headers
	 * @param parts the parts
	 * @param cookies the cookies
	 */
	StandardOperationRequest(URI uri, HttpMethod method, byte[] content, HttpHeaders headers,
			Collection<OperationRequestPart> parts, Collection<RequestCookie> cookies) {
		super(content, headers);
		this.uri = uri;
		this.method = method;
		this.parts = parts;
		this.cookies = cookies;
	}

	@Override
	public HttpMethod getMethod() {
		return this.method;
	}

	@Override
	public Collection<OperationRequestPart> getParts() {
		return Collections.unmodifiableCollection(this.parts);
	}

	@Override
	public URI getUri() {
		return this.uri;
	}

	@Override
	public Collection<RequestCookie> getCookies() {
		return this.cookies;
	}

}
