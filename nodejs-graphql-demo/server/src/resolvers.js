const resolvers = {
  Query: {
    tracksForHome: async (_, __, { dataSources }) => {
      return dataSources.trackAPI.getTracksForHome();
    },

    track: async (_, args, { dataSources }) => {
      return dataSources.trackAPI.getTrack(args.id);
    },

    module: async (_, args, { dataSources }) => {
      return dataSources.trackAPI.getModule(args.id);
    },
  },

  Mutation: {
    incrementTrackViews: async (_, { id }, { dataSources }) => {
      try {
        const track = await dataSources.trackAPI.incrementTrackViews(id);
        return {
          code: 200,
          success: true,
          message: `Successfully incremented number of views for track ${id}`,
          track,
        };
      } catch (err) {
        return {
          code: err.extensions.response.status,
          success: false,
          message: err.extensions.response.body,
          track: null,
        };
      }
    },
  },

  Track: {
    //(parent, args, context, info)
    author: async ({ authorId }, _, { dataSources }) => {
      return dataSources.trackAPI.getAuthor(authorId);
    },
    modules: async ({ id }, _, { dataSources }) => {
      return dataSources.trackAPI.getModules(id);
    },
  },
};

module.exports = resolvers;
