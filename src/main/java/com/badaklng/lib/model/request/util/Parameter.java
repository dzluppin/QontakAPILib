package com.badaklng.lib.model.request.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Parameter {
    private List<TemplateParameter> body;

    public Parameter(TemplateParameter[] params) {
        this.body = Arrays.asList(params);
    }

    public Parameter(List<TemplateParameter> body) {
        this.body = body;
    }

    public static class Builder {
        private final List<TemplateParameter> tps = new ArrayList<>();

        public Builder addParameter(TemplateParameter tp) {
            tps.add(tp);
            return this;
        }

        public Builder addParameter(String key, String value, String value_text) {
            tps.add(new TemplateParameter(key, value, value_text));
            return this;
        }

        public Parameter build() {
            return new Parameter(tps);
        }
    }
}
