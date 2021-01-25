package com.marketav;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(value = {"com.marketav"})
public class JdbcApplicationTest {
}
