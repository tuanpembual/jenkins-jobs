Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/xenial64"
  #config.vm.box = "ubuntu/trusty64"
  #config.vm.box = "debian/jessie64"
  config.vm.provider "virtualbox" do |vb|
    vb.memory = "1024"
    #vb.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
  end

  config.vm.define :jenkins do |jenkins|
    jenkins.vm.host_name="jenkins"
    jenkins.ssh.username = "vagrant"
    jenkins.ssh.password = "vagrant"
    jenkins.vm.network "private_network", ip: "192.168.33.13" #"public_network", ip: "10.50.0.31""private_network", ip: "192.168.33.12" #, netmask: "255.255.224.0", bridge: "en0: Wi-Fi (AirPort)"
    jenkins.vm.synced_folder "/root/vagrant/trunks/ci/jenkins-jobs", "/var/lib/jenkins/jobs/seed-job/workspace", :owner => "jenkins", :group => "jenkins"

    jenkins.vm.provision "shell", inline: <<-SHELL
      wget -q -O - https://jenkins-ci.org/debian/jenkins-ci.org.key | sudo apt-key add -
      sudo sh -c 'echo deb http://pkg.jenkins-ci.org/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
      sudo apt-get update
      sudo apt-get install -y jenkins default-jre git default-jdk ntp unzip
    SHELL

    # add plugin
  end
end
