String app = "BelajarJenkins"

folder("${app}") {
  description "ini adalah description"
}

job("${app}/BuildNPM") {
    description "Coba build gradle"
    logRotator {
        daysToKeep(7)
        numToKeep(10)
    }
    scm {
        git {
            remote {
                url('https://github.com/tuanpembual/blankon-linux-static-web.git')
            }
            branch('master')
        }
    }
    triggers {
        scm('H/2 * * * *')
    } 

    steps {
     	shell('''npm install
npm run build
tar -czvf dist.tar.gz dist''')   
    }
    publishers{
	archiveArtifacts {
            pattern("dist.tar.gz")
            onlyIfSuccessful()
        }
    }
}
