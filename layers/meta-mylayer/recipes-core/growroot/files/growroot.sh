#!/bin/sh
DEV=/dev/mmcblk0
parted -s "$DEV" resizepart 2 100% || exit 1
partprobe "$DEV" 2>/dev/null || true
resize2fs "${DEV}p2" && touch /etc/growroot.done