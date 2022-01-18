package com.test.chat.matrix.service;

import com.test.chat.matrix.model.InviteUserModel;
import com.test.chat.matrix.model.SyncStateModel;
import com.test.chat.matrix.utils.SynapseRestHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final SynapseRestHelper synapseRestHelper;

    public SyncStateModel.RoomInvitationModel getAllInvitations(String accessToken) {
        return synapseRestHelper.get(accessToken, "/sync", SyncStateModel.class).getInvitationModel();
    }

    public void inviteUser(String accessToken, String roomId, InviteUserModel inviteUserModel) {
        synapseRestHelper.exchange(accessToken, format("/rooms/%s/invite", roomId), POST, inviteUserModel);
    }
}