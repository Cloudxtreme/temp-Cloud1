hostnamectl set-hostname master

# Install   http://docs.ansible.com/ansible/intro_installation.html#latest-releases-via-pip
apt-get install -y ansible git golang sshpass

pipAnsible(){
  #python-dev python-pip python-paramiko python-markupsafe
  pip install ansible
}
