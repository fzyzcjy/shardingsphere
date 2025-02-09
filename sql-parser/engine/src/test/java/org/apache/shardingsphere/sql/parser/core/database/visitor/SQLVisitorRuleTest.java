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

package org.apache.shardingsphere.sql.parser.core.database.visitor;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.shardingsphere.sql.parser.exception.SQLASTVisitorException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class SQLVisitorRuleTest {
    
    @Test
    public void assertValueOfParseTreeClassSuccess() {
        assertThat(SQLVisitorRule.valueOf(SelectContext.class), is(SQLVisitorRule.SELECT));
    }
    
    @Test
    public void assertValueOfParseTreeClassFailure() {
        assertThrows(SQLASTVisitorException.class, () -> SQLVisitorRule.valueOf(ParseTree.class));
    }
}
