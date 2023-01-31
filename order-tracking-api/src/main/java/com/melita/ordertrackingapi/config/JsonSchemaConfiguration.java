package com.melita.ordertrackingapi.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
@RequiredArgsConstructor
public class JsonSchemaConfiguration {

    private static final String SCHEMA_LOCATION = "/jsonSchema.json";
    private final ObjectMapper mapper;

    @Bean
    public JsonSchema getJsonSchema() throws IOException {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

        InputStream inputStream = getClass().getResourceAsStream(SCHEMA_LOCATION);
        JsonNode schemaJson = mapper.readTree(inputStream);

        JsonSchema jsonSchema = factory.getSchema(schemaJson);
        jsonSchema.initializeValidators();
        return jsonSchema;
    }
}