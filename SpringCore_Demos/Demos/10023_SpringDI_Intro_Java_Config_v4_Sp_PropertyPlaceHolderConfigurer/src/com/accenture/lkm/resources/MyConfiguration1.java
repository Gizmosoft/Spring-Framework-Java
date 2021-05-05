package com.accenture.lkm.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ReaderConfig.class)
@ComponentScan(basePackages="com.accenture.lkm")
public class MyConfiguration1 {
	
}
