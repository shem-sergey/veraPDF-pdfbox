/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pdfbox.util;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Exposes PDFBox version.
 */
public class Version
{
    private static final String PDFBOX_VERSION_PROPERTIES =
            "org/apache/pdfbox/resources/pdfbox.properties";

    private Version()
    {
        // static helper
    }

    /**
     * Returns the version of PDFBox.
     */
    public static String getVersion()
    {
        try
        {
            URL url = Version.class.getClassLoader().getResource(PDFBOX_VERSION_PROPERTIES);
            if (url == null)
            {
                return null;
            }
            Properties properties = new Properties();
            properties.load(url.openStream());
            return properties.getProperty("pdfbox.version", null);
        }
        catch (IOException io)
        {
            return null;
        }
    }
}