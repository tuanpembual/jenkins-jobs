String app = "BelajarJenkins"

folder("${app}") {
  description "ini adalah description"
}

job("${app}/BuildGradle") {
    description "Coba build gradle"
    logRotator {
        daysToKeep(7)
        numToKeep(10)
    }
    triggers {
        scm('H/2 * * * *')
    } 

    steps {
        gradle {
            tasks('clean test')
        }
    }

    publishers {
        mailer('mail@example.com', false, true)
    }
}