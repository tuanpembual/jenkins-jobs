Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/xenial64"
  config.vm.provider "virtualbox" do |vb|
    vb.memory = "1024"
  end

  config.vm.define :jenkins do |jenkins|
    jenkins.vm.host_name="jenkins"
    jenkins.vm.network "private_network", ip: "192.168.33.13"
    jenkins.vm.synced_folder "/home/nona/vagrant/github/jenkins-jobs", "/var/lib/jenkins/jobs/seed-job/workspace", :owner => "jenkins", :group => "jenkins"

    #jenkins.vm.provision "shell", inline: <<-SHELL
    #  wget -q -O - https://jenkins-ci.org/debian/jenkins-ci.org.key | sudo apt-key add -
    #  sudo sh -c 'echo deb http://pkg.jenkins-ci.org/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
    #  sudo apt-get update
    #  sudo apt-get install -y jenkins default-jre git default-jdk ntp unzip
    #SHELL

    # add plugin
  end
  config.vm.define :worker do |worker|
    worker.vm.host_name="worker"
    worker.vm.network "private_network", ip: "192.168.33.15"
    
    worker.vm.provision "shell", inline: <<-SHELL
      sudo apt-get update
      sudo apt-get install -y default-jre git default-jdk ntp unzip
    SHELLz
    # download jar
  end
end
