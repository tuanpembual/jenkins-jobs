#Jenkins Jobs

This repo contains groovy scripts which are used to create jobs in our
jenkins server.Following are some of the conventions that will be used.

1. The name of the project should be in camel case and without dash or
   underscore.
2. Each project should have
    *Specs* => *Package* => *Staging Deploy* => *Production Deploy*
3. All of the above builds and jobs should be in a folder whose name
   again will be in camel case
4. No one will edit any build manually on CI. This is strictly
   prohobited.Your changes will be removed because we run seed job after
regular intervals and it will overwrite the config changes.
5. If you install any jenkins plugin for your build, please inform the
   infra team so that we add the change to our chef recipes.
6. We use jenkins job dsl plugin to create jenkins job. Jenkins job dsl
   uses groovy scripts and gives us jobs on the User interface. Everyone
is supposed to use the same for creating their builds.
7. If you want your project to be on CI, you have to create the test and
   package build.You can submit a pull request and devops team will
merge it after testing it
8. There is a seed job build in CI which creates the ci jobs from
   repository.It polls github for new commits and runs automaticaly on
change
9. Please dont leave the seed job build **RED**. This is a common build
   and
   other projects are dependent on you. If your commit is causing error
it is your responsibility to fix it in as less time as possible. **At
the
day's end the build should be Green**
10. Bundler and fpm gems are installed by default. Please dont try any
    gem installation through build. It will fail. Also please run bundle
install --path .local to install gems required.


## Pipelines

Here are some of links for jenkins job dsl documentation.


1. **Getting Started** :-
   https://github.com/jenkinsci/job-dsl-plugin/wiki/Tutorial---Using-the-Jenkins-Job-DSL
2. **API Viewer**:- https://jenkinsci.github.io/job-dsl-plugin/

-An example [Job DSL](https://github.com/jenkinsci/job-dsl-plugin)
project that uses Gradle for building and testing. Check out [this
presentation](https://www.youtube.com/watch?v=SSK_JaBacE0) for a
walkthrough of this example (starts around 14:00).
