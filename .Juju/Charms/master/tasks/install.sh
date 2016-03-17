hostnamectl set-hostname master

# Install   http://docs.ansible.com/ansible/intro_installation.html#latest-releases-via-pip
apt-get install -y git openjdk-8-jdk openjfx \
netbeans
apt-get install -y ansible sshpass

pipAnsible(){
  #python-dev python-pip python-paramiko python-markupsafe
  pip install ansible
}
