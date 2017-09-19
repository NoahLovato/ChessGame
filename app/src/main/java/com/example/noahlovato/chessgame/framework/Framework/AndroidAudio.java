package com.example.noahlovato.chessgame.framework.Framework;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.noahlovato.chessgame.framework.Interfaces.Audio;
import com.example.noahlovato.chessgame.framework.Interfaces.Music;
import com.example.noahlovato.chessgame.framework.Interfaces.Sound;

import java.io.IOException;

/**
 * Created by noah.lovato on 7/28/2017.
 */

public class AndroidAudio implements Audio {

    AssetManager assets;
    SoundPool.Builder soundBuilder = new SoundPool.Builder();
    SoundPool soundPool;

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = soundBuilder.build();
    }

    @Override
    public Music newMusic(String fileName) {

        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(fileName);
            return new AndroidMusic(assetDescriptor);
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't load music '" + fileName + "'");
        }

    }

    @Override
    public Sound newSound(String fileName) {

        try {
            AssetFileDescriptor assetFileDescriptor = assets.openFd(fileName);
            int soundId = soundPool.load(assetFileDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        }
        catch (IOException e) {
            throw new RuntimeException(("Couldn't load sound '" + fileName + "'"));
        }

    }

}
