/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.timeservice.type.database;

import org.apache.shardingsphere.infra.util.spi.type.typed.TypedSPILoader;
import org.apache.shardingsphere.test.util.PropertiesBuilder;
import org.apache.shardingsphere.test.util.PropertiesBuilder.Property;
import org.apache.shardingsphere.timeservice.spi.ShardingSphereTimeService;
import org.junit.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class DatabaseTimeServiceTest {
    
    @Test
    public void assertGetDatetime() {
        Properties props = PropertiesBuilder.build(
                new Property("dataSourceClassName", "com.zaxxer.hikari.HikariDataSource"),
                new Property("jdbcUrl", "jdbc:h2:mem:foo_db;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MYSQL"),
                new Property("username", "sa"),
                new Property("password", ""),
                new Property("maximumPoolSize", "1"));
        long currentTime = System.currentTimeMillis();
        assertTrue(TypedSPILoader.getService(ShardingSphereTimeService.class, "Database", props).getDatetime().getTime() >= currentTime);
    }
}
