package com.darkstar.trading.trademanager.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAsync
@EnableScheduling	
@ComponentScan(basePackages= {"com.darkstar.trading.trademanager"}, 
		excludeFilters= {@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {}
