package test.PeopleAPI

import test.builders.Requests
import spock.lang.Shared
import spock.lang.Specification

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class PeopleTests extends Specification{

    //Shared variables
    def details
    String skin_color

    //API URL
    @Shared
    def endpoint = "swapi.dev/api/people/"

    //1. Verify that a successful message is returned when a user searches for random R2-D2
    //2. Verify that R2_D2 color is white and blue
    def "Get R2-D2 Details"()
    {
        given: 'I want to search for R2-D2 Details'
        def url = "https://${endpoint}?search=R2-D2"

        when: 'I list R2-D2'
        def response = Requests.aRequest()
            .get(url).prettyPeek()

        details = response.jsonPath().prettify()
        skin_color = response.jsonPath().results[0].skin_color

        then:'status a successful message is retrieved'
        assert response.statusCode() == 200
        and: 'Verify that R2-D2 skin color is white and blue'
        assertThat(skin_color, equalToIgnoringCase("white, blue"))
    }


}
