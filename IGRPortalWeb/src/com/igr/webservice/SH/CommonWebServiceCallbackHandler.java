
/**
 * CommonWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.igr.webservice.SH;

    /**
     *  CommonWebServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CommonWebServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CommonWebServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CommonWebServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getGovtPaymentEstampInfo method
            * override this method for handling normal response from getGovtPaymentEstampInfo operation
            */
           public void receiveResultgetGovtPaymentEstampInfo(
                    com.igr.webservice.SH.CommonWebServiceStub.GetGovtPaymentEstampInfoResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getGovtPaymentEstampInfo operation
           */
            public void receiveErrorgetGovtPaymentEstampInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCertCancelRefundDetails method
            * override this method for handling normal response from getCertCancelRefundDetails operation
            */
           public void receiveResultgetCertCancelRefundDetails(
                    com.igr.webservice.SH.CommonWebServiceStub.GetCertCancelRefundDetailsResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCertCancelRefundDetails operation
           */
            public void receiveErrorgetCertCancelRefundDetails(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSingleDayCertificateDetails method
            * override this method for handling normal response from getSingleDayCertificateDetails operation
            */
           public void receiveResultgetSingleDayCertificateDetails(
                    com.igr.webservice.SH.CommonWebServiceStub.GetSingleDayCertificateDetailsResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSingleDayCertificateDetails operation
           */
            public void receiveErrorgetSingleDayCertificateDetails(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for lockEStampCertificate method
            * override this method for handling normal response from lockEStampCertificate operation
            */
           public void receiveResultlockEStampCertificate(
                    com.igr.webservice.SH.CommonWebServiceStub.LockEStampCertificateResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from lockEStampCertificate operation
           */
            public void receiveErrorlockEStampCertificate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSingleCertificateDetails method
            * override this method for handling normal response from getSingleCertificateDetails operation
            */
           public void receiveResultgetSingleCertificateDetails(
                    com.igr.webservice.SH.CommonWebServiceStub.GetSingleCertificateDetailsResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSingleCertificateDetails operation
           */
            public void receiveErrorgetSingleCertificateDetails(java.lang.Exception e) {
            }
                


    }
    