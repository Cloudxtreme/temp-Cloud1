# Use Samba to develop from Windows!
#   https://wiki.debian.org/SambaServerSimple
hostnamectl set-hostname master

apt-get install samba -y

sed -i 's/workgroup = WORKGROUP/workgroup = MASTER/' /etc/samba/smb.conf
sed -i 's/read only = yes/read only = no/' /etc/samba/smb.conf
echo '''
[Zen]
   comment = Zen Cloud devel
   read only = no
   locking = no
   path = /home/Zen
   guest ok = yes
''' | tee -a /etc/samba/smb.conf
mkdir -p /home/Zen

#
adduser me
adduser me sudo
smbpasswd -a me

#
systemctl smbd restart

#  Test
touch  /home/Zen/test
apt-get install samba-client -y
ip=10.0.0.
smbclient //$ip/me

