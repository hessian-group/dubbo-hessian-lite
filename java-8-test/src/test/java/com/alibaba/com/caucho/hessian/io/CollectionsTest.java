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
package com.alibaba.com.caucho.hessian.io;

import com.alibaba.com.caucho.hessian.io.base.SerializeTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTest extends SerializeTestBase {
    @Test
    void testRandomAccessToUnmodifiableList() throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> unmodifiableList = Collections.unmodifiableList(list);
        Assertions.assertEquals(unmodifiableList, baseHessian2Serialize(unmodifiableList));
    }

    @Test
    void testLinkedToUnmodifiableList() throws IOException {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> unmodifiableList = Collections.unmodifiableList(list);
        Assertions.assertEquals(unmodifiableList, baseHessian2Serialize(unmodifiableList));
    }

    @Test
    void testRandomAccessToSynchronizedList() throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> unmodifiableList = Collections.synchronizedList(list);
        Assertions.assertEquals(unmodifiableList, baseHessian2Serialize(unmodifiableList));
    }

    @Test
    void testLinkedToSynchronizedList() throws IOException {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> unmodifiableList = Collections.synchronizedList(list);
        Assertions.assertEquals(unmodifiableList, baseHessian2Serialize(unmodifiableList));
    }

}
