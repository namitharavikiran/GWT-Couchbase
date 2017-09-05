package edu.examples.server.json;

import static com.couchbase.client.deps.com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonParseException;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.core.type.TypeReference;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonMappingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.SerializationFeature;

import edu.examples.client.model.Customer;
import edu.examples.server.exception.ConversionException;


public class JacksonConverter implements JsonConverter {
	private final ObjectMapper mapper = 
		new ObjectMapper()
			.configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
			.setSerializationInclusion(Include.NON_NULL)
			.enable(SerializationFeature.INDENT_OUTPUT)
			.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));

	public Customer fromJson(String source, Customer valueType) {
		// instance a json mapper
		// generate json
		//byte[] json = mapper.writeValueAsBytes(valueType);
		return null;
	}

	public String toJson(Customer source) {
		try {
			return mapper.writeValueAsString(source);
		} catch (JsonProcessingException e) {
			throw new ConversionException(e);
		}
	}

}