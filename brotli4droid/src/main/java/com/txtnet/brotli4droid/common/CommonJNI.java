/* Copyright 2017 Google Inc. All Rights Reserved.

   Distributed under MIT license.
   See file LICENSE for detail or copy at https://opensource.org/licenses/MIT
*/
package com.txtnet.brotli4droid.common;

import com.txtnet.brotli4droid.common.annotations.Upstream;

import java.nio.ByteBuffer;

/**
 * JNI wrapper for brotli common.
 */
@Upstream
class CommonJNI {
    static native boolean nativeSetDictionaryData(ByteBuffer data);
}
