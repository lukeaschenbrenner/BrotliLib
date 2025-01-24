# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.22.1)

# Declares and names the project.
project("brotli4droid")

#include_directories(src/main/cpp/)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        brotlilib

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        native-lib.cpp
        brotli/common/constants.c
        brotli/common/context.c
        brotli/common/dictionary.c
        brotli/common/platform.c
        brotli/common/shared_dictionary.c
        brotli/common/transform.c
        brotli/dec/bit_reader.c
        brotli/dec/decode.c
        brotli/dec/huffman.c
        brotli/dec/state.c
        brotli/enc/backward_references.c
        brotli/enc/backward_references_hq.c
        brotli/enc/bit_cost.c
        brotli/enc/block_splitter.c
        brotli/enc/brotli_bit_stream.c
        brotli/enc/cluster.c
        brotli/enc/command.c
        brotli/enc/compound_dictionary.c
        brotli/enc/compress_fragment.c
        brotli/enc/compress_fragment_two_pass.c
        brotli/enc/dictionary_hash.c
        brotli/enc/encode.c
        brotli/enc/encoder_dict.c
        brotli/enc/entropy_encode.c
        brotli/enc/fast_log.c
        brotli/enc/histogram.c
        brotli/enc/literal_cost.c
        brotli/enc/memory.c
        brotli/enc/metablock.c
        brotli/enc/static_dict.c
        brotli/enc/utf8_util.c
        brotli/tools/brotli.c
        common_jni.cc
        decoder_jni.cc
        encoder_jni.cc)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        brotlilib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})


#add_library( # Sets the name of the library.
#        brotlilib
#
#        # Sets the library as a shared library.
#        SHARED
#
#        IMPORTED )
#set_target_properties( # Specifies the target library.
#        brotlilib
#
#        # Specifies the parameter you want to define.
#        PROPERTIES IMPORTED_LOCATION
#
#        # Provides the path to the library you want to import.
#        ../jniLibs/ABI/${ANDROID_ABI}/libbrotlilib.so )

# HEADER FILE DIRECTORIES:
INCLUDE_DIRECTORIES(include/)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.
#add_executable(libbrotli.so)