package com.hph.data;

import com.hph.model.Spittle;
import com.hph.model.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author hph
 */
public interface SpittleRepository extends JpaRepository<Spittle, Integer> {
}
