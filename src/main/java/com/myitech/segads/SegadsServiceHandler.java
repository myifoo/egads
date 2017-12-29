package com.myitech.segads;

import org.apache.thrift.TException;

import java.util.List;
import java.util.Map;

public class SegadsServiceHandler implements SegadsService.Iface{
    @Override
    public int init() throws TException {
        return 0;
    }

    @Override
    public boolean config(Map<String, String> params) throws TException {
        return false;
    }

    @Override
    public String reset(String name, String value) throws TException {
        return null;
    }

    @Override
    public boolean close(int sid) throws TException {
        return false;
    }

    @Override
    public boolean train(int sid, List<TimeSeries> tseries) throws TException {
        return false;
    }

    @Override
    public boolean update(int sid, List<TimeSeries> tseries) throws TException {
        return false;
    }

    @Override
    public List<TimeSeries> predict(int sid, int len) throws TException {
        return null;
    }

    @Override
    public List<TimeSeries> fetch() throws TException {
        return null;
    }
}
