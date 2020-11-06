package com.legnaYet.io;

import java.io.InputStream;

/**
 * @author legna_yet
 * @date 2020-11-06 15:55
 */
public class Resources {
    /**
     * 根据配置文件路径，将配置文件加载成字节输入流，再存储在内存中
     * @param path
     * @return
     */
    public static InputStream getResourcesAsStream(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
