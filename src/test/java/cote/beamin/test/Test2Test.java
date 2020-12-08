package cote.beamin.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test2Test {

    @Test
    public void solution() {

        String S = "my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b";

        Test2 test2 = new Test2();
        String result =  test2.solution(S);
        System.out.println(result);

    }
}