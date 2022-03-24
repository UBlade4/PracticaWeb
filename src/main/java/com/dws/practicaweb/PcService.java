package com.dws.practicaweb;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PcService {
    private Map<Long, Pc> pcs = new ConcurrentHashMap<>();
    private AtomicLong lastid=new AtomicLong();

    public void addPc(Pc pc){
        long pcId=lastid.incrementAndGet();
        pc.setPcId(pcId);
        pcs.put(pcId, pc);
    }

    public Collection<Pc> getPcs(){
        return pcs.values();
    }

    public Pc getPc(long pcId){
        return pcs.get(pcId);
    }

    public void deletePc(long pcId){
        pcs.remove(pcId);
    }

    public void updatePc(long pcId, Pc pcMod) {
        pcMod.setPcId(pcId);
        pcs.put(pcId, pcMod);
    }

}
