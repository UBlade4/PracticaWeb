package com.dws.practicaweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/pcs")
public class PcRESTController {

    private Map<Long, Pc> pcs = new ConcurrentHashMap<>();
    private AtomicLong lastId = new AtomicLong();

}
