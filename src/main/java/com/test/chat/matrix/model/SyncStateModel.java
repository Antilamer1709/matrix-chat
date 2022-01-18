package com.test.chat.matrix.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SyncStateModel {

    @JsonAlias("rooms")
    private RoomInvitationModel invitationModel;

    @Data
    public static class RoomInvitationModel {

        private Map<String, Map<String, Map<String, List<InviteEventModel>>>> invite = new HashMap<>();

        @Data
        public static class InviteEventModel {

            private String type;
            private String sender;
            private InviteContentModel content;

            @Data
            public static class InviteContentModel {

                private String name;
                private String creator;
            }
        }
    }
}