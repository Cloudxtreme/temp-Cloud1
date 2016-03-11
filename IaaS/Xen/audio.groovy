# Keep
https://forums.linuxmint.com/viewtopic.php?f=42&t=160527

## Try
http://askubuntu.com/questions/557906/problem-starting-jack-server-jack-server-is-not-running-or-cannot-be-started

# install
sudo apt-get -y install jackd2 qjackctl alsaplayer alsaplayer-jack vlc 

alsaplayer -o jack ~/Desktop/Allegro.mp3


Snapshot(){
  snap='-prejack' ; lv=windows ; vg=debian-vg ; size=15
  sudo lvremove /dev/$vg/$lv$snap
  sudo lvcreate -s -n $lv$snap -L ${size}g $vg/$lv
}


Start(){
  sudo xl create /home/me/Desktop/Windows.cfg
  
}
