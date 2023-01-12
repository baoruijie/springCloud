package com.bao.design.d06_adapter;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/12 16:49
 */

public class MediaAdapter implements MediaPlayer{

    AdvanceMediaPlayer player;

    public MediaAdapter(String audioType){
        if("vlc".equals(audioType)){
            player = new VlcPlayer();
        }
        if("mp4".equals(audioType)){
            player = new Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String fileName) {
       if("vlc".equals(audioType)){
           player.playVlc(fileName);
       }
       if("mp4".equals(audioType)){
           player.playMp4(fileName);
       }
    }
}
