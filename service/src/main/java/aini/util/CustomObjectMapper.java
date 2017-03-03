package aini.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomObjectMapper()
    {
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 2015.11.11 Array가 1개 배열로 오는 경우 JsonMappingException 오류가 발생함으로 인해 해당 설정을 Array로 받을 수 있도록 변경
        this.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
/*        
 * BaseObject를 상속받은 Vo에서 에러가 남으로 인해 아래와 같이 수정
 * this.setVisibilityChecker(this.getSerializationConfig().getDefaultVisibilityChecker()
            .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
            .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
            .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
            .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));*/
        this.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
        this.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
    }
}
