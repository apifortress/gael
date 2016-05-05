package com.apifortress.apielements.gael.collectors

import com.apifortress.apielements.gael.HttpRequest
import com.apifortress.apielements.gael.HttpResponse
import com.apifortress.apielements.gael.MessageBody

/**
 *
 */
class ActionItem {
    def titles = []
    String href
    String method
    HttpRequest request
    MessageBody requestMessageBody
    HrefVariablesCollector hrefVariablesCollector

    def responses = []

    void addTitle(String title){
        if(title!=null) titles.add(title)
    }

    void addResponse(HttpResponse response){
        responses.add(response)
    }

    void setHref(String href){
        if(href!=null) this.href = href
    }

    void setMethod(String method){
        if(method!=null) this.method = method
    }

    ActionItem clone(){
        ActionItem cloned = new ActionItem()
        cloned.titles = this.titles.clone()
        cloned.method = this.method
        cloned.href = this.href
        return cloned
    }
}
