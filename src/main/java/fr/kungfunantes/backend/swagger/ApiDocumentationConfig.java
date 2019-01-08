package fr.kungfunantes.backend.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Sports Club Resources",
                version = "V0.1",
                title = "Sports Club API",
                contact = @Contact(
                   name = "Nassim Berrichi", 
                   email = "kungfu.nantes@gmail.com", 
                   url = "http://www.kungfu-nantes.fr"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        externalDocs = @ExternalDocs(value = "More information on Wushu sports", url = "http://kungfu-nantes.fr"),
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
)
public interface ApiDocumentationConfig {

}