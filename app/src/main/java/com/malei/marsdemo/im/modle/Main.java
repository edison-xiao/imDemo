package com.malei.marsdemo.im.modle;

/**
 * Created by malei on 2018/4/17.
 */

@SuppressWarnings("hiding")
public interface Main {

    // enum CmdID
    public static final int CMD_ID_INVALID = -1;
    public static final int CMD_ID_UNKNOWN = 0;
    public static final int CMD_ID_HELLO = 1;
    public static final int CMD_ID_AUTH = 2;
    public static final int CMD_ID_SEND_MESSAGE = 3;
    public static final int CMD_ID_CONVERSATION_LIST = 4;
    public static final int CMD_ID_JOINTOPIC = 5;
    public static final int CMD_ID_LEFTTOPIC = 7;

    public static final class HelloRequest extends
            com.google.protobuf.nano.MessageNano {

        private static volatile HelloRequest[] _emptyArray;
        public static HelloRequest[] emptyArray() {
            // Lazily initializes the empty array
            if (_emptyArray == null) {
                synchronized (
                        com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new HelloRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        // required string user = 1;
        public java.lang.String user;

        // required string text = 2;
        public java.lang.String text;

        // optional bytes dump_content = 3;
        public byte[] dumpContent;

        public HelloRequest() {
            clear();
        }

        public HelloRequest clear() {
            user = "";
            text = "";
            dumpContent = com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES;
            cachedSize = -1;
            return this;
        }

        @Override
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
                throws java.io.IOException {
            output.writeString(1, this.user);
            output.writeString(2, this.text);
            if (!java.util.Arrays.equals(this.dumpContent, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(3, this.dumpContent);
            }
            super.writeTo(output);
        }

        @Override
        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(1, this.user);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(2, this.text);
            if (!java.util.Arrays.equals(this.dumpContent, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
                size += com.google.protobuf.nano.CodedOutputByteBufferNano
                        .computeBytesSize(3, this.dumpContent);
            }
            return size;
        }

        @Override
        public HelloRequest mergeFrom(
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
                        this.user = input.readString();
                        break;
                    }
                    case 18: {
                        this.text = input.readString();
                        break;
                    }
                    case 26: {
                        this.dumpContent = input.readBytes();
                        break;
                    }
                }
            }
        }

        public static HelloRequest parseFrom(byte[] data)
                throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return com.google.protobuf.nano.MessageNano.mergeFrom(new HelloRequest(), data);
        }

        public static HelloRequest parseFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            return new HelloRequest().mergeFrom(input);
        }
    }

    public static final class HelloResponse extends
            com.google.protobuf.nano.MessageNano {

        private static volatile HelloResponse[] _emptyArray;
        public static HelloResponse[] emptyArray() {
            // Lazily initializes the empty array
            if (_emptyArray == null) {
                synchronized (
                        com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new HelloResponse[0];
                    }
                }
            }
            return _emptyArray;
        }

        // required int32 retcode = 1;
        public int retcode;

        // optional string errmsg = 2;
        public java.lang.String errmsg;

        // optional bytes dump_content = 3;
        public byte[] dumpContent;

        public HelloResponse() {
            clear();
        }

        public HelloResponse clear() {
            retcode = 0;
            errmsg = "";
            dumpContent = com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES;
            cachedSize = -1;
            return this;
        }

        @Override
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
                throws java.io.IOException {
            output.writeInt32(1, this.retcode);
            if (!this.errmsg.equals("")) {
                output.writeString(2, this.errmsg);
            }
            if (!java.util.Arrays.equals(this.dumpContent, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(3, this.dumpContent);
            }
            super.writeTo(output);
        }

        @Override
        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeInt32Size(1, this.retcode);
            if (!this.errmsg.equals("")) {
                size += com.google.protobuf.nano.CodedOutputByteBufferNano
                        .computeStringSize(2, this.errmsg);
            }
            if (!java.util.Arrays.equals(this.dumpContent, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
                size += com.google.protobuf.nano.CodedOutputByteBufferNano
                        .computeBytesSize(3, this.dumpContent);
            }
            return size;
        }

        @Override
        public HelloResponse mergeFrom(
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
                        this.retcode = input.readInt32();
                        break;
                    }
                    case 18: {
                        this.errmsg = input.readString();
                        break;
                    }
                    case 26: {
                        this.dumpContent = input.readBytes();
                        break;
                    }
                }
            }
        }

        public static HelloResponse parseFrom(byte[] data)
                throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return com.google.protobuf.nano.MessageNano.mergeFrom(new HelloResponse(), data);
        }

        public static HelloResponse parseFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            return new HelloResponse().mergeFrom(input);
        }
    }

    public static final class Conversation extends
            com.google.protobuf.nano.MessageNano {

        private static volatile Conversation[] _emptyArray;
        public static Conversation[] emptyArray() {
            // Lazily initializes the empty array
            if (_emptyArray == null) {
                synchronized (
                        com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Conversation[0];
                    }
                }
            }
            return _emptyArray;
        }

        // required string topic = 1;
        public java.lang.String topic;

        // required string notice = 2;
        public java.lang.String notice;

        // required string name = 3;
        public java.lang.String name;

        public Conversation() {
            clear();
        }

        public Conversation clear() {
            topic = "";
            notice = "";
            name = "";
            cachedSize = -1;
            return this;
        }

        @Override
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
                throws java.io.IOException {
            output.writeString(1, this.topic);
            output.writeString(2, this.notice);
            output.writeString(3, this.name);
            super.writeTo(output);
        }

        @Override
        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(1, this.topic);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(2, this.notice);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(3, this.name);
            return size;
        }

        @Override
        public Conversation mergeFrom(
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
                        this.notice = input.readString();
                        break;
                    }
                    case 26: {
                        this.name = input.readString();
                        break;
                    }
                }
            }
        }

        public static Conversation parseFrom(byte[] data)
                throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return com.google.protobuf.nano.MessageNano.mergeFrom(new Conversation(), data);
        }

        public static Conversation parseFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            return new Conversation().mergeFrom(input);
        }
    }

    public static final class ConversationListRequest extends
            com.google.protobuf.nano.MessageNano {

        // enum FilterType
        public static final int DEFAULT = 0;
        public static final int ALL = 1;
        public static final int NEAR_BY = 2;
        public static final int FRIENDS = 3;
        public static final int HOT = 4;

        private static volatile ConversationListRequest[] _emptyArray;
        public static ConversationListRequest[] emptyArray() {
            // Lazily initializes the empty array
            if (_emptyArray == null) {
                synchronized (
                        com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ConversationListRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        // required string access_token = 1;
        public java.lang.String accessToken;

        // required int32 type = 2;
        public int type;

        public ConversationListRequest() {
            clear();
        }

        public ConversationListRequest clear() {
            accessToken = "";
            type = 0;
            cachedSize = -1;
            return this;
        }

        @Override
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
                throws java.io.IOException {
            output.writeString(1, this.accessToken);
            output.writeInt32(2, this.type);
            super.writeTo(output);
        }

        @Override
        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeStringSize(1, this.accessToken);
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
                    .computeInt32Size(2, this.type);
            return size;
        }

        @Override
        public ConversationListRequest mergeFrom(
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
                    case 16: {
                        this.type = input.readInt32();
                        break;
                    }
                }
            }
        }

        public static ConversationListRequest parseFrom(byte[] data)
                throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return com.google.protobuf.nano.MessageNano.mergeFrom(new ConversationListRequest(), data);
        }

        public static ConversationListRequest parseFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            return new ConversationListRequest().mergeFrom(input);
        }
    }

    public static final class ConversationListResponse extends
            com.google.protobuf.nano.MessageNano {

        private static volatile ConversationListResponse[] _emptyArray;
        public static ConversationListResponse[] emptyArray() {
            // Lazily initializes the empty array
            if (_emptyArray == null) {
                synchronized (
                        com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ConversationListResponse[0];
                    }
                }
            }
            return _emptyArray;
        }

        // repeated .com.tencent.mars.sample.proto.Conversation list = 1;
        public Main.Conversation[] list;

        public ConversationListResponse() {
            clear();
        }

        public ConversationListResponse clear() {
            list = Main.Conversation.emptyArray();
            cachedSize = -1;
            return this;
        }

        @Override
        public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
                throws java.io.IOException {
            if (this.list != null && this.list.length > 0) {
                for (int i = 0; i < this.list.length; i++) {
                    Main.Conversation element = this.list[i];
                    if (element != null) {
                        output.writeMessage(1, element);
                    }
                }
            }
            super.writeTo(output);
        }

        @Override
        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.list != null && this.list.length > 0) {
                for (int i = 0; i < this.list.length; i++) {
                    Main.Conversation element = this.list[i];
                    if (element != null) {
                        size += com.google.protobuf.nano.CodedOutputByteBufferNano
                                .computeMessageSize(1, element);
                    }
                }
            }
            return size;
        }

        @Override
        public ConversationListResponse mergeFrom(
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
                        int arrayLength = com.google.protobuf.nano.WireFormatNano
                                .getRepeatedFieldArrayLength(input, 10);
                        int i = this.list == null ? 0 : this.list.length;
                        Main.Conversation[] newArray =
                                new Main.Conversation[i + arrayLength];
                        if (i != 0) {
                            java.lang.System.arraycopy(this.list, 0, newArray, 0, i);
                        }
                        for (; i < newArray.length - 1; i++) {
                            newArray[i] = new Main.Conversation();
                            input.readMessage(newArray[i]);
                            input.readTag();
                        }
                        // Last one without readTag.
                        newArray[i] = new Main.Conversation();
                        input.readMessage(newArray[i]);
                        this.list = newArray;
                        break;
                    }
                }
            }
        }

        public static ConversationListResponse parseFrom(byte[] data)
                throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
            return com.google.protobuf.nano.MessageNano.mergeFrom(new ConversationListResponse(), data);
        }

        public static ConversationListResponse parseFrom(
                com.google.protobuf.nano.CodedInputByteBufferNano input)
                throws java.io.IOException {
            return new ConversationListResponse().mergeFrom(input);
        }
    }
}

