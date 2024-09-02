package com.aerospike.assignment.configuration;

import com.aerospike.client.Host;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.config.AerospikeDataSettings;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.Collection;
import java.util.Collections;


@Configuration
@EnableAerospikeRepositories(basePackages = {"com.aerospike.assignment.repo"})
@EnableAutoConfiguration
@EnableTransactionManagement
public class AerospikeConfiguration extends AbstractAerospikeDataConfiguration {

    @Value("${aerospike.host}")
    private String host;

    @Value("${aerospike.port}")
    private  int port;

    @Value("${aerospike.namespace}")
    private String namespace;

    @Override
    protected Collection<Host> getHosts() {
        return Collections.singletonList(new Host(host, port));
    }

    @Override
    protected String nameSpace() {
        return namespace;
    }

    @Bean
    public AerospikeDataSettings aerospikeDataSettings() {
        return AerospikeDataSettings.builder()
                .scansEnabled(true)
                .build();
    }
}