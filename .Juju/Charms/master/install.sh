# Install   http://docs.ansible.com/ansible/intro_installation.html#latest-releases-via-pip
apt-get install -y git python-dev python-pip python-paramiko python-markupsafe
pip install ansible

pip install markupsafe  # Only required for Debian 8!
