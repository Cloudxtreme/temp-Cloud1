vg=debian-vg
lv=windows
snap='-i'
size=15

sudo lvcreate -s -n $lv$snap -L ${size}g $vg/$lv
sudo lvs
