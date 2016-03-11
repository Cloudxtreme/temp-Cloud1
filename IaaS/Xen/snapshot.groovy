vg=debian-vg
lv=windows
snap='-i'
size=15

# OR
snap='-prejack' ; lv=windows ; vg=debian-vg ; size=15

Snapshot(){
  sudo lvremove /dev/$vg/$lv$snap
  sudo lvcreate -s -n $lv$snap -L ${size}g $vg/$lv
  sudo lvs
}


Restore(){
  # https://www.google.com/search?q=lvm+restore+snapshot
}

