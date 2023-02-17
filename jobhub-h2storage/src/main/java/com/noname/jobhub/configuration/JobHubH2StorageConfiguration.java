package com.noname.jobhub.configuration;

import com.noname.jobhub.businessrules.clientapplication.ClientApplicationService;
import com.noname.jobhub.businessrules.clientapplication.ClientApplicationStorage;
import com.noname.jobhub.businessrules.position.PositionService;
import com.noname.jobhub.businessrules.position.PositionStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@ComponentScan({"com.noname.jobhub.h2storage.clientapplication", "com.noname.jobhub.h2storage.position"})
@EnableJdbcRepositories({"com.noname.jobhub.h2storage.clientapplication", "com.noname.jobhub.h2storage.position"})
public class JobHubH2StorageConfiguration {
    @Bean
    ClientApplicationService clientApplicationService(ClientApplicationStorage clientApplicationStorage) {
        return new ClientApplicationService(clientApplicationStorage);
    }

    @Bean
    PositionService positionService(PositionStorage positionStorage) {
        return new PositionService(positionStorage);
    }

}
