# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.18.1)

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

        IMPORTED )
set_target_properties( # Specifies the target library.
        brotlilib

        # Specifies the parameter you want to define.
        PROPERTIES IMPORTED_LOCATION

        # Provides the path to the library you want to import.
        ../jniLibs/ABI/${ANDROID_ABI}/libbrotlilib.so )

# HEADER FILE DIRECTORIES:
INCLUDE_DIRECTORIES(include/)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.
#add_executable(libbrotli.so)