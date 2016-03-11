# Keep
https://forums.linuxmint.com/viewtopic.php?f=42&t=160527

## Try
http://askubuntu.com/questions/557906/problem-starting-jack-server-jack-server-is-not-running-or-cannot-be-started

# install
sudo apt-get -y install jackd2 qjackctl alsaplayer alsaplayer-jack vlc 

Start(){
  sudo xl create /home/me/Desktop/Windows.cfg
  


sudo su
qjackctl &
jack_load netmanager

# Test
alsaplayer -o jack ~/Downloads/Allegro.mp3

}
