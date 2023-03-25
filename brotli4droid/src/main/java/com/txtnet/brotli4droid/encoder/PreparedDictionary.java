/* Copyright 2018 Google Inc. All Rights Reserved.

   Distributed under MIT license.
   See file LICENSE for detail or copy at https://opensource.org/licenses/MIT
*/
package com.txtnet.brotli4droid.encoder;

import com.txtnet.brotli4droid.common.annotations.Upstream;

import java.nio.ByteBuffer;

/**
 * Prepared dictionary data provider.
 */
@Upstream
public interface PreparedDictionary {
    ByteBuffer getData();
}
