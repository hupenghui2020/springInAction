package com.hph.data;

import com.hph.model.Spitter;
import com.hph.model.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author hph
 */

public interface SpitterRepository extends JpaRepository<Spitter,Integer> {
}
