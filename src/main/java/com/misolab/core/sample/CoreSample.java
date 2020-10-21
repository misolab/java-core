package com.misolab.core.sample;

import com.misolab.core.util.CoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@Component
public class CoreSample {
    String sample;

    final CoreProperties properties;

    public String getSample() {
        return String.format("[%s] {%s}", properties.getSample(), sample);
    }
}
