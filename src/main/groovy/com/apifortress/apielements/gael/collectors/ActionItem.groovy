package com.apifortress.apielements.gael.collectors

import com.apifortress.apielements.gael.HttpHeaders
import com.apifortress.apielements.gael.HttpRequest
import com.apifortress.apielements.gael.HttpResponse
import com.apifortress.apielements.gael.MessageBody

/**
 * The item for the ActionsCollector collector. An ActionItem should contain all the information
 * to perform an I/O action
 */
class ActionItem {
    /**
     * By descending the resource tree, we collect all the "titles" we encounter, in case we need them
     */
    def titles = []
    /**
     * The collected HREF
     */
    String href
    /**
     * The method
     */
    String method
    /**
     * The HttpRequest object
     */
    HttpRequest request
    /**
     * A shortcut to the request message body
     */
    MessageBody requestMessageBody

    HttpHeaders requestHttpHeaders

    /**
     * merging in one collector all the href variables we encounter
     */
    HrefVariablesCollector hrefVariablesCollector

    /**
     * A collection of responses, in case there's more than one
     */
    Set<HttpResponse> responses = new TreeSet<HttpResponse>(new Comparator<HttpResponse>() {
        @Override
        int compare(HttpResponse o1, HttpResponse o2) {
            if(o1.attrStatusCode == null || o2.attrStatusCode)
                return -1
            return Integer.valueOf(o1.attrStatusCode)-Integer.valueOf(o2.attrStatusCode)
        }
    })

    /**
     * Adding a title to the titles collection
     * @param title a title
     */
    void addTitle(String title){
        if(title!=null) titles.add(title)
    }

    /**
     * Adds an HttpResponse to the responses collection
     * @param response an HttpResponse element
     */
    void addResponse(HttpResponse response){
        responses.add(response)
    }

    /**
     * Sets the HREF. If the passed parameter is null, then it's ignored
     * @param href the HREF string
     */
    void setHref(String href){
        if(href!=null) this.href = href
    }

    /**
     * sets the METHOD. If the passed parameter is null, then it's ignored
     * @param method the METHOD string
     */
    void setMethod(String method){
        if(method!=null) this.method = method
    }

    /**
     * Clones the ActionItem by cloning the key components.
     * ATTENTION: complex objects such as HttpRequest and HttpResponse won't be cloned as they're
     * the last step before being added in the collector
     * @return a partially cloned ActionItem
     */
    ActionItem clone(){
        ActionItem cloned = new ActionItem()
        cloned.titles = this.titles.clone()
        cloned.method = this.method
        cloned.href = this.href
        return cloned
    }

    /**
     * Determines the request content type. If a message body is present, the information is derived from there,
     * otherwise a "Content-Type" header is obtained by the request headers.
     * This method may return null if no information is available
     * @return the detected content-type
     */
    public String getRequestContentType(){
        String ct = null
        if(requestMessageBody)
            ct = requestMessageBody.contentType
        if(ct == null)
            ct = request.getContentTypeHeader()
        return ct
    }
}
