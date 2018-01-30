package self.aub.product.cgt.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.time.Instant;

@Data
public class RestfulResult {

    private int status;

    private long time;

    private String message;

    private Object data;


    public RestfulResult() {
        this(RestfulStatusEnum.SUCCESS, new JSONObject());
    }

    public RestfulResult(Object data) {
        this(RestfulStatusEnum.SUCCESS, data);
    }

    public RestfulResult(RestfulStatusEnum restfulStatusEnum, String message) {
        this(restfulStatusEnum, message, new JSONObject());
    }

    private RestfulResult(RestfulStatusEnum restfulStatusEnum, Object data) {
        this(restfulStatusEnum, restfulStatusEnum.name(), data);
    }

    private RestfulResult(RestfulStatusEnum restfulStatusEnum, String message, Object data) {
        this.status = restfulStatusEnum.getStatus();
        this.time = Instant.now().toEpochMilli();
        this.message = message;
        this.data = data;
    }
}
