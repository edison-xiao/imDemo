package com.malei.marsdemo.im.modle;

/**
 * Created by malei on 2018/4/23.
 */

public interface Messagepush {

    public static final class MessagePush extends
            com.google.protobuf.nano.MessageNano {

        private static volatile MessagePush[] _emptyArray;
        public static MessagePush[] emptyArray() {
            // Lazily initializes the empty array
            if (_emptyArray == null) {
                synchronized (
                        com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MessagePush[0];
                    }
                }
            }
            return _emptyArray;
        }

        // required string topic = 1;
        public java.lang.String topic;

        // required string content = 2;
        public java.lang.String content;

        // required string from = 3;
        public java.lang.String from;

        public MessagePush() {
            clear();
        }

        public MessagePush clear() {
            topic = "";
            content = "";
            from = "";
            cachedSize = -1;
            return this;
        }

        @Override
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
                throws java.io.IOException {
            output.writeString(1, this.topic);
            output.writeString(2, this.content);
            output.writeString(3, this.from);
            super.writeTo(output);
        }

        @Override
        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(1, this.topic);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(2, this.content);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(3, this.from);
            return size;
        }

        @Override
        public MessagePush mergeFrom(
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
                        this.topic = input.readString();
                        break;
                    }
                    case 18: {
                        this.content = input.readString();
                        break;
                    }
                    case 26: {
                        this.from = input.readString();
                        break;
                    }
                }
            }
        }

        public static MessagePush parseFrom(byte[] data)
                throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return com.google.protobuf.nano.MessageNano.mergeFrom(new MessagePush(), data);
        }

        public static MessagePush parseFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            return new MessagePush().mergeFrom(input);
        }
    }
}

