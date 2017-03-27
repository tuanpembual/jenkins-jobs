String app = "Btech"

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
tar -czvf dist.tar.gz dist
echo "sukses"''')   
    }
    publishers{
	archiveArtifacts {
            pattern("dist.tar.gz")
            onlyIfSuccessful()
        }
    }
}

job("${app}/slavejobs") {
    description "Coba build gradle"
    label("slave")
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
    steps {
        shell('echo "sukses dari slave"')   
    }
}
