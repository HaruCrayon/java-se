package com.test.enum_;

/**
 * @author LiJing
 * @version 1.0
 * enum 实现接口
 */
public class EnumInterface {
    public static void main(String[] args) {
        Music.CLASSICMUSIC.play();
        Music.POPULARMUSIC.play();
    }
}

interface IPlaying {
    void play();
}

enum Music implements IPlaying {
    CLASSICMUSIC("古典"),
    POPULARMUSIC("流行");

    private String name;

    private Music(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("播放" + name + "音乐...");
    }
}