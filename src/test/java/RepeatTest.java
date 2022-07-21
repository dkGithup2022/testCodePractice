import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import tags.MyRepeatTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatTest {

    @MyRepeatTest
    @RepeatedTest(10)
    public void repeat_1(RepetitionInfo repetitionInfo){
        System.out.println(repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions());
    }

    @MyRepeatTest
    @DisplayName("repeat with displayName : ")
    @RepeatedTest(value=10, name = " {displayName} {currentRepetition}/ {totalRepetitions}")
    void repeat_2(RepetitionInfo repetitionInfo){
        System.out.println(repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions());

    }

    @MyRepeatTest
    @DisplayName("테스트마다 문자열 다르게 하기 ")
    @ParameterizedTest(name="{displayName} / {index} : message = {0}")
    @ValueSource(strings = {"안녕","하세요","곤니찌와"})
    void repeat_3(String s){
            System.out.println(s);
    }

    @MyRepeatTest
    @DisplayName("@NullAndEmpty 해보기")
    @ParameterizedTest(name = "{displayName} / {index} : message : {0}")
    @ValueSource(strings = {"hello", "nono"})
    @NullAndEmptySource
    void repeat_4(String s){
        System.out.println(s);
    }

    @MyRepeatTest
    @DisplayName("인자값 타입 변환")
    @ParameterizedTest(name = "{displayName} / {index} : message : {0}")
    @ValueSource(ints={1,2,3,4,5})
    void repeat_5(@ConvertWith(StudyConverter.class) Study study){
        System.out.println(study);
    }

    static class StudyConverter extends SimpleArgumentConverter{
        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            assertEquals(Study.class,aClass, "Study 객체로 바께 못바꿈");
            return new Study(StudyDraft.ACTIVE, Integer.valueOf(o.toString()));
        }
    }

    @MyRepeatTest
    @DisplayName("인자값 타입 변환 2 ")
    @ParameterizedTest(name =  "{displayName} / {index} : num : {0} , name :{1}")
    @CsvSource({"1,'dk'", "2,'jk'","3, 'bn'"})
    void repeat_6(int i, String s){
        System.out.println("i : " + i +" , s : " + s);
    }

    @MyRepeatTest
    @DisplayName("인자값 타입 변환 2 ")
    @ParameterizedTest(name =  "{displayName} / {index} : num : {0} , name :{1}")
    @CsvSource({"1,'dk'", "2,'jk'","3, 'bn'"})
    void repeat_7(@AggregateWith(StudyAggregator.class) Study study){
        System.out.println(study);
    }

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(StudyDraft.ACTIVE,argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }

}
