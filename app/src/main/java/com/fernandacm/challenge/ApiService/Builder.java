package com.fernandacm.challenge.ApiService;

public class Builder {
    private static Builder ServiceBuilder;
    /**
     * Instance of the services to use.
     */
    private Service Service;

    /**
     * Create a new instance of the PreDenunciaServiceBuilder
     * to consume the services for the image using {@link BaseServiceBuilder#Build()} method.
     */

    private Builder(){
        Service = BaseServiceBuilder.Build().create(Service.class);
    }

    /**
     * Gets and validate de corresponding credentials for the instance
     * that is going to return.
     * @return The service for the web api.
     */

    public static Service Build(){
        if(ServiceBuilder ==null){
            ServiceBuilder =  new Builder();
        }
        return ServiceBuilder.Service;
    }
}
