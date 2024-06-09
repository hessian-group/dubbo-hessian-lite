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
package com.alibaba.com.caucho.hessian.io.socket;

import com.alibaba.com.caucho.hessian.io.AbstractDeserializer;
import com.alibaba.com.caucho.hessian.io.AbstractHessianInput;
import com.alibaba.com.caucho.hessian.io.IOExceptionWrapper;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.concurrent.atomic.LongAdder;

public class InetAddressDeserializer extends AbstractDeserializer {
    public Class<?> getType() {
        return InetAddress.class;
    }

    @Override
    public Object readObject(AbstractHessianInput in,
                             Object[] fields)
            throws IOException {
        try {
            return readObject(in, (String[]) fields);
        } catch (IOException e) {
            throw e;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new IOExceptionWrapper("java.net.InetAddress:" + e, e);
        }
    }

    @Override
    public Object readObject(AbstractHessianInput in,
                             String[] fieldNames)
            throws IOException {
        try {
            Object obj = InetAddress.getByAddress("", new byte[4]);
            for (String fieldName : fieldNames) {
                if ("holder".equals(fieldName)) {
                    obj = in.readObject();
                }
            }

            in.addRef(obj);

            return obj;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOExceptionWrapper("java.net.InetAddress:" + e, e);
        }
    }
}
