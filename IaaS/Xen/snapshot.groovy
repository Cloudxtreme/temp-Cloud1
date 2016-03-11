vg=debian-vg
lv=windows
snap='-i'
size=15

sudo lvcreate -s -n $lv$snap -L ${size}g $vg/$lv
sudo lvs

Snapshot(){
  snap='-prejack' ; lv=windows ; vg=debian-vg ; size=15
  sudo lvremove /dev/$vg/$lv$snap
  sudo lvcreate -s -n $lv$snap -L ${size}g $vg/$lv
}


Restore(){
  # https://www.google.com/search?q=lvm+restore+snapshot
}

