package com.dream.team.library.entity.lib.lnk;

import com.dream.team.library.entity.lib.lnk.composite_key.AbstractKey;

import java.io.Serializable;

public interface AbstractLnk extends Serializable {
    AbstractKey getKey();
}
