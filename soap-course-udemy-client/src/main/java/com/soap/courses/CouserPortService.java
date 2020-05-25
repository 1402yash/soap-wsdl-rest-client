package com.soap.courses;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2020-05-25T23:19:13.565+05:30
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "CouserPortService",
                  wsdlLocation = "file:/C:/Users/yashag/git/soap-wsdl-rest-client/soap-course-udemy-client/src/main/resources/courses.wsdl",
                  targetNamespace = "http://soap.com/courses")
public class CouserPortService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.com/courses", "CouserPortService");
    public final static QName CouserPortSoap11 = new QName("http://soap.com/courses", "CouserPortSoap11");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/yashag/git/soap-wsdl-rest-client/soap-course-udemy-client/src/main/resources/courses.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CouserPortService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/yashag/git/soap-wsdl-rest-client/soap-course-udemy-client/src/main/resources/courses.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CouserPortService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CouserPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CouserPortService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CouserPortService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CouserPortService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CouserPortService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CouserPort
     */
    @WebEndpoint(name = "CouserPortSoap11")
    public CouserPort getCouserPortSoap11() {
        return super.getPort(CouserPortSoap11, CouserPort.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CouserPort
     */
    @WebEndpoint(name = "CouserPortSoap11")
    public CouserPort getCouserPortSoap11(WebServiceFeature... features) {
        return super.getPort(CouserPortSoap11, CouserPort.class, features);
    }

}
