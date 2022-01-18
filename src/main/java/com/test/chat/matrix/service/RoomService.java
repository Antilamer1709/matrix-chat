package com.test.chat.matrix.service;

import com.test.chat.matrix.model.JoinedRoomsModel;
import com.test.chat.matrix.model.RoomModel;
import com.test.chat.matrix.utils.SynapseRestHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final SynapseRestHelper synapseRestHelper;

    public List<String> getJoinedRooms(String accessToken) {
        return synapseRestHelper.get(accessToken, "/joined_rooms", JoinedRoomsModel.class).getJoinedRooms();
    }

    public RoomModel create(String accessToken, RoomModel roomModel) {
        return synapseRestHelper.exchange(accessToken, "/createRoom", POST, roomModel, RoomModel.class);
    }

    public RoomModel join(String accessToken, String roomId) {
        return synapseRestHelper.exchange(accessToken, format("/join/%s", roomId), POST, null, RoomModel.class);
    }
}