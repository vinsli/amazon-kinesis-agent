package com.amazon.kinesis.streaming.agent.processing.processors;

import com.amazon.kinesis.streaming.agent.Constants;
import com.amazon.kinesis.streaming.agent.processing.exceptions.DataConversionException;
import com.amazon.kinesis.streaming.agent.processing.interfaces.IDataConverter;

import java.nio.ByteBuffer;

/**
 * Created by zhongyuan.li on 4/12/16.
 */
public class NewLineTrimDataConverter implements IDataConverter {
    @Override
    public ByteBuffer convert(ByteBuffer data) throws DataConversionException {
        int dataLen = data.remaining();
        byte end = data.get(dataLen - 1);
        if (end == Constants.NEW_LINE)
        {
            //skip new line
            data.limit(data.limit() - 1);
        }
        return data;
    }
}