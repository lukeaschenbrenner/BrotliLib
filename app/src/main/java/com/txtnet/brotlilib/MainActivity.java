package com.txtnet.brotlilib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.txtnet.brotlilib.databinding.ActivityMainBinding;

import java.nio.ByteBuffer;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'brotlilib' library on application startup.
    static {
        System.loadLibrary("brotlilib");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // com_aayushatharva_brotli4j_encoder_EncoderJNI_nativeCreate

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
        //com.aayushatharva.brotli4j.common.CommonJNI.nativeSetDictionaryData(java.nio.ByteBuffer.allocate(1000));
        com.txtnet.brotli4droid
    }

    /**
     * A native method that is implemented by the 'brotlilib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}