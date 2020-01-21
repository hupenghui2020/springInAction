package com.hph.demo;

public aspect CriticAspect {

    public CriticAspect() {
    }

    private CriticismEngine criticismEngine;


    /*切点定义*/
    pointcut performance() : execution(* perform(..));

    /*afterReturning() : performance(){
        System.out.println(criticismEngine.getCriticism());
    }*/

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
