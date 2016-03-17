# Use Samba to develop from Windows!
#   https://wiki.debian.org/SambaServerSimple
apt-get install samba -y


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

# user
adduser me
adduser me sudo
smbpasswd -a me
