package com.aayushatharva.brotli4j.common;

import java.nio.ByteBuffer;

/**
 * JNI wrapper for brotli common.
 */

public class CommonJNI {
    public static native boolean nativeSetDictionaryData(ByteBuffer data);
}