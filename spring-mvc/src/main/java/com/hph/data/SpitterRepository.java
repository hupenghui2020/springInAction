package com.hph.data;

import com.hph.model.Spitter;
import com.hph.model.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author hph
 */
public interface SpitterRepository extends JpaRepository<Spitter,Integer> {
}
