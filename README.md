# GraphQL - [**S**]imple [**M**]ultilanguage [**S**]amples

In this repo I'd like to store and share some sample implementations of the GraphQL technology in differents environments, at first, in NodeJS using the Apollo Server and also, in Kotlin through the Spring Framework and it's latest release of the `spring-boot-starter-graphql` on `Spring v2.7.0-M1`

## The project (s)

At first, I was only playing around with the `Lift-off` series from the guys from [Apollo Odyssey](https://odyssey.apollographql.com/), and I had fun with this project, then I just created an equivalent implementation acessing the same [API](https://odyssey-lift-off-rest-api.herokuapp.com/docs/) of the Lift-off's Catstronaut project using the new `spring-boot-starter-graphql`

The best documentation you can find about this project(s) is reading the `Lift-off` serie, so go there and have some fun!

### Endpoints
* NodeJS (Apollo Server) - `http://localhost:4000/graphql`
* Kotlin (Spring Framework) - `http://localhost:8081/graphql`

There is also a docker-compose file if you just want to quickly test these implementations

### Schema (so far)

```graphql
type Query {
    "Query to get tracks array for the homepage grid"
    tracksForHome: [Track!]!
    "Fetch a specific track, provided a track's ID"
    track(id: ID!): Track!
    "Fetch a specific module, provided a module's ID"
    module(id: ID!): Module!
}

type Mutation {
    "Increment the number of views of a given track, when the track card is clicked"
    incrementTrackViews(id: ID!): IncrementTrackViewsResponse!
}

type IncrementTrackViewsResponse {
    "Similar to HTTP status code, represents the status of the mutation"
    code: Int!
    "Indicates whether the mutation was successful"
    success: Boolean!
    "Human-readable message for the UI"
    message: String!
    "Newly updated track after a successful mutation"
    track: Track
}

"A track is a group of Modules that teaches about a specific topic"
type Track {
    id: ID!
    "The track's title"
    title: String!
    "The track's main Author"
    author: Author!
    "The track's illustration to display in track card or track page detail"
    thumbnail: String
    "The track's approximate length to complete, in minutes"
    length: Int
    "The number of modules this track contains"
    modulesCount: Int
    "The track's complete description, can be in markdown format"
    description: String
    "The number of times a track has been viewed"
    numberOfViews: Int
    "The track's complete array of Modules"
    modules: [Module!]!
}

"Author of a complete Track or a Module"
type Author {
    id: ID!
    "Author's first and last name"
    name: String!
    "Author's profile picture"
    photo: String
}

"A Module is a single unit of teaching. Multiple Modules compose a Track"
type Module {
    id: ID!
    "The module's title"
    title: String!
    "The module's length in minutes"
    length: Int
    "The module's text-based description, can be in markdown format. In case of a video, it will be the enriched transcript"
    content: String
    "The module's video url, for video-based modules"
    videoUrl: String
}
```

---

In the future I may improve this repo, extending the existing schema and using some complementary technologies and good practices, for example, creating a scenario where we need to to avoid the N + 1 problem using DataLoader (wich has equivalent implementations in both environments) in our resolvers and data fetchers.
