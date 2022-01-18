package com.test.chat.matrix.service;

import com.test.chat.matrix.model.ChatModel;
import com.test.chat.matrix.model.MessageContentModel;
import com.test.chat.matrix.utils.SynapseRestHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final SynapseRestHelper synapseRestHelper;

    public ChatModel getAll(String accessToken, String roomId, String previousBatchEnd) {
        String url = nonNull(previousBatchEnd) ? format("/rooms/%s/messages?dir=f&from=%s", roomId, previousBatchEnd) : format("/rooms/%s/messages?dir=b", roomId);
        return synapseRestHelper.get(accessToken, url, ChatModel.class);
    }

    public MessageContentModel send(String accessToken, MessageContentModel messageContentModel) {
        return synapseRestHelper.exchange(accessToken, format("/rooms/%s/send/m.room.message", messageContentModel.getRoomId()), POST, messageContentModel, MessageContentModel.class);
    }
}