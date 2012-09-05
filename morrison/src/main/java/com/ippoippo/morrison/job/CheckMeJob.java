package com.ippoippo.morrison.job;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.ippoippo.morrison.util.StringUtils;

public class CheckMeJob {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${healthcheck.url}")
	private String healthcheckUrl;

	public void execute() {

		try {
			URL url = new URL(healthcheckUrl);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.setConnectTimeout(3000);
			http.setReadTimeout(3000);

			http.connect();

			InputStream is = http.getInputStream();
			if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
				String body = new String(StringUtils.toBytes(is), "UTF-8");
				if (body.contains("error")) {
					throw new InvalidResponseException("application not alive");
				}
			} else {
					throw new InvalidResponseException("application not alive: response code: " + http.getResponseCode());
			}

			http.disconnect();

		} catch (InvalidResponseException e) {
			logger.error(e.getMessage());

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private class InvalidResponseException extends Exception {

		private static final long serialVersionUID = 8576991639044192464L;

		public InvalidResponseException(String message) {
			super(message);
		}
	}
}
