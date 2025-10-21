/*
 *    Copyright (c) 2020-2023, Aayush Atharva
 *
 *    Brotli4j licenses this file to you under the
 *    Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.txtnet.brotli4droid;

import com.txtnet.brotli4droid.common.annotations.Local;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ServiceLoader;

/**
 * Loads Brotli Native Library
 */
@Local
public class Brotli4jLoader {

    private static final Throwable UNAVAILABILITY_CAUSE;

    static {
        Throwable cause = null;

       // String customPath = System.getProperty("brotli4j.library.path");

       // if (customPath != null) {
            try {
                System.loadLibrary("brotli4droid");
            } catch (Throwable throwable) {
                cause = throwable;
            }

        UNAVAILABILITY_CAUSE = cause;
    }

    /**
     * @return {@code true} if the Brotli native library is available else {@code false}.
     */
    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    /**
     * Ensure Brotli native library is available.
     *
     * @throws UnsatisfiedLinkError If unavailable.
     */
    public static void ensureAvailability() {
        if (UNAVAILABILITY_CAUSE != null) {
            UnsatisfiedLinkError error = new UnsatisfiedLinkError("Failed to load Brotli native library");
            error.initCause(UNAVAILABILITY_CAUSE);
            throw error;
        }
    }

    public static Throwable getUnavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    private static String getPlatform() {
        String osName = System.getProperty("os.name");
        String archName = System.getProperty("os.arch");
        if (osName.equalsIgnoreCase("Linux")) {
            if (archName.equalsIgnoreCase("amd64")) {
                return "linux-x86_64";
            } else if (archName.equalsIgnoreCase("aarch64")) {
                return "linux-aarch64";
            } else if (archName.equalsIgnoreCase("arm")) {
                return "linux-armv7";
            }
        } else if (osName.startsWith("Windows")) {
            if (archName.equalsIgnoreCase("amd64")) {
                return "windows-x86_64";
            }
        } else if (osName.startsWith("Mac")) {
            if (archName.equalsIgnoreCase("x86_64")) {
                return "osx-x86_64";
            } else if (archName.equalsIgnoreCase("aarch64")) {
                return "osx-aarch64";
            }
        }
        throw new UnsupportedOperationException("Unsupported OS and Architecture: " + osName + ", " + archName);
    }
}
