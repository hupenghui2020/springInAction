package com.hph.service;

import com.hph.model.Spittle;

/**
 * @author hph
 */
public interface AlertService {

    void sendSpittleAlert(final Spittle spittle);
}
