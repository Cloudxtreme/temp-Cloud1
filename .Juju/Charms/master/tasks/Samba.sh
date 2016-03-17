# Use Samba to develop from Windows!
#   https://wiki.debian.org/SambaServerSimple
apt-get install samba -y

cp /etc/samba/smb.conf /etc/samba/smb.conf.bac

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
chmod 775 /home/Zen
#
adduser me sudo
smbpasswd -a me
#
systemctl smbd restart
