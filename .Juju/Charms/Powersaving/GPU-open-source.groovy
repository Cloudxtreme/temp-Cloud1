#	I'm getting as low as 62.0°C with 'profile'!

Info(){
	# Check info
	cat /proc/cmdline
	cat /sys/kernel/debug/dri/0/radeon_pm_info

	# Which method?
	cat /sys/class/drm/card0/device/power_method

	# dpm
	cat /sys/class/drm/card0/device/power_dpm_state
	cat /sys/class/drm/card0/device/power_dpm_force_performance_level

	# profile
	cat /sys/class/drm/card0/device/power_profile
}

Temperature(){
	# Temperature & Benchmark
	dnf -y install lm_sensors glmark2
	glmark2 &

	watch sensors
}


On(){
	# https://wiki.archlinux.org/index.php/ATI#Powersaving
	#	su required

	dpm(){
		# Dynamic power management - hardware based
		# Grub radeon.dpm on
		echo battery > /sys/class/drm/card0/device/power_dpm_state
		echo low > /sys/class/drm/card0/device/power_dpm_force_performance_level

	}
	
	Grub_radeon_dpm_off(){
		# Grub radeon.dpm off
		ansible! *add radeon.dpm=0 to /etc/default/grub
		grub2-mkconfig -o /boot/grub2/grub.cfg
		reboot
	}

	dynpm(){
		# Dynamic frequency switching
	}

	profile(){
		# Profile-based frequency switching
		echo profile > /sys/class/drm/card0/device/power_method
		echo low > /sys/class/drm/card0/device/power_profile
	}

	persist_configuration(){
		# https://wiki.archlinux.org/index.php/ATI#Persistent_configuration
		
	}
}