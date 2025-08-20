package com.badaklng.lib.model.response.util;

import com.badaklng.lib.model.request.util.TemplateParameter;

import java.util.List;

@lombok.Data
public class MessageLog {
    private String id;
    private String organization_id;
    private String messages_broadcast_id;
    private String contact_phone_number;
    private String contact_full_name;
    private String status;
    private String whatsapp_message_id;
    private String whatsapp_error_message;
    private MessagesResponse messages_response;
    private Messages messages;
    private String created_at;
    private boolean is_pacing;
    private String channel_integration_id;

    @lombok.Data
    public static class MessagesResponse {
        private Sent sent;
        private List<Contact> contacts;
        private List<Message> messages;
        private Delivered delivered;
        private String messaging_product;

        @lombok.Data
        public static class Status {
            private String id;
            private String status;
            private Pricing pricing;
            private String timestamp;
            private Conversation conversation;
            private String recipient_id;

            @lombok.Data
            public static class Pricing {
                private String type;
                private boolean billable;
                private String category;
                private String pricing_model;
            }

            @lombok.Data
            public static class Conversation {
                private String id;
                private Origin origin;
                private String expiration_timestamp;

                @lombok.Data
                public static class Origin {
                    private String type;
                }
            }
        }

        @lombok.Data
        public static class Sent {
            private String webhook;
            private List<Status> statuses;
        }

        @lombok.Data
        public static class Contact {
            private String input;
            private String wa_id;
        }

        @lombok.Data
        public static class Message {
            private String id;
            private String message_status;
        }

        @lombok.Data
        public static class Delivered {
            private String webhook;
            private List<Status> statuses;
        }
    }

    @lombok.Data
    public static class Messages {
        private Body body;
        private Header header;
        private Buttons buttons;

        @lombok.Data
        public static class Body {
            private String type;
            private String template;
            private List<TemplateParameter> parameters;
        }

        @lombok.Data
        public static class Header {
            private String type;
            private String template;
            private List<TemplateParameter> parameters;
        }

        @lombok.Data
        public static class Buttons {
            private String type;
            private String template;
            private List<TemplateParameter> parameters;
        }
    }
}
