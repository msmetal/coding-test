package cote.beamin.test;

import java.util.EnumMap;
import java.util.Map;

// 60분
public class Test2 {
    public String solution(String S) {

        String[] lines = S.split("\\n");
        Map<Ext.Type, Integer> fileSpace = new EnumMap<>(Ext.Type.class);

        for (String line : lines) {
            String extAndSize = getExtAndSizeString(line);
            Ext ext = Ext.find(getExt(extAndSize));
            Ext.Type type = Ext.type(ext);
            int byteSize = getSize(extAndSize);  // todo line으로 오타가 있었음...
            if (fileSpace.containsKey(type)) {
                int sumByte = fileSpace.get(type);
                fileSpace.put(type, sumByte + byteSize);
            } else {
                fileSpace.put(type, byteSize);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Ext.Type type : Ext.Type.values()) {
            if (fileSpace.containsKey(type)) {
                result.append(type.name()).append(" ").append(fileSpace.get(type)).append('b').append('\n');
            } else {
                result.append(type.name()).append(" ").append(0).append('b').append('\n');
            }
        }

        return result.toString();
    }

    public String getExtAndSizeString(String line) {
        String[] fileName = line.split("[.]");
        return fileName[fileName.length - 1];
    }

    public String getExt(String extAndSize) {
        return extAndSize.split(" ")[0];
    }

    public int getSize(String extAndSize) {
        String size = extAndSize.split(" ")[1];
        String toInt = size.replaceAll("[^0-9]","");
        return Integer.parseInt(toInt);
    }
}


enum Ext {
    mp3, aac, flac, jpg, bmp, gif, mp4, avi, mkv, other;

    enum Type {
        music, images, movies, other
    }

    public static Ext find(String ext) {
        try {
            return Ext.valueOf(ext);
        } catch (IllegalArgumentException ex) {
            return Ext.other;
        }
    }

    public static Type type(Ext ext) {
        if (ext == mp3 || ext == aac || ext == flac) {
            return Type.music;
        }
        if (ext == jpg || ext == bmp || ext == gif) {
            return Type.images;
        }
        if (ext == mp4 || ext == avi || ext == mkv) {
            return Type.movies;
        }
        return Type.other;
    }
}