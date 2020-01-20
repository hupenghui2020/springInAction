package com.hph.demo;

import com.hph.demo.DefaultEncoreable;
import com.hph.demo.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 使用aop引进其它接口
 * @author hph
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "com.hph.demo.Performance+",
            defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
