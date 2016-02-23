package net.waryong;

import java.io.InputStream;

/**
 * Created by waryong on 2016. 1. 2..
 */
public interface ArgumentResolver {

    Argument resolve(InputStream inputStream);
}
