FROM ruby:2.4.0-alpine
MAINTAINER cxpqwvtj

#RUN apk add --update bash libstdc++ nodejs && rm -rf /var/cache/apk/*

WORKDIR /app

ADD Gemfile /app/Gemfile
ADD Gemfile.lock /app/Gemfile.lock

RUN gem install bundler && \
bundle install

CMD ["bundle", "exec", "prmd", "combine", "--meta", "docs/schema/meta.yml", "docs/schema/schemata/", ">", "docs/schema/schema.json"]
       