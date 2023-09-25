package com.go2geda.user.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.go2geda.utils.AppUtils.APP_EMAIL;
import static com.go2geda.utils.AppUtils.APP_NAME;

@Setter @Getter
public class EmailSenderRequest {
    private final MailInfo sender = new MailInfo(APP_NAME, APP_EMAIL);
//    @JsonProperty("to")
    private List<MailInfo> to;
//    @JsonProperty("cc")
    private String subject;
//    @JsonProperty("htmlContent")
    private String htmlContent;
}
