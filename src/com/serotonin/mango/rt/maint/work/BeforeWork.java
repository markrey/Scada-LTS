package com.serotonin.mango.rt.maint.work;

public interface BeforeWork {
    void beforeWork();
    void beforeWorkFail(Exception exception);
}
