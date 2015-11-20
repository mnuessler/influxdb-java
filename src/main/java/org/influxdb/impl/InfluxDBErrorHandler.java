package org.influxdb.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

class InfluxDBErrorHandler implements ErrorHandler {
	@Override
	public Throwable handleError(final RetrofitError cause) {
		Response r = cause.getResponse();
		if (r != null && r.getStatus() >= 400) {
			try (InputStreamReader reader = new InputStreamReader(r.getBody().in(), StandardCharsets.UTF_8)) {
				StringBuilder sb = new StringBuilder();
				int ch;
				while ((ch = reader.read()) != -1) {
					sb.append((char) ch);
				}
				return new RuntimeException(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cause;
	}
}
