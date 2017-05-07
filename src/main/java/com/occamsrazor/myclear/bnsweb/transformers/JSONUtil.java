package com.occamsrazor.myclear.bnsweb.transformers;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JSONUtil {
    public static ResponseTransformer json(){
        return new ResponseTransformer() {
            Gson gson = new Gson();

            @Override
            public String render(Object model) throws Exception {
                return this.gson.toJson( model );
            }
        };
    }
}
