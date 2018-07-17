
#  Prod Trak
### Building out a model to demonstrate competence in the major technical components of the MRC tech stack. 

## I. Tech Stack
|name|function|
|----|--------|
|gradle|build agent|
|java|language|
|spring boot|application platform|
|mongoDB|database|
|Jersey|RESTful web service framework|
|Jackson|JSON processor|
|JavaScript|Front end Base Language|
|React|JS UI Framework|
|Express|Proxy Server|
|ADFS|Auth*|
|Docker|Deployment|

## II. Project Structure
## III. Challenges
####1. Mongo DB Configuration

### 2. Add and Remove Domain objects from DB

The challenge here is being able to take in a userId, find a user based off of that ID, and then remove that user from the mongoDB. 
	
I started by hitting the `UserResource` with a DELETE request and payload of `{"id": {userId}}`. 
	

It was receiving the payload fine, but when attempting to query the repository, it would use the whole JSON object instead of {userId}. My first attempt to fix this was to have the endpoint's parameter take in a custom object, `DeleteRequest` instead of `String`. 

This is when I began to research how to consume JSON in java. I knew we were using Jackson and Jersey, but it wasn't exactly clear to me how. 

Further research on how to access mongoDB with REST revealed that instead of sending the id in the payload, I could send it in the path. 

### 3. Testing
Endpoints were working, but tests were failing. I had struggled with setting up a mock mongo repository, and initially focused on getting functionality. Now that everything was working I wanted to make sure that I took a step back to find out how to get everything green again. 

*TDD is hard...*

##### 3a. In Memory Data Testing in H.I
The `MemoryRepository` in H.I avoids needing to spin up a real mongodb to run unit tests. This makes build time an order of magnitude faster then the case of using an actual DB. Martin Fowler has a [great article][1] on the subject.








[1]: https://martinfowler.com/bliki/InMemoryTestDatabase.html


