#!/bin/bash

curl --location --request POST 'http://localhost:7777/api/interaction-example1/client-api/interaction/v2/interactions/interaction-example-1/actions/step-one-handler' \
--header 'Content-Type: application/json' \
--header 'Cookie: anonymousUserId=myFirstValue1; XSRF-TOKEN=3d7ecb03-74f4-4b2a-b29c-0645e6de9791' \
--data-raw '{
	"payload": {
        "firstName": "Andre",
        "lastName": "Mare"
    }
}'