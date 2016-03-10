# Convert to functions
sudo btrfs sub create /bb
sudo btrfs sub snap -r / /bb/archive.clean-install
sudo btrfs sub snap -r / /bb/current
sudo btrfs sub delete /bb/current
