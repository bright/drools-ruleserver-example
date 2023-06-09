package com.example.ruleserver;

import static com.jsoniter.output.JsonStream.*;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    @Override
    public String render(Object model) {
        return serialize(model);
    }

}