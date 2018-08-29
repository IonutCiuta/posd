package com.ionut.ciuta.posd1.service;

import com.ionut.ciuta.posd1.model.File;
import com.ionut.ciuta.posd1.model.Folder;
import com.ionut.ciuta.posd1.model.Resource;
import org.springframework.stereotype.Component;

/**
 * ionutciuta24@gmail.com on 26.10.2017.
 */
@Component
public class ResourceBuilder {
    public Resource build(String name, String content, String permission, int type) {
        switch (type) {
            case Resource.Type.FILE:
                return new File(content, permission, content);

            case Resource.Type.FOLDER:
                return new Folder(content, permission);

            default:
                throw new UnsupportedOperationException();
        }
    }
}