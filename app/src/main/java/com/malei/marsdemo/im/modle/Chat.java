package com.malei.marsdemo.im.modle;

/**
 * Created by malei on 2018/4/17.
 */
@SuppressWarnings("hiding")
public interface Chat {
    public static final class SendMessageRequest extends
            com.google.protobuf.nano.MessageNano {

        private static volatile SendMessageRequest[] _emptyArray;
        public static SendMessageRequest[] emptyArray() {
            // Lazily initializes the empty array
            if (_emptyArray == null) {
                synchronized (
                        com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SendMessageRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        // required string access_token = 1;
        public java.lang.String accessToken;

        // required string from = 2;
        public java.lang.String from;

        // required string to = 3;
        public java.lang.String to;

        // required string text = 4;
        public java.lang.String text;

        // required string topic = 5;
        public java.lang.String topic;

        public SendMessageRequest() {
            clear();
        }

        public SendMessageRequest clear() {
            accessToken = "";
            from = "";
            to = "";
            text = "";
            topic = "";
            cachedSize = -1;
            return this;
        }

        @Override
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
                throws java.io.IOException {
            output.writeString(1, this.accessToken);
            output.writeString(2, this.from);
            output.writeString(3, this.to);
            output.writeString(4, this.text);
            output.writeString(5, this.topic);
            super.writeTo(output);
        }

        @Override
        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(1, this.accessToken);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(2, this.from);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(3, this.to);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(4, this.text);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(5, this.topic);
            return size;
        }

        @Override
        public SendMessageRequest mergeFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    default: {
                        if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
                            return this;
                        }
                        break;
                    }
                    case 10: {
                        this.accessToken = input.readString();
                        break;
                    }
                    case 18: {
                        this.from = input.readString();
                        break;
                    }
                    case 26: {
                        this.to = input.readString();
                        break;
                    }
                    case 34: {
                        this.text = input.readString();
                        break;
                    }
                    case 42: {
                        this.topic = input.readString();
                        break;
                    }
                }
            }
        }

        public static SendMessageRequest parseFrom(byte[] data)
                throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return com.google.protobuf.nano.MessageNano.mergeFrom(new SendMessageRequest(), data);
        }

        public static SendMessageRequest parseFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            return new SendMessageRequest().mergeFrom(input);
        }
    }

    public static final class SendMessageResponse extends
            com.google.protobuf.nano.MessageNano {

        // enum Error
        public static final int ERR_OK = 0;
        public static final int ERR_SYS = -1;

        private static volatile SendMessageResponse[] _emptyArray;
        public static SendMessageResponse[] emptyArray() {
            // Lazily initializes the empty array
            if (_emptyArray == null) {
                synchronized (
                        com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SendMessageResponse[0];
                    }
                }
            }
            return _emptyArray;
        }

        // required int32 err_code = 1;
        public int errCode;

        // required string err_msg = 2;
        public java.lang.String errMsg;

        // required string from = 3;
        public java.lang.String from;

        // required string text = 4;
        public java.lang.String text;

        // required string topic = 5;
        public java.lang.String topic;

        public SendMessageResponse() {
            clear();
        }

        public SendMessageResponse clear() {
            errCode = 0;
            errMsg = "";
            from = "";
            text = "";
            topic = "";
            cachedSize = -1;
            return this;
        }

        @Override
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
                throws java.io.IOException {
            output.writeInt32(1, this.errCode);
            output.writeString(2, this.errMsg);
            output.writeString(3, this.from);
            output.writeString(4, this.text);
            output.writeString(5, this.topic);
            super.writeTo(output);
        }

        @Override
        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeInt32Size(1, this.errCode);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(2, this.errMsg);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(3, this.from);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(4, this.text);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(5, this.topic);
            return size;
        }

        @Override
        public SendMessageResponse mergeFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    default: {
                        if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
                            return this;
                        }
                        break;
                    }
                    case 8: {
                        this.errCode = input.readInt32();
                        break;
                    }
                    case 18: {
                        this.errMsg = input.readString();
                        break;
                    }
                    case 26: {
                        this.from = input.readString();
                        break;
                    }
                    case 34: {
                        this.text = input.readString();
                        break;
                    }
                    case 42: {
                        this.topic = input.readString();
                        break;
                    }
                }
            }
        }

        public static SendMessageResponse parseFrom(byte[] data)
                throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return com.google.protobuf.nano.MessageNano.mergeFrom(new SendMessageResponse(), data);
        }

        public static SendMessageResponse parseFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            return new SendMessageResponse().mergeFrom(input);
        }
    }
}
