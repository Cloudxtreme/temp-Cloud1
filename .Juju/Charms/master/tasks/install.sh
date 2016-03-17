# Install   http://docs.ansible.com/ansible/intro_installation.html#latest-releases-via-pip
apt-get install -y default-jdk git openjfx python-dev python-pip python-paramiko python-markupsafe
pip install ansible

hostnamectl set-hostname master
