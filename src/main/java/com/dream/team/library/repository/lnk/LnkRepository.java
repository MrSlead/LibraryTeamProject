package com.dream.team.library.repository.lnk;

import com.dream.team.library.entity.lib.lnk.composite_key.AbstractKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LnkRepository<LNK> extends JpaRepository<LNK, AbstractKey> {
}
