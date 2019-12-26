
# spring-rest-jackson-jsonview
Spring boot demo project to demonstrate use of Jackson JsonView and it's spring integration to provide different views of same model for different REST endpoint needs.

## Overview
Most of the time we come across requirements in application where, we want to provide different views of same model data to different clients/users.

We may want to hide some part of model state from at different places, in order to cater this requirement, we end up creating multiple models/DTO or inheritence leves to represent different views of same state to different clients. 

When we have limited views or limited fieds in model state, this solution may work but, as a need for different combination of state requires and when we have hundereds of fields in model's state, managing different models/DTOs for each view becomes very cumbersome and results in duplication of state.

## Jackson's JsonView comes to rescue
Jacksons solves the above problem via **`JsonView`**. As it's name indicate, it allows us to create different views of model (state) as required.
We do not need to create models for each view, rather view is determined using medata information at model fields.

We can define view as a class or interface and then use **@`JsonView`** annotation to define which field of model belongs to which view.  Field can belong to multiple views.

Jackson reads these @JsonView annotations on fields while serialization/de-serialization of objects. We simply need to pass view to **`ObjectMapper`** while performing serializatin/de-serialization and jackson mapps only those fields which are part of provided view and skips all other fields in model state.

## Spring Integration
Spring has supports jackson's JsonView during request/response serialization/de-serialization using **`MessageConverter`** (specifically **`MappingJackson2HttpMessageConverter`**).

We can use same **@`JsonView` annotation** at handler method to specify view to be used to serialize content to response and at handler method argumet with **`@RequestBody`**, which will parse request body using provided view.

This features greatly helps us to maintain application consistency and fine- grained configuration of model state to be serialized and deserialized.

## How to use?
Create docker image using **Dockerfile**

    docker image build -t {tagName} .

Run docker image,

    sudo docker run -d -p 8080:8080 {image}

## Endpoints to check
Get endpoints for resource User provides different view for different clients,
For example,

    GET -   http://localhost:8080/int/users
Above endpoint provides more details of user resource since it is internal API
where as,

    GET -   http://localhost:8080/ext/users
Provides limited details of user resource since this is public facing API.

Similarly,
POST and PUT API uses different views to restrict fields allowed to post/update in respective calls.

 

